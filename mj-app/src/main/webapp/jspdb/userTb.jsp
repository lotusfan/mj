<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>userTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/userTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>loginName</td>
        <td>password</td>
        <td>realName</td>
        <td>cardNum</td>
        <td>signature</td>
        <td>nickName</td>
        <td>sex</td>
        <td>age</td>
        <td>city</td>
        <td>school</td>
        <td>job</td>
        <td>jobTrade</td>
        <td>headPic</td>
        <td>backgroundPic</td>
        <td>authentication</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${userTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oologinName" value="${oo.loginName}" /></td>
        <td><input class="oopassword" value="${oo.password}" /></td>
        <td><input class="oorealName" value="${oo.realName}" /></td>
        <td><input class="oocardNum" value="${oo.cardNum}" /></td>
        <td><input class="oosignature" value="${oo.signature}" /></td>
        <td><input class="oonickName" value="${oo.nickName}" /></td>
        <td><input class="oosex" value="${oo.sex}" /></td>
        <td><input class="ooage" value="${oo.age}" /></td>
        <td><input class="oocity" value="${oo.city}" /></td>
        <td><input class="ooschool" value="${oo.school}" /></td>
        <td><input class="oojob" value="${oo.job}" /></td>
        <td><input class="oojobTrade" value="${oo.jobTrade}" /></td>
        <td><input class="ooheadPic" value="${oo.headPic}" /></td>
        <td><input class="oobackgroundPic" value="${oo.backgroundPic}" /></td>
        <td><input class="ooauthentication" value="${oo.authentication}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>