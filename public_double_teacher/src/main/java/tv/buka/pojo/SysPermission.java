package tv.buka.pojo;

import java.io.Serializable;
import java.util.List;

public class SysPermission implements Serializable{
    private Integer id;

    private String name;

    private String url;

    private String percode;

    private Integer pid;

    private Byte type;

    private Byte status;

    private String  relationship;

    private List<SysPermission> permissions;

    public SysPermission() {
    }

    public SysPermission(Integer id, String name, String url, Integer pid, Byte type, Byte status, String relationship, List<SysPermission> permissions) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.type = type;
        this.status = status;
        this.relationship = relationship;
        this.permissions = permissions;
    }

    public SysPermission(Integer id, String name, String url, String percode, Integer pid, Byte type, Byte status, String relationship, List<SysPermission> permissions) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.percode = percode;
        this.pid = pid;
        this.type = type;
        this.status = status;
        this.relationship = relationship;
        this.permissions = permissions;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}