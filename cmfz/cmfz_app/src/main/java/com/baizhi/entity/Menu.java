package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String href;
    private String icon;
    private Integer pid;
    private List<Menu> list;
    public Menu(String title, String href, String icon, List<Menu> list) {
        this.title = title;
        this.href = href;
        this.icon = icon;
        this.list = list;
    }
    public Menu(Integer id, String title, String content, String href, String icon, Integer pid, List<Menu> list) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.href = href;
        this.icon = icon;
        this.pid = pid;
        this.list = list;
    }

    public Menu(String title, String href, String icon) {
        this.title = title;
        this.href = href;
        this.icon = icon;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", href='" + href + '\'' +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", list=" + list +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Menu> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(title, menu.title) &&
                Objects.equals(content, menu.content) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(icon, menu.icon) &&
                Objects.equals(pid, menu.pid) &&
                Objects.equals(list, menu.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, href, icon, pid, list);
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }
}