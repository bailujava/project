package tv.buka.pojo;

import java.util.Date;

public class Role {
    private Integer roleId;

    private String roleName;

    private Integer pid;

    private Integer orgId;

    private String creator;

    private Date creationTime;

    private String fullId;

    private String fullName;
    public Role(){}

    public Role(Integer roleId) {
        this.roleId = roleId;
    }

    public Role(Integer roleId, String fullId) {
        this.roleId = roleId;
        this.fullId = fullId;
    }

    public Role(Integer roleId, String roleName, Integer pid, Integer orgId, String creator, Date creationTime, String fullId, String fullName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.pid = pid;
        this.orgId = orgId;
        this.creator = creator;
        this.creationTime = creationTime;
        this.fullId = fullId;
        this.fullName = fullName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}