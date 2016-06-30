package com.arch.entity;

import net.sf.json.JSONObject;

/**
 * Created by zhou on 2016/1/9.
 * 前台交互结果
 */
public class Result {
    private String code;
    private String msg;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", this.code);
        jsonObject.put("msg", this.msg);
        jsonObject.put("result", this.result);

        return jsonObject;
    }

    public static void main(String[] args) {
        Result result = new Result();
        result.setCode("0");
        result.setMsg("success");
    }

    public void error() {
        code = "-1";
        msg = "录入失败！";
        result = "";
    }

    public void success() {
        code = "0";
        msg = "录入成功！";
        result = "";
    }
}
