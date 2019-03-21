package tv.buka.pojo;

public class SsOrganization {
    private Long id;

    private Long userId;

    private String userPhoneNum;

    private String userNickname;

    private Long createTime;

    private Long startTerm;

    private Long endTerm;

    private String avatar;

    private Byte dtPermission;

    private Byte role;

    private Long pid;

    private byte[] remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum == null ? null : userPhoneNum.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getStartTerm() {
        return startTerm;
    }

    public void setStartTerm(Long startTerm) {
        this.startTerm = startTerm;
    }

    public Long getEndTerm() {
        return endTerm;
    }

    public void setEndTerm(Long endTerm) {
        this.endTerm = endTerm;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Byte getDtPermission() {
        return dtPermission;
    }

    public void setDtPermission(Byte dtPermission) {
        this.dtPermission = dtPermission;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public byte[] getRemark() {
        return remark;
    }

    public void setRemark(byte[] remark) {
        this.remark = remark;
    }
}