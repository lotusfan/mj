<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>newsCommentTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/newsCommentTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>newsId</td>
        <td>newsUserId</td>
        <td>userId</td>
        <td>replyUserId</td>
        <td>parentCommentId</td>
        <td>deleteFlag</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${newsCommentTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oonewsId" value="${oo.newsId}" /></td>
        <td><input class="oonewsUserId" value="${oo.newsUserId}" /></td>
        <td><input class="oouserId" value="${oo.userId}" /></td>
        <td><input class="ooreplyUserId" value="${oo.replyUserId}" /></td>
        <td><input class="ooparentCommentId" value="${oo.parentCommentId}" /></td>
        <td><input class="oodeleteFlag" value="${oo.deleteFlag}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>