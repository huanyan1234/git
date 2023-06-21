<%--
  Created by IntelliJ IDEA.
  User: Color
  Date: 2023/6/19
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="header">
    <h1>患者查看</h1>
    <div class="links">
        <a href="http://localhost:8080/health_war_exploded/导航栏.jsp">返回主页面</a>
    </div>
</div>
<head>
    <title>患者叫号系统</title>
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
</head>

<body>
<form action="huanzhe2Servlet" method="post">
    <div class="container">
        <div class="stats">
            <span>今日已看0人</span>
            <span>当前有0人在排队</span>
        </div>
        <hr>
        <div class="title">患者叫号</div>
        <hr>
        <div class="input-group">
            <input type="text" placeholder="请输入患者病历号" name="case_number">
            <input type="text" placeholder="请输入患者姓名" name="real_name">
            <input type="submit" value="查询">
        </div>
        <table>
            <thead>
            <tr>
                <th>编号</th>
                <th>患者姓名</th>
                <th >患者病历号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="empty">
                <th>${id}</th>
                <th>${realName}</th>
                <th>${caseNumber}</th>
                <th></th>
            </tr>
            </tbody>
        </table>
    </div>
</form>>

<form action="getPeopleNumber" method="post" name="a" id="index">
    <input name="flag" value="true" type="hidden">
</form>
<s:if test="commodities==null">
    <script>
        window.onload = function () {
            document.getElementById("index").submit();
        }
    </script>
</s:if>
</body>

</html>

