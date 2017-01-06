<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>orderSubTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/orderSubTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>payTypeCode</td>
        <td>payTypeName</td>
        <td>orderId</td>
        <td>orderSn</td>
        <td>activityName</td>
        <td>activityId</td>
        <td>storeJson</td>
        <td>goodsJson</td>
        <td>billFlag</td>
        <td>createTime</td>
        <td>updateTime</td>
        <td>tradeno</td>
    </tr>
    <c:forEach var="oo" items="${orderSubTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oopayTypeCode" value="${oo.payTypeCode}" /></td>
        <td><input class="oopayTypeName" value="${oo.payTypeName}" /></td>
        <td><input class="ooorderId" value="${oo.orderId}" /></td>
        <td><input class="ooorderSn" value="${oo.orderSn}" /></td>
        <td><input class="ooactivityName" value="${oo.activityName}" /></td>
        <td><input class="ooactivityId" value="${oo.activityId}" /></td>
        <td><input class="oostoreJson" value="${oo.storeJson}" /></td>
        <td><input class="oogoodsJson" value="${oo.goodsJson}" /></td>
        <td><input class="oobillFlag" value="${oo.billFlag}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><input class="ootradeno" value="${oo.tradeno}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>