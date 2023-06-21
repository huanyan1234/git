package com.bd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.pojo.Regist;
import com.bd.pojo.Scheduling;
import com.bd.pojo.dept;
import com.bd.pojo.Employee;
import com.bd.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        //处理请求乱码
        request.setCharacterEncoding("utf-8");
        //处理响应信息乱码
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();//用于向请求者做出响应（文字）
        //接收请求，读取参数
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //System.out.println(name);

        UserService service = new UserService();
        Employee emp = service.getUserByNameAndPassword(account, password);
        if (account.equals("挂号") && password.equals("123")) {
            request.getRequestDispatcher("导航栏2.jsp").forward(request, response);
        } else {
            System.out.println(Integer.valueOf(emp.getDeptment_id()));
            dept d = service.getDept(Integer.valueOf(emp.getDeptment_id()));
            Regist d1 = service.getLevel(Integer.valueOf(emp.getRegist_level_id()));
            Scheduling d3 = service.getRule(Integer.valueOf(emp.getScheduling_id()));
            System.out.println(account);
            if (emp != null) {//说明已经匹配上了
                request.getSession().setAttribute("USER",emp);
                request.setAttribute("name", emp.getRealname());
                request.setAttribute("dept", d.getDept_name());
                request.setAttribute("rgsId", d1.getRegist_name());
                request.setAttribute("weekId", d3.getRule_name());
                request.setAttribute("mark", emp.getDelmark());
                request.getRequestDispatcher("导航栏.jsp").forward(request, response);
            } else {
                out.println("你的账号或密码错误，请<a href='login.html'>重新登录！！</a>");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("doPost...");

        doGet(request, response);
    }

}
