<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>collectTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/collectTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>collectUserId</td>
        <td>collectActivityId</td>
        <td>deleteFlag</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${collectTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oocollectUserId" value="${oo.collectUserId}" /></td>
        <td><input class="oocollectActivityId" value="${oo.collectActivityId}" /></td>
        <td><input class="oodeleteFlag" value="${oo.deleteFlag}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>