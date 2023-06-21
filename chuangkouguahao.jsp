<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>窗口挂号</title>
    <style>
        /* 设置页面主题 */
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: white;
            background-color: #0077cc;
            padding: 10px;
            margin: 0;
        }

        /* 设置表格样式 */
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid gray;
            padding: 5px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        /* 设置输入框样式 */
        input, select {
            border: 1px solid gray;
            padding: 5px;
            border-radius: 3px;
            margin: 5px;
        }

        /* 设置按钮样式 */
        button {
            background-color: #0077cc;
            color: white;
            border: none;
            border-radius: 3px;
            padding: 5px 10px;
            margin: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #005fa3;
        }
    </style>
</head>
<body>
<form action="huanzheServlet" method="post">
	<h1>窗口挂号</h1>

    <hr>

    <button id="btn-register">挂号</button>
    <button id="btn-clear">清空</button>

    <div>
        <h2>基本信息</h2>
        <table>
            <tr>
                <th>病历号</th>
                <td><input type="text" placeholder="请输入病历号" name="caseNumber"></td>
            </tr>
            <tr>
                <th>姓名</th>
                <td><input type="text" placeholder="请输入姓名" name="realName"></td>
            </tr>
            <tr>
                <th>性别</th>
                <td>
                    <select name="gender">
                        <option value="男" selected name="man">男</option>
                        <option value="女" name="woman">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>年龄</th>
                <td><input type="number" min="1" max="100" value="18" name="age"></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><input type="date" name="birthday"></td>
            </tr>
            <tr>
                <th>身份证号</th>
                <td><input type="text" placeholder="请输入身份证号" name="cardNumber"></td>
            </tr>
            <tr>
                <th>家庭住址</th>
                <td><input type="text" placeholder="请输入家庭住址（可选）" name="homeAddress"></td>
            </tr>
        </table>

        <h2>挂号信息</h2>
        <table>
            <tr>
                <th>结算类别</th>
                <td>
                    <select name="settleCategoryid">
                        <option value="1">自费</option>
                        <option value="2">市医保</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>看诊日期</th>
                <td><input type="date" name="visitDate"></td>
            </tr>
            <tr>
                <th>午别</th>
                <td>
                    <select name="noon">
                        <option value="上午" selected>上午</option>
                        <option value="下午">下午</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>挂号科室</th>
                <td>
                    <select name="deptmentId">
                        <option value="1">心血管内科</option>
                        <option value="2">神经内科</option>
                        <option value="3">普通内科</option>
                        <option value="4">消化内科</option>
                        <option value="5">呼吸内科</option>
                        <option value="6">内分泌科</option>
                        <option value="7">肾病内科</option>
                        <option value="8">血液内科</option>
                        <option value="9">感染内科</option>
                        <option value="10">老年病内科</option>
                        <option value="11">风湿免疫内科</option>
                        <option value="12">透析科</option>
                        <option value="13">变态反应科</option>
                        <option value="14">普通外科</option>
                        <option value="15">泌尿外科</option>
                        <option value="16">神经外科</option>
                        <option value="17">胸外科</option> 
                        <option value="18">整形外科</option> 
                        <option value="19">肛肠外科</option> 
                        <option value="20">肝胆外科</option> 
                        <option value="21">乳腺外科</option> 
                        <option value="22">心血管外科</option> 
                        <option value="23">心脏外科</option> 
                        <option value="24">器官移植</option> 
                        <option value="25">微创外科</option> 
                        <option value="26">功能神经外科</option>
                        <option value="27">腺体外科</option> 
                        <option value="28">儿科综合</option> 
                        <option value="29">小儿外科</option> 
                        <option value="30">儿童保健科</option> 
                        <option value="31">新生儿科</option> 
                        <option value="32">小儿骨科</option> 
                        <option value="33">小儿神经内科</option> 
                        <option value="34">小儿呼吸科</option> 
                        <option value="35">小儿血液科</option> 
                        <option value="36">小儿耳鼻喉科</option> 
                        <option value="37">小儿心内科</option> 
                    </select> 
                </td> 
            </tr> 
            <tr> 
                <th>看诊医生</th> 
                <td><input type="text" placeholder="请输入看诊医生编号" name="employeeId"></td> 
            </tr> 
            <tr> 
                <th>应收金额</th> 
                <td><input type="text" placeholder="请输入金额" name="registMoney"></td> 
            </tr> 
            <tr> 
                <th>收费方式</th> 
                <td> <select name="registMethod"> 
                	<option value="支付宝">支付宝</option>
                    <option value="微信">微信</option>
                    <option value="现金">现金</option>
                    <option value="医保卡">医保卡</option>
                </select> 
            </td> 
        </tr> 
    </table> 
</div>
<script>
    // 获取按钮和输入框元素
    var btnRegister = document.getElementById('btn-register');
    var btnClear = document.getElementById('btn-clear');
    var inputs = document.querySelectorAll('input[type="text"], input[type="number"], select');

    // 给按钮添加点击事件监听器
    btnRegister.addEventListener('click', function() {
        // 在这里编写挂号的逻辑代码
        alert('挂号成功！');
    });

    // 给清空按钮添加点击事件监听器
    btnClear.addEventListener('click', function() {
        // 清空输入框的内容
        inputs.forEach(function(input) {
            input.value = '';
        });
    });
</script>
</form>
</body>
</html>