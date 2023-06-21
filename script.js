// 获取搜索按钮元素
var searchBtn = document.querySelector(".search-box button");

// 监听搜索按钮的点击事件
searchBtn.addEventListener("click", function() {
	// 获取输入框元素
	var idInput = document.querySelector(".search-box input[type='text']:nth-of-type(1)");
	var nameInput = document.querySelector(".search-box input[type='text']:nth-of-type(2)");

	// 获取表格元素
	var table = document.querySelector("table");

	// 清空表格内容
	table.querySelector("tbody").innerHTML = "";

	// 模拟数据
	var data = [
		{ id: "001", name: "张三", gender: "男", idCard: "123456789012345678", payment: "现金" },
		{ id: "002", name: "李四", gender: "女", idCard: "234567890123456789", payment: "微信" },
		{ id: "003", name: "王五", gender: "男", idCard: "345678901234567890", payment: "支付宝" }
	];

	// 根据输入框内容过滤数据
	var filteredData = data.filter(function(item) {
		return (item.id.indexOf(idInput.value) !== -1 || item.name.indexOf(nameInput.value) !== -1);
	});

	// 如果有符合条件的数据，则将其添加到表格中
	if (filteredData.length > 0) {
		var tbody = table.querySelector("tbody");
		for (var i = 0; i < filteredData.length; i++) {
			var tr = document.createElement("tr");
			tr.innerHTML = "<td>" + (i + 1) + "</td>" +
						   "<td>" + filteredData[i].name + "</td>" +
						   "<td>" + filteredData[i].id + "</td>" +
						   "<td>" + filteredData[i].gender + "</td>" +
						   "<td>" + filteredData[i].idCard + "</td>" +
						   "<td>" + filteredData[i].payment + "</td>" +
						   "<td><button>退号</button></td>";
			tbody.appendChild(tr);
		}
	} else {
		// 如果没有符合条件的数据，则显示提示信息
		var tbody = table.querySelector("tbody");
		var tr = document.createElement("tr");
		tr.innerHTML = "<td colspan='7'>暂无数据</td>";
		tbody.appendChild(tr);
	}
});
