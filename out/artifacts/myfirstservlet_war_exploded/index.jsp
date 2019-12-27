<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/23
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Dashboard</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="/static/css/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <!-- jQuery Circle-->
    <link rel="stylesheet" href="/static/css/grasp_mobile_progress_circle-1.0.0.min.css">
    <!-- Custom Scrollbar-->
    <link rel="stylesheet" href="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="/static/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="/static/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
  <script src="/static/jquery.js"></script>

</head>
<body>
<input id="name" type="text">
<input id="age" type="text">
<input id="address" type="text">
<input type="button" value="创建用户" id="create" class=".create">
<script>

    $(function () {

        $("#create").on("click", function () {
            var name = $("#name").val();
            var age = $("#age").val();
            var address = $("#address").val();
            UserManageModule.create(name, age, address);
        });

        var list = [{"name": "ivy1", "age": 10},
            {"name": "ivy2", "age": 20},
            {"name": "ivy3", "age": 30}];

        var list1 = [];
        $(list).each(function (index, item) {
            list1.push(item["age"] + 10);
        });
        console.log(list1);


    });


    var UserManageModule = {
        create: function (name, age, address) {
            $.ajax({
                url: "/DataProviderController",    //请求的url地址
                data: {"name": name, "age": age, "address": address},    //参数值
                type: "POST",
                dataType: "json",   //返回格式为json
                success: function (data) {
                    //请求成功时处理
                    $("#content").html(data.id);
                }
            });
        },
        update: function (name, age, address) {

        },
        delete: function (id) {

        }
    };

</script>
</body>
</html>
