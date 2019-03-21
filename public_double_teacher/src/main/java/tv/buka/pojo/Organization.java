package tv.buka.pojo;

public class Organization {
    private Integer id;
    private Integer user_id;
    private String user_phone_num;
    private String user_nickname;
    private Long create_time;
    private Integer dt_permission;
    private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getuser_phone_num() {
        return user_phone_num;
    }

    public void setuser_phone_num(String user_phone_num) {
        this.user_phone_num = user_phone_num;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Integer getDt_permission() {
        return dt_permission;
    }

    public void setDt_permission(Integer dt_permission) {
        this.dt_permission = dt_permission;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        Integer user_role=0;
        switch (role){
            case 11:
                user_role=1;
                break;
            case 12:
                user_role=2;
                break;
            case 13:
                user_role=3;
                break;
            default:user_role=role;
        }
        this.role = user_role;
    }
}
