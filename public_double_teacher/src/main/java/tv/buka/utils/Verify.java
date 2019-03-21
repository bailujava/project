package tv.buka.utils;

import com.alibaba.fastjson.JSON;
import tv.buka.common.AccessToken;

import java.util.HashMap;
import java.util.Map;

public class Verify {
    public static Map<String,Object> verifyUser(String jsonString){
        Map<String,Object> m=new HashMap<String,Object>();

        HashMap<String,Object> map = (HashMap<String,Object>) JSON.parseObject(jsonString,HashMap.class);
        HashMap<String,Object> newmap=new  HashMap<String,Object>();
        if(map.get("user_cipher")==null) {
            newmap.put("user_token", map.get("user_token"));
            newmap.put("user_device", map.get("user_device"));
        }else{
            newmap.put("user_cipher",map.get("user_cipher"));
        }
        if (AccessToken.getInstance().check(newmap.get("user_token") + "",newmap.get("user_device")+"")){
            long user_id = AccessToken.getInstance().getIdByToken(newmap.get("user_token") + "").longValue();
            m.put("status",1);
            m.put("id",user_id);
            return m;
        }else {
            String url = HttpUrl.USER_CENTER.geturl()+"/user/info.do";
            String result = HttpClientUtil.doHttpClient(newmap, url);
            Map<String,Object> userMap = (HashMap<String,Object>) JSON.parseObject(result,HashMap.class);
            if (userMap.get("errorcode") == null || (Integer) userMap.get("errorcode") == 0) {
                long main_user_id = Long.parseLong(userMap.get("user_id") + "");
                m.put("status", 2);
                m.put("id", main_user_id);
                return m;
            } else {
                m.put("status", 0);
                m.put("id", 0);
                return m;
            }
        }
    }
}
