<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>orderTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/orderTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>sn</td>
        <td>price</td>
        <td>payPrice</td>
        <td>payStatus</td>
        <td>status</td>
        <td>userId</td>
        <td>activityId</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${orderTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oosn" value="${oo.sn}" /></td>
        <td><input class="ooprice" value="${oo.price}" /></td>
        <td><input class="oopayPrice" value="${oo.payPrice}" /></td>
        <td><input class="oopayStatus" value="${oo.payStatus}" /></td>
        <td><input class="oostatus" value="${oo.status}" /></td>
        <td><input class="oouserId" value="${oo.userId}" /></td>
        <td><input class="ooactivityId" value="${oo.activityId}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>