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
	//��ȡҽ��id+realname
	private void doDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String deptId=request.getParameter("deptId");//����ID
		System.out.println(12222);
		System.out.println(deptId);
		String registLevelId=request.getParameter("registLevelId");//�ű�ID
		//1.����deptId+registLevelId��ѯҽ����Ϣ
		UserService service=new UserService();
		List<Employee> doctorList=service.getDoctorBy(Integer.parseInt(deptId),Integer.parseInt(registLevelId));		
		//2.���ݺű�ID��ȡ�ҺŷѺ����Ŷ�
//		Map<String,Object> feeQuota=service.getRegistLevelInfoById(registLevelId);
		//ͳ�ƻ��߹Һ�����ҽ��+����+��(��)��
//		RegisterService regService=new RegisterService();		
//		long registerCount=regService.getRegisterCountBy(employeeId);
		//3.��doctorList��feeQuota��װΪһ��Json����
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("doctorList", doctorList);	
//		jsonObject.put("feeQuota", feeQuota);
		//ת��Ϊ�ַ���
		String jsonString=jsonObject.toJSONString();
		System.out.println("jsonDoctor="+jsonString);
		response.getWriter().print(jsonString);//д�뵽������ҳ��
		/*request.setAttribute("doctorList", doctorList);		
		request.getRequestDispatcher("user/register.jsp").forward(request, response);	*/	

	}	
//	private void doRegisterCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1.��ȡ����
//		String employeeId=request.getParameter("employeeId");//����ID
//		//2.ͳ�ƻ��߹Һ�����ҽ��+����+��(��)��
//		RegisterService regService=new RegisterService();		
//		long registeredCount=regService.getRegisterCountBy(employeeId);
//		//3.��װΪһ��Json����
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("registeredCount", registeredCount);
//
//		//4.ת��Ϊ�ַ���
//		String jsonString=jsonObject.toJSONString();
//		System.out.println("jsonDoctor="+jsonString);
//		response.getWriter().print(jsonString);//д�뵽������ҳ��
//
//	}	
}
