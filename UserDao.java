package com.bd.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bd.pojo.*;
import lcm.db.utils.DatabaseOperate;


//StudentDao
public class UserDao {
	private DatabaseOperate db=new DatabaseOperate();
	//获取�?有有学生信息，返回Map列表
	public List<Map<String,Object>> getAllUser() {
		final String sqlSelect="select * from employee";
		List<Map<String,Object>> list=db.executeQuery(sqlSelect, null);
		return list;
	}
	//获取所有用户信息
	public List<Register> getAllUserInfo() {
		final String sqlSelect="select * from register";
		List<Register> employeeList=db.getBeanList(sqlSelect, null, Register.class);
		System.out.println(employeeList);
		return employeeList;
	}
	public List<Employee> getDoctorBy(Integer deptId,Integer registLevelId) {
		final String sqlSelect="SELECT id,realname FROM employee WHERE deptment_id=? AND regist_level_id=?";
		Object[] params=new Object[]{deptId,registLevelId};
		List<Employee> employeeList=db.getBeanList(sqlSelect, params, Employee.class);
		//System.out.println(employeeList);
		return employeeList;
	}
	public int addPatient(Register regist) throws RuntimeException, SQLException {
		System.out.println("55");
		final String sqlInsert="INSERT INTO register (case_number, real_name, gender, card_number, birthday, age, age_type, home_address, visit_date, noon, deptment_id, employee_id, regist_level_id, settle_category_id, is_book, regist_method, visit_state, regist_money) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params=new Object[]{
				regist.getCase_number(),
				regist.getReal_name(),
				regist.getGender(),
				regist.getCard_number(),
				regist.getBirthday(),
				regist.getAge(),
				regist.getAge_type(),
				regist.getHome_address(),
				regist.getVisit_date(),
				regist.getNoon(),
				regist.getDeptment_id(),
				regist.getEmployee_id(),
				regist.getRegist_level_id(),
				regist.getSettle_category_id(),
				regist.getIs_book(),
				regist.getRegist_method(),
				regist.getVisit_state(),
				regist.getRegist_money()
		};
//		System.out.print(regist.getCaseNumber());
		int affectedRow=db.executeNonQuery(sqlInsert, params);
		System.out.println("66");
		System.out.println(affectedRow);
		System.out.print("affectedRow=" + affectedRow);
		return affectedRow;
	}
	public int tuihaoSelete() throws RuntimeException, SQLException {
		final String sqlSelect="select * from register";
		int tuihao = db.executeNonQuery(sqlSelect, null);
		return tuihao;
	}
	public Employee getUserByNameAndPassword(String account, String password) {
		final String sqlSelect="select * from employee where realname=? and password=?";
		Object[] params= new Object[]{account,password};//组装参数
		List<Employee> userList=db.getBeanList(sqlSelect, params, Employee.class);
		//User user=db.get.getBeanList(sqlSelect, params, User.class);
		System.out.println("List<employee>=>"+userList);
		if(userList!=null && userList.size()>0){
			return userList.get(0);
		}
		else{
			return null;
		}
	}
	public Register getid(String case_number,String real_name) {
		System.out.println("1");
		if (case_number != "" && real_name != "") { //都有
			final String sqlSelect = "select * from register where case_number=? and real_name=?";
			Object[] params = new Object[]{case_number, real_name};//组装参数
			System.out.println(params.length);
			List<Register> userList = db.getBeanList(sqlSelect, params, Register.class);
			System.out.println("List<Register>=>" + userList);
			if (userList != null && userList.size() > 0) {
				return userList.get(0);
			}
		}else if(case_number != "" && real_name == ""){ //只有病历号
			final String sqlSelect1="select * from register where case_number=?";
			Object[] params1= new Object[]{case_number};//组装参数
			List<Register> userList1=db.getBeanList(sqlSelect1, params1, Register.class);
			System.out.println("List<Register>=>"+userList1);
			if(userList1!=null && userList1.size()>0){
				return userList1.get(0);
			}
		}else if(case_number==""&&real_name!=""){ //只有姓名
				final String sqlSelect2="select * from register where real_name=?";
				Object[] params2= new Object[]{real_name};//组装参数
//				System.out.println("我到这了");
				List<Register> userList2=db.getBeanList(sqlSelect2, params2, Register.class);
				System.out.println("List<Register>=>"+userList2);
				if(userList2!=null && userList2.size()>0){
					return userList2.get(0);
				}
			}else{ //全无
				Register re = new Register();
				re.setId(0);
				return re;
			}
		Register nullRe = new Register();
		nullRe.setId(0);
		return nullRe;
	}
	public List<Register> getDates(){
		System.out.println("getDates working,wait and ok are selecting!");
		final String sqlSelect="select * from register WHERE visit_date BETWEEN DATE_SUB(CURDATE(),INTERVAL 0 DAY) and DATE_SUB(CURDATE(),INTERVAL -1 DAY)";
		Object[] params= new Object[]{};//组装参数
		System.out.println("111");
		List<Register> userList=db.getBeanList(sqlSelect, params, Register.class);
		System.out.println("222");

		if(userList!=null && userList.size()>0){
			return userList;
		}

		return null;
	}

	public dept getDept(Integer deptId){
		System.out.println("getDept working,dept are selecting!");
		final String sqlSelect="select * from department WHERE id = ?";
		Object[] params= new Object[]{deptId};//组装参数
		System.out.println(params);
		List<dept> userList=db.getBeanList(sqlSelect, params, dept.class);
		return userList.get(0);
	}
	public Regist getlevel(Integer level){
		System.out.println("getDept working,Regist are selecting!");
		final String sqlSelect="select * from regist_level WHERE  id= ?";

		Object[] params= new Object[]{level};//组装参数
		System.out.println(params);
		List<Regist> userList=db.getBeanList(sqlSelect, params, Regist.class);
		return userList.get(0);
	}
	public Scheduling getRule(Integer id){
		System.out.println("getDept working,Regist are selecting!");
		final String sqlSelect="select * from scheduling WHERE  id= ?";
		Object[] params= new Object[]{id};//组装参数
		System.out.println(params);
		List<Scheduling> userList=db.getBeanList(sqlSelect, params, Scheduling.class);
		return userList.get(0);
	}



}