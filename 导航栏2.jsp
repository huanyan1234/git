<%--
  Created by IntelliJ IDEA.
  User: Color
  Date: 2023/6/21
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>东软云医院HIS系统</title>
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

<div class="header">
    <h1>东软云医院HIS系统</h1>
</div>
<div class="nav">
    <a href="#">挂号收费</a>
    <div class="sub-nav">
        <a href="http://localhost:8080/health_war_exploded/chuangkouguahao2.jsp">窗口挂号</a>
        <a href="http://localhost:8080/health_war_exploded/chuagkoutuihao.jsp">窗口退号</a>
        <a href="#">收费</a>
        <a href="#">退费</a>
        <a href="#">费用记录查询</a>

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
        <p>请点击左侧导航栏中的项目以查看对应内容。</p>
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
                    <a href="http://localhost:8080/health_war_exploded/chuangkouguahao2.jsp">窗口挂号</a>
                    <a href="http://localhost:8080/health_war_exploded/chuagkoutuihao.jsp">窗口退号</a>
                }
            });
        }
    </script>
</div>
</body>
</html>

