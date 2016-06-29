package com.arch.entity;

/**
 * Created by zhou on 2016/5/20.
 *
 * @author zhou
 */
public class Document {
    private String id;
    private String building_id;
    private String name;
    private String author;
    private String key_word;
    private String d_abstract;
    private String date;
    private String serial_number;
    private String create_time;
    private String size;

    public Document() {
        this.id = "";
        this.building_id = "";
        this.name = "";
        this.author = "";
        this.key_word = "";
        this.d_abstract = "";
        this.date = "";
        this.serial_number = "";
        this.create_time = "";
        this.size = "";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word;
    }

    public String getD_abstract() {
        return d_abstract;
    }

    public void setD_abstract(String d_abstract) {
        this.d_abstract = d_abstract;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
}
