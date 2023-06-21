package com.bd.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

//ʵ��Bean
public class User {
	private Integer id;
	private String dept_code;	//���Ҵ���
	private String dept_name;	//��������
	private String dept_type;	//��������
	private String delmark;		//����
	private String realname;	//�û���ʵ����
	private String password;	//�û�����
	private Integer deptment_id;	//����id
	private Integer regist_level_id;		//ע��ȼ�
	private String scheduling_id;
	private String case_number;	//������
	private String real_name;	//����
	private String gender;		//�Ա�
	private String card_number;	
	private Integer age;			//����
	private String age_type;	//���䵥λ
	private String home_address;	//סַ
	private Date visit_date;		//ע��ʱ��
	private String noon;			//���
	private Integer employee_id;	//����id
	private Integer settle_category_id;	
	private String is_book;			//
	private String regist_method;	//֧����ʽ
	private Integer visit_state;
	private Integer regist_money;	//����
	//@JSONField(format = "yyyy-MM-dd") //ֻ������
	private Date birthday;
	private String regist_code;
	private String regist_name;
	private Integer regist_fee;
	private Integer regist_quota;
	private Integer sequence_no;
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
	public String getDelmark() {
		return delmark;
	}
	public void setDelmark(String delmark) {
		this.delmark = delmark;
	}
	public Integer getDeptment_id() {
		return deptment_id;
	}
	public void setDeptment_id(Integer deptment_id) {
		this.deptment_id = deptment_id;
	}
	public Integer getRegist_level_id() {
		return regist_level_id;
	}
	public void setRegist_level_id(Integer regist_level_id) {
		this.regist_level_id = regist_level_id;
	}
	public String getScheduling_id() {
		return scheduling_id;
	}
	public void setScheduling_id(String scheduling_id) {
		this.scheduling_id = scheduling_id;
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
	public Date getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}
	public String getNoon() {
		return noon;
	}
	public void setNoon(String noon) {
		this.noon = noon;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
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
	public Integer getRegist_money() {
		return regist_money;
	}
	public void setRegist_money(Integer regist_money) {
		this.regist_money = regist_money;
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
	public Integer getRegist_fee() {
		return regist_fee;
	}
	public void setRegist_fee(Integer regist_fee) {
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
	public void setSequence_no(Integer sequence_no) {
		this.sequence_no = sequence_no;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealName() {
		return realname;
	}
	public void setRealName(String realName) {
		this.realname = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//�������ڲ�ת��Ϊ�ַ������Ա�ǰ��ҳ����ʾ
	public String getBirthday2() {
		//return JSON.toJSONStringWithDateFormat(this.birthday, "yyyy-MM-dd",SerializerFeature.WriteDateUseDateFormat);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.birthday);
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	//ת��Ϊ�ַ�������
	public String getRegTime2() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(birthday);
	}	
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	
}
