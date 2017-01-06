<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>storeTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/storeTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>position1</td>
        <td>position2</td>
        <td>name</td>
        <td>type</td>
        <td>position3</td>
        <td>time</td>
        <td>general</td>
        <td>recommend</td>
        <td>picJson</td>
        <td>headPic</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${storeTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ooposition1" value="${oo.position1}" /></td>
        <td><input class="ooposition2" value="${oo.position2}" /></td>
        <td><input class="ooname" value="${oo.name}" /></td>
        <td><input class="ootype" value="${oo.type}" /></td>
        <td><input class="ooposition3" value="${oo.position3}" /></td>
        <td><input class="ootime" value="${oo.time}" /></td>
        <td><input class="oogeneral" value="${oo.general}" /></td>
        <td><input class="oorecommend" value="${oo.recommend}" /></td>
        <td><input class="oopicJson" value="${oo.picJson}" /></td>
        <td><input class="ooheadPic" value="${oo.headPic}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>