<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>窗口退号</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header>
		<h1>窗口退号</h1>
		<hr>
	</header>
	<main>
		<div class="search-box">
			<input type="text" placeholder="请输入患者病历号">
			<input type="text" placeholder="请输入患者姓名">
			<button>搜索</button>
            <hr>
		</div>
		<table>
			<thead>
				<tr>
					<th>编号</th>
					<th>患者姓名</th>
					<th>患者病历号</th>
					<th>性别</th>
					<th>身份证号</th>
					<th>付款方式</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7">暂无数据</td>
				</tr>
			</tbody>
		</table>
	</main>
	<script src="script.js"></script>
</body>
</html>