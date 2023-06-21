package com.bd.pojo;

import com.alibaba.fastjson.JSON;

public class Employee {
    private Integer id;
    private String realname;
    private String password;
    private String deptment_id;
    private String regist_level_id;
    private String scheduling_id;
    private String delmark;
    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptment_id() {
        return deptment_id;
    }

    public void setDeptment_id(String deptment_id) {
        this.deptment_id = deptment_id;
    }

    public String getRegist_level_id() {
        return regist_level_id;
    }

    public void setRegist_level_id(String regist_level_id) {
        this.regist_level_id = regist_level_id;
    }

    public String getScheduling_id() {
        return scheduling_id;
    }

    public void setScheduling_id(String scheduling_id) {
        this.scheduling_id = scheduling_id;
    }

    public String getDelmark() {
        return delmark;
    }

    public void setDelmark(String delmark) {
        this.delmark = delmark;
    }
}
