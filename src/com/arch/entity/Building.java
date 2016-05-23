package com.arch.entity;

/**
 * Created by zhou on 2016/5/20.
 * @author zhou
 */
public class Building {
    private String id;
    private String name;
    private String city;
    private String address;
    private String designer;
    private String date;
    private String construct_org;
    private String desc;
    private String type;
    private String style;
    private String structure;
    private String post_code;
    private String create_time;

    public Building() {
        id = "";
        name = "";
        city = "";
        address = "";
        designer = "";
        date = "";
        construct_org = "";
        desc = "";
        type = "";
        structure = "";
        style = "";
        post_code = "";
        create_time = "";
    }

    public Building(String name, String city, String address, String designer, String date,
                    String construct_org, String desc, String type, String style, String structure,
                    String post_code, String create_time) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.designer = designer;
        this.date = date;
        this.construct_org = construct_org;
        this.desc = desc;
        this.type = type;
        this.style = style;
        this.structure = structure;
        this.post_code = post_code;
        this.create_time = create_time;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConstruct_org() {
        return construct_org;
    }

    public void setConstruct_org(String construct_org) {
        this.construct_org = construct_org;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }
}
