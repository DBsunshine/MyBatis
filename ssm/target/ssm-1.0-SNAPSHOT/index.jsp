<%--
  Created by IntelliJ IDEA.
  User: sun-d
  Date: 2019/11/6
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springMvc</title>
</head>
<body>
    <a href="account/findAll">测试</a>

    <form action="account/save" method="post">
        姓名：<input type="text" name="name">
        金额：<input type="text" name="money">
        <input type="submit" value="保存">
    </form>

    <a href="account/saveAll">XML批量保存</a>

</body>
</html>
