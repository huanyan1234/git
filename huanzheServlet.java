package com.bd.servlet;

import com.bd.pojo.Register;
import com.bd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "huanzheServlet", value = "/huanzheServlet")
public class huanzheServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //处理响应信息乱码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String caseNumber = request.getParameter("caseNumber");
        String realName = request.getParameter("realName");
        String gender = request.getParameter("gender");
        String cardNumber = request.getParameter("cardNumber");

//        SimpleDateFormat b=new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        String birthday = request.getParameter("birthday");
        //UserService user=new UserService();
        //java.util.Date a=user.getdate(birthday);
        Integer age = Integer.parseInt(request.getParameter("age"));
        String ageType = request.getParameter("ageType");
        String homeAddress = request.getParameter("homeAddress");
        String visitDate = request.getParameter("visitDate");
        //java.util.Date b=user.getda(visitDate);


        String noon = request.getParameter("noon");
        Integer deptmentId = Integer.parseInt(request.getParameter("deptmentId"));
        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
         System.out.print("111111111");
//         String arr = request.getParameter("registLevelId");//registLevelid
//         System.out.println("registLevelid=="+arr);
        Integer registLevelid = Integer.parseInt(request.getParameter("registLevelId"));
//         Integer registLevelid = 0;
        Integer settleCategoryid = Integer.parseInt(request.getParameter("settleCategoryid"));		//收费方式
        String isBook = request.getParameter("isBook");			//病历本
//         String isBook = "0";
        String registMethod = request.getParameter("registMethod");		//应收金额
//         Integer visitState = Integer.parseInt(request.getParameter("visitState"));	//本次看诊状态
        Integer visitState = 1;
        Double registMoney = Double.parseDouble(request.getParameter("registMoney"));

//         System.out.print("111111111");

        Register regist = new Register();
        regist.setCase_number(caseNumber);
        regist.setReal_name(realName);
        regist.setGender(gender);
        regist.setCard_number(cardNumber);
        regist.setBirthday(birthday);
        regist.setAge(age);
        regist.setAge_type(ageType);
        regist.setHome_address(homeAddress);
        regist.setVisit_date(visitDate);
        regist.setNoon(noon);
        regist.setDeptment_id(deptmentId);
        regist.setEmployee_id(employeeId);
        regist.setRegist_level_id(registLevelid);
        regist.setSettle_category_id(settleCategoryid);
        regist.setIs_book(isBook);
        regist.setRegist_method(registMethod);
        regist.setVisit_state(visitState);
        regist.setRegist_money(registMoney);



        int i;
        try {
            i = userService.addPatient(regist);
            if(i > 0){

                out.println("挂号成功");
                out.println("<a href="+"http://localhost:8080/health_war_exploded/login.jsp"+">退出系统</a>");
                out.flush();
                out.close();
            }else{
                out.println("挂号失败");
                out.println("<a href="+"http://localhost:8080/health_war_exploded/login.jsp"+">退出系统</a>");
                out.flush();
                out.close();
            }
        } catch (RuntimeException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





        System.out.println("开始处理挂号请求...");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");

        doGet(request, response);
    }
}
