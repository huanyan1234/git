package com.bd.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bd.dao.UserDao;
import com.bd.pojo.*;


public class UserService {

	//根据用户名+密码查找用户信息
	public Employee getUserByNameAndPassword(String account, String password) {
		UserDao dao=new UserDao();
		return dao.getUserByNameAndPassword(account, password);
	}
	public int addPatient(Register regist) throws RuntimeException, SQLException {
		UserDao dao=new UserDao();
		return dao.addPatient(regist);

	}
	public List<Employee> getDoctorBy(Integer deptId,Integer registLevelId){
		UserDao dao=new UserDao();
		return dao.getDoctorBy(deptId, registLevelId);
	}
	//根据病历号和患者名字查询
	public Register selecthuanzhe(String case_number,String real_name){
		UserDao dao =new UserDao();
		return dao.getid(case_number,real_name);


	}
	public List<Register> getall(){
		UserDao dao=new UserDao();
		return dao.getAllUserInfo();

	}

	public List<Register> getDates(){
		UserDao dao = new UserDao();
		return dao.getDates();
	}

	public dept getDept(Integer deptId){
		UserDao dao = new UserDao();
		return dao.getDept(deptId);
	}
	public Regist getLevel(Integer level){
		UserDao dao = new UserDao();
		return dao.getlevel(level);
	}
	public Scheduling getRule(Integer id){
		UserDao dao = new UserDao();
		return dao.getRule(id);
	}


}
