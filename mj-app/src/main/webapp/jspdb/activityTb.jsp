<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>activityTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/activityTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>place</td>
        <td>detail</td>
        <td>createUserId</td>
        <td>time</td>
        <td>storeJson</td>
        <td>headPic</td>
        <td>deleteFlag</td>
        <td>status</td>
        <td>qrcode</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${activityTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ooname" value="${oo.name}" /></td>
        <td><input class="ooplace" value="${oo.place}" /></td>
        <td><input class="oodetail" value="${oo.detail}" /></td>
        <td><input class="oocreateUserId" value="${oo.createUserId}" /></td>
        <td><input class="ootime" value="${oo.time}" /></td>
        <td><input class="oostoreJson" value="${oo.storeJson}" /></td>
        <td><input class="ooheadPic" value="${oo.headPic}" /></td>
        <td><input class="oodeleteFlag" value="${oo.deleteFlag}" /></td>
        <td><input class="oostatus" value="${oo.status}" /></td>
        <td><input class="ooqrcode" value="${oo.qrcode}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>