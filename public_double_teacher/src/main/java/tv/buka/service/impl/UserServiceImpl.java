package tv.buka.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.buka.common.AccessToken;
import tv.buka.dao.SsOrganizationMapper;
import tv.buka.dao.UserMapper;
import tv.buka.pojo.Organization;
import tv.buka.pojo.SysPermission;
import tv.buka.pojo.vo.ActiveUser;
import tv.buka.pojo.vo.LoginReturn;
import tv.buka.service.UserService;
import tv.buka.utils.*;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private SsOrganizationMapper ssOrganizationMapper;
    public static final String MAIN_NUM = "^\\d{11}$";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Object login(String jsonStr) {
        Map<String, Object> map = JSONObject.parseObject(jsonStr);
        String user_num = (String) map.get("username");
        if (user_num.isEmpty() || user_num == null) {
            return BaseResp.wrong("请输入账号");
        } else {
            if (!Pattern.matches(MAIN_NUM, user_num)) {
                LoginReturn user = userMapper.login(map);
                if (user != null) {
                    try {
                        Organization organization = ssOrganizationMapper.getOrganization(user.getCreate_id(), new Date().getTime() / 1000);
                        if (organization.getDt_permission() == 1) {
                            if (user.getRole() == 13) {
                                String user_token = AccessToken.getInstance().createAccessToken((int) user.getId(), System.currentTimeMillis(), map.get("user_device") + "");
                                user.setUser_token(user_token);
                                user.setRole(3);
                                user.setFeatures(opMapper.listfeature(user.getCreate_id()));
                                //临时加ActiveUser
                                HashMap<String, Object> arg = new HashMap<String, Object>();
                                arg.put("user_phone_num", user_num);
                                arg.put("user_password", map.get("password"));
                                arg.put("user_device", map.get("user_device"));
                               String resultstr  = HttpClientUtil.doHttpClient(arg, HttpUrl.URL.geturl() + "/user/login.do");

                                net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(resultstr);

                                HashMap<Object, Object> classMap = new HashMap<>();
                                classMap.put("activeUser", ActiveUser.class);
                                classMap.put("menus", SysPermission.class);
                                classMap.put("permissions",SysPermission.class);
                                classMap.put("role",Role2.class);

                                HashMap userMap =(HashMap) net.sf.json.JSONObject.toBean(jsonObject, HashMap.class, classMap);

//                                net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(resultstr);
//                                Map<String, Object> userMap = (HashMap<String, Object>) net.sf.json.JSONObject.toBean(json, HashMap.class);
                                if (userMap.get("errorcode") == null || (Integer) userMap.get("errorcode") == 0) { user.setActiveUser((ActiveUser) userMap.get("activeUser"));}

                                user.setUser_phone_num((String) userMap.get("user_phone_num"));
                                user.setUser_extends((String) userMap.get("user_extends"));
                                user.setUser_avatar_url((String) userMap.get("user_avatar_url"));
                                    return JSON.toJSONString(new BaseResp().put("data", user));
                            } else if (user.getRole() == 11 || user.getRole() == 12) {
                                return BaseResp.permit("该账号无后台登陆权限");
                            }
                        } else if (organization.getDt_permission() == 0) {
                            return BaseResp.permit("账号所在机构暂无双师权限");
                        } else {
                            return BaseResp.wrong("账号所在机构暂无双师权限");
                        }
                    } catch (Exception e) {
                        LOGGER.error("users/login.do" + " =======  " + e + "  ========  " + new Date());
                        return BaseResp.error();
                    }
                } else {
                    return BaseResp.permit("账号或密码错误");
                }
            } else {
                HashMap<String, Object> arg = new HashMap<String, Object>();
                arg.put("user_phone_num", user_num);
                arg.put("user_password", map.get("password"));
                arg.put("user_device", map.get("user_device"));
                String argstr = HttpClientUtil.doHttpClient(arg, HttpUrl.USER_CENTER.geturl() + "/user/login.do");
                try {
                    Map argmap = JSONObject.parseObject(argstr);
                    if (argmap.get("errorcode") == null || (Integer) argmap.get("errorcode") == 0) {
                        Map<String, Object> result = new HashMap<String, Object>();
                        result.put("user_token", argmap.get("token"));
                        result.put("user_device", map.get("user_device") + "");
                        HashMap<String, Object> hashresult = (HashMap<String, Object>) result;
                        String resultstr = HttpClientUtil.doHttpClient(hashresult, HttpUrl.USER_CENTER.geturl() + "/user/info.do");
                        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(resultstr);
                        Map<String, Object> userMap = (HashMap<String, Object>) net.sf.json.JSONObject.toBean(json, HashMap.class);
                        if (userMap.get("errorcode") == null || (Integer) userMap.get("errorcode") == 0) {
                            Organization organization = userMapper.getOrganization(Integer.valueOf(userMap.get("user_id") + ""), 0);
                            if (organization == null) {
                                userMap.put("create_time", System.currentTimeMillis() / 1000);
                                userMap.put("dt_permission", 0);
                                userMapper.insert(userMap);
                                return BaseResp.permit("账号暂无双师权限，如需开通请联系客服微信：bukasupport");
                            } else {
                                organization = userMapper.getOrganization(Integer.valueOf(userMap.get("user_id") + ""), new Date().getTime() / 1000);
                                if (organization == null) {
                                    return BaseResp.permit("该账号双师权限不在服务期限内，如需继续开通请联系客服微信：bukasupport");
                                } else {
                                    String nickname = organization.getUser_nickname();
                                    if (organization.getUser_nickname() == null) {
                                        nickname = String.valueOf(userMap.get("user_nickname"));
                                        userMapper.editorganization(userMap);
                                    }
                                    if (organization.getDt_permission() == 1) {
                                        LoginReturn user = new LoginReturn();
                                        user.setId(organization.getUser_id());
                                        user.setUsername(organization.getuser_phone_num());
                                        user.setPassword("");
                                        user.setNickname(nickname);
                                        user.setDepartment(0);
                                        user.setRole(organization.getRole());
                                        user.setUser_token((String) argmap.get("token"));
                                        user.setFeatures(opMapper.listfeature(Integer.valueOf(userMap.get("user_id") + "")));
                                        //临时加ActiveUser
                                        HashMap<String, Object> arg2 = new HashMap<String, Object>();
                                        arg2.put("user_phone_num", user_num);
                                        arg2.put("user_password", map.get("password"));
                                        arg2.put("user_device", map.get("user_device"));
                                        String resultstr2  =HttpClientUtil.doHttpClient(arg, HttpUrl.URL.geturl() + "/user/login.do");

                                        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(resultstr2);

                                        HashMap<Object, Object> classMap = new HashMap<>();
                                        classMap.put("activeUser",ActiveUser.class);
                                        classMap.put("menus",SysPermission.class);
                                        classMap.put("permissions",SysPermission.class);
                                        classMap.put("role",Role.class);

                                        HashMap hashMap =(HashMap) net.sf.json.JSONObject.toBean(jsonObject, HashMap.class, classMap);

                                        //HashMap hashMap = JSON.parseObject(resultstr2, HashMap.class);

                                        ActiveUser newUser = (ActiveUser)hashMap.get("activeUser");
                                        if (userMap.get("errorcode") == null || (Integer) userMap.get("errorcode") == 0) { user.setActiveUser(newUser);}

                                        user.setUser_phone_num((String) hashMap.get("user_phone_num"));
                                        user.setUser_extends((String) hashMap.get("user_extends"));
                                        user.setUser_avatar_url((String) hashMap.get("user_avatar_url"));
                                        return JSON.toJSONString(new BaseResp().put("data", user));
                                    } else {
                                        userMapper.updatecreatetime(organization.getId(), System.currentTimeMillis() / 1000);
                                        return BaseResp.permit("账号暂无双师权限，如需开通请联系客服微信：bukasupport");
                                    }
                                }
                            }
                        } else {
                            return BaseResp.wrong("账号或密码错误");
                        }
                    } else {
                        return BaseResp.wrong("账号或密码错误");
                    }
                } catch (NumberFormatException e) {
                    LOGGER.error("users/login.do" + " =======  " + e);
                    return BaseResp.error();
                }
            }
        }
        return BaseResp.error();
   
}
