package com.bd.pojo;

public class Scheduling {
    private Integer id;
    private String rule_name;
    private String week_rule;
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name;
    }

    public String getWeek_rule() {
        return week_rule;
    }

    public void setWeek_rule(String week_rule) {
        this.week_rule = week_rule;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }

    public Scheduling() {
    }

    public Scheduling(Integer id, String rule_name, String week_rule, Integer delmark) {
        this.id = id;
        this.rule_name = rule_name;
        this.week_rule = week_rule;
        this.delmark = delmark;
    }
}
