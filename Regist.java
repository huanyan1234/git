package com.bd.pojo;

import java.math.BigInteger;

public class Regist {
    private Integer id;
    private String regist_code;
    private String regist_name;
    private BigInteger regist_fee;
    private Integer regist_quota;
    private Integer sequence_no;
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegist_code() {
        return regist_code;
    }

    public void setRegist_code(String regist_code) {
        this.regist_code = regist_code;
    }

    public String getRegist_name() {
        return regist_name;
    }

    public void setRegist_name(String regist_name) {
        this.regist_name = regist_name;
    }

    public BigInteger getRegist_fee() {
        return regist_fee;
    }

    public void setRegist_fee(BigInteger regist_fee) {
        this.regist_fee = regist_fee;
    }

    public Integer getRegist_quota() {
        return regist_quota;
    }

    public void setRegist_quota(Integer regist_quota) {
        this.regist_quota = regist_quota;
    }

    public Integer getSequence_no() {
        return sequence_no;
    }

    public void setSequence_no(Integer sequence) {
        this.sequence_no = sequence;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }

    public Regist() {
    }

    public Regist(Integer id, String regist_code, String regist_name, BigInteger regist_fee, Integer regist_quota, Integer sequence_no, Integer delmark) {
        this.id = id;
        this.regist_code = regist_code;
        this.regist_name = regist_name;
        this.regist_fee = regist_fee;
        this.regist_quota = regist_quota;
        this.sequence_no = sequence_no;
        this.delmark = delmark;
    }
}
