<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>userNewsTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/userNewsTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>content</td>
        <td>picJson</td>
        <td>forwardFlag</td>
        <td>forwardNewsId</td>
        <td>userId</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${userNewsTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oocontent" value="${oo.content}" /></td>
        <td><input class="oopicJson" value="${oo.picJson}" /></td>
        <td><input class="ooforwardFlag" value="${oo.forwardFlag}" /></td>
        <td><input class="ooforwardNewsId" value="${oo.forwardNewsId}" /></td>
        <td><input class="oouserId" value="${oo.userId}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>