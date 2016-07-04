package com.arch.entity;

/**
 * Created by zhou on 2016/5/20.
 *
 * @author zhou
 */
public class Video {
    private String id;
    private String building_id;
    private String desc;
    private String name;
    private String date;
    private String owner;
    private String key_word;
    private String create_time;
    private String size;

    public Video() {
        this.id = "";
        this.building_id = "";
        this.desc = "";
        this.name = "";
        this.date = "";
        this.owner = "";
        this.key_word = "";
        this.create_time = "";
        this.size = "";
    }

    public Video(String name, String date, String owner, String key_word, String desc ) {
        this.desc = desc;
        this.name = name;
        this.date = date;
        this.owner = owner;
        this.key_word = key_word;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word;
    }
}
