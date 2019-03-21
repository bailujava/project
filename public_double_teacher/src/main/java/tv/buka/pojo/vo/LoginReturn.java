package tv.buka.pojo.vo;



import java.util.List;

public class LoginReturn {
    private Integer id;
    private String password;
    private String username;
    private String nickname;
    private Integer department;
    private Integer role;
    private String user_token;
    private Integer create_id;
    private List<Integer> features;
    private Integer whether_record;
    private Integer whether_answerer;
    private Integer whether_onlineUsers;
    private ActiveUser activeUser;
    private  String  user_phone_num;
    private  String  user_extends;
    private  String  user_avatar_url;

    public String getUser_phone_num() {
        return user_phone_num;
    }

    public void setUser_phone_num(String user_phone_num) {
        this.user_phone_num = user_phone_num;
    }

    public String getUser_extends() {
        return user_extends;
    }

    public void setUser_extends(String user_extends) {
        this.user_extends = user_extends;
    }

    public String getUser_avatar_url() {
        return user_avatar_url;
    }

    public void setUser_avatar_url(String user_avatar_url) {
        this.user_avatar_url = user_avatar_url;
    }

    public ActiveUser getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(ActiveUser activeUser) {
        this.activeUser = activeUser;
    }

    public Integer getWhether_onlineUsers() {
        return whether_onlineUsers;
    }

    public void setWhether_onlineUsers(Integer whether_onlineUsers) {
        this.whether_onlineUsers = whether_onlineUsers;
    }

    public Integer getWhether_answerer() {
        return whether_answerer;
    }

    public void setWhether_answerer(Integer whether_answerer) {
        this.whether_answerer = whether_answerer;
    }

    public Integer getWhether_record() {
        return whether_record;
    }

    public void setWhether_record(Integer whether_record) {
        this.whether_record = whether_record;
    }

    public List<Integer> getFeatures() {
        return features;
    }

    public void setFeatures(List<Integer> features) {
        this.features = features;
    }

    public Integer getCreate_id() {
        return create_id;
    }

    public void setCreate_id(Integer create_id) {
        this.create_id = create_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        /*Integer user_role=0;
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
        }*/
        this.role = role;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }
}
