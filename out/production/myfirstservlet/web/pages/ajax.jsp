<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/26
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/jquery.js"></script>
</head>
<body>
<div id="content">

</div>
<input type="button" id="GetAjax" name="GetAjax" value="获取Ajax数据">
<script>
    $(function () {
        $("#GetAjax").on("click", function () {
            $.ajax({
                url:"/DataProviderController",    //请求的url地址
                data:{"id":1},    //参数值
                type:"POST",
                dataType:"json",   //返回格式为json
                success:function(data){
                    //请求成功时处理
                    $("#content").html(data.id);
                }
            });
        });
    });
</script>
</body>
</html>
