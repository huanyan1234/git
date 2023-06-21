<%--
  Created by IntelliJ IDEA.
  User: Color
  Date: 2023/6/20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<head>
    <title>东软云医院HIS系统</title>
    <style>
        body {
            background-color: #f2f2f2;
        }
        .container {
            margin: 0 auto;
            width: 80%;
            padding-top: 20px;
        }
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .input-group {
            display: inline-block;
            margin-right: 20px;
        }
        .input-group input[type="text"] {
            padding: 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 5px #ccc;
            width: 200px;
            margin-right: 10px;
        }
        .input-group input[type="text"]::placeholder {
            color: #ccc;
        }
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #3e8e41;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
            background-color: #fff;
        }
        th, td {
            text-align: center;
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .empty {
            text-align: center;
            font-size: 18px;
            color: #ccc;
            padding: 20px;
        }
    </style>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        .nav {
            display: flex;
            flex-direction: column;
            background-color: #eee;
            height: 100vh;
            width: 200px;
            position: fixed;
            top: 0;
            left: 0;
            overflow-y: auto;
        }
        .nav a {
            display: block;
            padding: 10px;
            color: #333;
            text-decoration: none;
            border-bottom: 1px solid #ccc;
        }
        .nav a:hover {
            background-color: #ccc;
        }
        .content {
            margin-left: 200px;
            padding: 10px;
        }
    </style>
</head>
<body>
<form action="DoctorServlet" method="post">
    <div class="header">
        <h1>东软云医院HIS系统</h1>
    </div>
    <div class="nav">
        <a href="#">门诊医生</a>
        <div class="sub-nav">
            <a name="flag" href="http://localhost:8080/health_war_exploded/患者查看.jsp">患者查看</a>
            <a href="#">医生诊疗：病历首页</a>
            <a href="#">医生诊疗：检查申请</a>
            <a href="#">医生诊疗：检验申请</a>
            <a href="#">看诊记录</a>
            <a href="#">医生诊疗：检查结果</a>
            <a href="#">医生诊疗：检验结果</a>
            <a href="#">医生诊疗：门诊确诊</a>
            <a href="#">医生诊疗：开设处方</a>
            <a href="#">医生诊疗：处置申请</a>
            <a href="#">医生诊疗：费用查询</a>
        </div>
        <a href="#">检查管理</a>
        <div class="sub-nav">
            <a href="#">检查申请</a>
            <a href="#">患者录入</a>
            <a href="#">检查结果录入</a>
            <a href="#">检查管理</a>
        </div>
        <a href="#">检验管理</a>
        <div class="sub-nav">
            <a href="#">检验申请</a>
            <a href="#">患者录入</a>
            <a href="#">检验结果录入</a>
            <a href="#">检验管理</a>
        </div>
        <a href="#">药房管理</a>
        <div class="sub-nav">
            <a href="#">药房发药</a>
            <a href="#">药房退药</a>
            <a href="#">药库管理</a>
            <a href="#">交易记录</a>
        </div>
        <a href="#">处置管理</a>
        <div class="sub-nav">
            <a href="#">处置申请</a>
            <a href="#">患者录入</a>
            <a href="#">处置录入</a>
            <a href="#">处置管理</a>
        </div>
    </div>
    <div class="content">
        <h2>欢迎使用东软云医院HIS系统</h2>
        <div class="container">
            <table>
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>所在科室</th>
                    <th >挂号级别ID</th>
                    <th>班排ID</th>
                    <th>生效标记</th>
                </tr>
                </thead>
                <tbody>
                <tr class="empty">
                    <th>${name}</th>
                    <th>${dept}</th>
                    <th>${rgsId}</th>
                    <th>${weekId}</th>
                    <th>${mark}</th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <script>
        var subNavs = document.querySelectorAll('.sub-nav');
        for (var i = 0; i < subNavs.length; i++) {
            subNavs[i].style.display = 'none';
        }
        var navLinks = document.querySelectorAll('.nav a');
        for (var i = 0; i < navLinks.length; i++) {
            navLinks[i].addEventListener('click', function(e) {
                e.preventDefault();
                var subNav = this.nextElementSibling;
                if (subNav) {
                    if (subNav.style.display === 'none') {
                        subNav.style.display = 'block';
                    } else {
                        subNav.style.display = 'none';
                    }
                } else {
                    var content = document.querySelector('.content');
                    content.innerHTML = '<h2>' + this.textContent + '</h2><p>这是' + this.textContent + '的内容。</p>';
                    <a name="flag" href="http://localhost:8080/health_war_exploded/患者查看.jsp">患者查看</a>
                }
            });
        }
    </script>
</form>>
</body>
</html>
