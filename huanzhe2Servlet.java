package com.bd.servlet;

import com.bd.pojo.Register;
import com.bd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "huanzhe2Servlet", value = "/huanzhe2Servlet")
public class huanzhe2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        //������Ӧ��Ϣ����
//        response.setContentType("text/html;charset=utf-8");
//
//        PrintWriter out=response.getWriter();//������������������Ӧ�����֣�
//        //�������󣬶�ȡ����
//        String case_number=request.getParameter("case_number");
//        String real_name=request.getParameter("real_name");
//        out.println(case_number+real_name);
//
//        UserService userService=new UserService();
//        Register register=userService.selecthuanzhe(case_number,real_name);
//        out.println(case_number+real_name);

        //�����Ŷ�
        String flag = request.getParameter("flag");
        System.out.println("����ɹ�" + flag);

        UserService userService = new UserService();
        List<Register> res = userService.getDates();
        System.out.println("���쿴������" + res.size());
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
        request.setAttribute("ok",ok); // �ѿ���
        request.setAttribute("wait",wait); // �ȴ���

        //String case_number = new String(request.getParameter("case_number").getBytes("iso-8859-1"),"utf-8");
        //String real_name = new String(request.getParameter("real_name").getBytes("iso-8859-1"),"utf-8");
        String case_number = request.getParameter("case_number");
        String real_name = request.getParameter("real_name");
        System.out.println(case_number);
        System.out.println(real_name);
        if(case_number.isEmpty()){
            case_number ="";
            System.out.println("yes1");
        }
        if(real_name.isEmpty()){
            System.out.println("yes2");
            real_name="";
        }
        Register re=userService.selecthuanzhe(case_number,real_name);
        System.out.println(re.getReal_name());
        re.getReal_name();
        re.getCase_number();
        if (re.getId() == 0){
            request.setAttribute("id","������");
            request.setAttribute("realName","������");
            request.setAttribute("caseNumber","������");
            request.getRequestDispatcher("���߲鿴1.jsp").forward(request,response);
        }
        request.setAttribute("id",re.getId());
        request.setAttribute("realName",re.getReal_name());
        request.setAttribute("caseNumber",re.getCase_number());
        request.getRequestDispatcher("���߲鿴1.jsp").forward(request,response);



//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id",re.getId());
//        jsonObject.put("real_name",re.getReal_name());
//        jsonObject.put("case_number",re.getCase_number());
//        String jsonString = jsonObject.toJSONString();
//        System.out.println(jsonString);
//        response.getWriter().print(jsonString);
//        System.out.println(caseNumber);
//        System.out.println(real_name);


//        out.println(registerList);
//        out.println(registerList.size());
//        for (int i = 0; i < registerList.size(); i++) {
//            Register register=registerList.get(i);
//            out.println(register.getId()+
//                    register.getReal_name()+
//                    register.getCase_number());
//        }

//        request.getRequestDispatcher("���߲鿴.html").forward(request,response);





    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");

        doGet(request, response);
    }
}
