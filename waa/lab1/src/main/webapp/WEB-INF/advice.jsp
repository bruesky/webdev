<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 9/30/19
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${advice}" var="str" varStatus="s">
    <c:if test="${s.index%2==0}">
        <div style="color: blanchedalmond">${str}</div>
    </c:if>
    <c:if test="${s.index%2==1}">
        <div style="color: yellow">${str}</div>
    </c:if>

</c:forEach>

<c:choose>
    <c:when test = "${salary <= 0}">
        Salary is very low to survive.
    </c:when>

    <c:when test = "${salary > 1000}">
        Salary is very good.
    </c:when>

    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>

</body>
</html>
