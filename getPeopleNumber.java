package com.bd.servlet;

import com.bd.pojo.Register;
import com.bd.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getPeopleNumber")
public class getPeopleNumber extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag = request.getParameter("flag");
        System.out.println("请求成功" + flag);

        UserService userService = new UserService();
        List<Register> res = userService.getDates();
        System.out.println("当天看诊人数" + res.size());
        int count = 0;
        int ok = 0;
        int wait = 0;
        for (int i = 0;i < res.size();i++){
            if(res.get(i).getVisit_state() != 1){
                count++;
            }
        }
        ok = count;
        wait = res.size() - count;
        request.setAttribute("ok",ok); // 已看诊
        request.setAttribute("wait",wait); // 等待中
        request.setAttribute("id","无数据");
        request.setAttribute("realName","无数据");
        request.setAttribute("caseNumber","无数据");
        request.getRequestDispatcher("患者查看1.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");

        doGet(request, response);
    }
}
