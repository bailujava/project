package tv.buka.pojo.vo;


import tv.buka.pojo.Role;
import tv.buka.pojo.SysPermission;

import java.io.Serializable;
import java.util.List;

public class ActiveUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userid; //用户id(主键)
    private List<SysPermission> menus; //菜单
    private List<SysPermission> permissions; //权限
    private String user_device;//用户登录的device
    private Long org_id;//所属主账号在buka_api的id
    private Long main_user_id;//该账号的主账号（如果该账号是主账号就他自己）在用户中心里面的user_id；
    private Integer num_type;//账号类型
    private List<Role>  role;//角色列表
    public ActiveUser(){}
    public ActiveUser(Integer userid, List<SysPermission> menus, List<SysPermission> permissions, String user_device, Long org_id, Long main_user_id, Integer num_type) {
        this.userid = userid;
        this.menus = menus;
        this.permissions = permissions;
        this.user_device = user_device;
        this.org_id = org_id;
        this.main_user_id = main_user_id;
        this.num_type = num_type;
    }



    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public Long getMain_user_id() {
        return main_user_id;
    }

    public void setMain_user_id(Long main_user_id) {
        this.main_user_id = main_user_id;
    }

    public String getUser_device() {
        return user_device;
    }

    public void setUser_device(String user_device) {
        this.user_device = user_device;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public Integer getNum_type() {
        return num_type;
    }

    public void setNum_type(Integer num_type) {
        this.num_type = num_type;
    }




    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public List<SysPermission> getMenus() {
        return menus;
    }
    public void setMenus(List<SysPermission> menus) {
        this.menus = menus;
    }
    public List<SysPermission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }



}
