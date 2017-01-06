<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>userFocusTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/userFocusTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>activeUserId</td>
        <td>passiveUserId</td>
        <td>deleteFlag</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${userFocusTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ooactiveUserId" value="${oo.activeUserId}" /></td>
        <td><input class="oopassiveUserId" value="${oo.passiveUserId}" /></td>
        <td><input class="oodeleteFlag" value="${oo.deleteFlag}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>