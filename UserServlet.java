package com.bd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bd.pojo.Employee;
import com.bd.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/user.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		if(method.equals("doctor")){
			doDoctor(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//获取医生id+realname
	private void doDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String deptId=request.getParameter("deptId");//部门ID
		System.out.println(12222);
		System.out.println(deptId);
		String registLevelId=request.getParameter("registLevelId");//号别ID
		//1.根据deptId+registLevelId查询医生信息
		UserService service=new UserService();
		List<Employee> doctorList=service.getDoctorBy(Integer.parseInt(deptId),Integer.parseInt(registLevelId));		
		//2.根据号别ID获取挂号费和最大号额
//		Map<String,Object> feeQuota=service.getRegistLevelInfoById(registLevelId);
		//统计患者挂号数：医生+当天+上(下)午
//		RegisterService regService=new RegisterService();		
//		long registerCount=regService.getRegisterCountBy(employeeId);
		//3.将doctorList，feeQuota组装为一个Json对象
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("doctorList", doctorList);	
//		jsonObject.put("feeQuota", feeQuota);
		//转换为字符串
		String jsonString=jsonObject.toJSONString();
		System.out.println("jsonDoctor="+jsonString);
		response.getWriter().print(jsonString);//写入到请求者页面
		/*request.setAttribute("doctorList", doctorList);		
		request.getRequestDispatcher("user/register.jsp").forward(request, response);	*/	

	}	
//	private void doRegisterCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1.获取参数
//		String employeeId=request.getParameter("employeeId");//部门ID
//		//2.统计患者挂号数：医生+当天+上(下)午
//		RegisterService regService=new RegisterService();		
//		long registeredCount=regService.getRegisterCountBy(employeeId);
//		//3.组装为一个Json对象
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("registeredCount", registeredCount);
//
//		//4.转换为字符串
//		String jsonString=jsonObject.toJSONString();
//		System.out.println("jsonDoctor="+jsonString);
//		response.getWriter().print(jsonString);//写入到请求者页面
//
//	}	
}
