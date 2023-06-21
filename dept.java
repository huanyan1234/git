package com.bd.pojo;

public class dept {
    private Integer id;
    private String dept_code;
    private String dept_name;
    private String dept_type;
    private Integer delmark;

    public dept(Integer id, String dept_code, String dept_name, String dept_type, Integer delmark) {
        this.id = id;
        this.dept_code = dept_code;
        this.dept_name = dept_name;
        this.dept_type = dept_type;
        this.delmark = delmark;
    }

    public dept() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_type() {
        return dept_type;
    }

    public void setDept_type(String dept_type) {
        this.dept_type = dept_type;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }

    @Override
    public String toString() {
        return "dept{" +
                "id=" + id +
                ", dept_code='" + dept_code + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", dept_type='" + dept_type + '\'' +
                ", delmark=" + delmark +
                '}';
    }
}
