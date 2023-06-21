package com.bd.pojo;

import com.alibaba.fastjson.JSON;

import java.time.DateTimeException;
import java.util.Date;

public class Register {
    private Integer id;
    private String case_number;
    private String real_name;
    private String gender;
    private String card_number;
    private String birthday;
    private Integer age;
    private String age_type;
    private String home_address;
    private String visit_date;
    private String noon;
    private Integer regist_level_id;
    private Integer deptment_id;
    private Integer employee_id;
    private Integer regist_level;
    private Integer settle_category_id;
    private String is_book;
    private String regist_method;
    private Integer visit_state;
    private Double regist_money;
    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    public Register() {
    }

    public Register(Integer id, String case_number, String real_name, String gender, String card_number, String birthday, Integer age, String age_type, String home_address, String visit_date, String noon, Integer regist_level_id, Integer deptment_id, Integer employee_id, Integer regist_level, Integer settle_category_id, String is_book, String regist_method, Integer visit_state, Double regist_money) {
        this.id = id;
        this.case_number = case_number;
        this.real_name = real_name;
        this.gender = gender;
        this.card_number = card_number;
        this.birthday = birthday;
        this.age = age;
        this.age_type = age_type;
        this.home_address = home_address;
        this.visit_date = visit_date;
        this.noon = noon;
        this.regist_level_id = regist_level_id;
        this.deptment_id = deptment_id;
        this.employee_id = employee_id;
        this.regist_level = regist_level;
        this.settle_category_id = settle_category_id;
        this.is_book = is_book;
        this.regist_method = regist_method;
        this.visit_state = visit_state;
        this.regist_money = regist_money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegist_level_id() {
        return regist_level_id;
    }

    public void setRegist_level_id(Integer regist_level_id) {
        this.regist_level_id = regist_level_id;
    }

    public String getCase_number() {
        return case_number;
    }

    public void setCase_number(String case_number) {
        this.case_number = case_number;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAge_type() {
        return age_type;
    }

    public void setAge_type(String age_type) {
        this.age_type = age_type;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public Integer getDeptment_id() {
        return deptment_id;
    }

    public void setDeptment_id(Integer deptment_id) {
        this.deptment_id = deptment_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getRegist_level() {
        return regist_level;
    }

    public void setRegist_level(Integer regist_level) {
        this.regist_level = regist_level;
    }

    public Integer getSettle_category_id() {
        return settle_category_id;
    }

    public void setSettle_category_id(Integer settle_category_id) {
        this.settle_category_id = settle_category_id;
    }

    public String getIs_book() {
        return is_book;
    }

    public void setIs_book(String is_book) {
        this.is_book = is_book;
    }

    public String getRegist_method() {
        return regist_method;
    }

    public void setRegist_method(String regist_method) {
        this.regist_method = regist_method;
    }

    public Integer getVisit_state() {
        return visit_state;
    }

    public void setVisit_state(Integer visit_state) {
        this.visit_state = visit_state;
    }

    public Double getRegist_money() {
        return regist_money;
    }

    public void setRegist_money(Double regist_money) {
        this.regist_money = regist_money;
    }
}
