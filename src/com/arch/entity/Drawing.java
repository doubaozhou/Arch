package com.arch.entity;

/**
 * Created by zhou on 2016/5/20.
 *
 * @author zhou
 */
public class Drawing {
    private String id;
    private String building_id;
    private String desc;
    private String name;
    private String owner;
    private String create_time;
    private String size;

    public Drawing() {
        this.id = "";
        this.building_id = "";
        this.desc = "";
        this.name = "";
        this.owner = "";
        this.create_time = "";
        this.size = "";
    }

    public Drawing(String name, String desc, String owner) {
        this.desc = desc;
        this.name = name;
        this.owner = owner;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
