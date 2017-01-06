<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>praiseTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/praiseTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>userId</td>
        <td>userNewsId</td>
        <td>deleteFlag</td>
        <td>newsId</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${praiseTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oouserId" value="${oo.userId}" /></td>
        <td><input class="oouserNewsId" value="${oo.userNewsId}" /></td>
        <td><input class="oodeleteFlag" value="${oo.deleteFlag}" /></td>
        <td><input class="oonewsId" value="${oo.newsId}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>