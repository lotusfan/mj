<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>goodsTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/goodsTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>storeId</td>
        <td>commission</td>
        <td>minimumcharge</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${goodsTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oostoreId" value="${oo.storeId}" /></td>
        <td><input class="oocommission" value="${oo.commission}" /></td>
        <td><input class="oominimumcharge" value="${oo.minimumcharge}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>