package com.arch.entity;

/**
 * Created by zhou on 2016/5/20.
 *
 * @author zhou
 */

public class Picture {
    private String id;
    private String building_id;
    private String name;
    private String type;
    private String origin;
    private String desc;
    private String date;
    private String relative_designer;
    private String relative_org;
    private String create_time;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRelative_designer() {
        return relative_designer;
    }

    public void setRelative_designer(String relative_designer) {
        this.relative_designer = relative_designer;
    }

    public String getRelative_org() {
        return relative_org;
    }

    public void setRelative_org(String relative_org) {
        this.relative_org = relative_org;
    }
}
