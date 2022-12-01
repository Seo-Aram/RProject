<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-28
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../parts/default-items.jsp"%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form method="post">
            <input type="email" name="userId" id="userId">
            <input type="password" name="userPw" id="userPw">
            <input type="submit" value="login">
        </form>
    </body>
<c:if test="${param.result=='e'}">
    <script>
        alert("로그인 실패");
    </script>
</c:if>
<c:if test="${param.result=='t'}">
    <script>
        alert("로그인 성공");
    </script>
</c:if>
</html>
