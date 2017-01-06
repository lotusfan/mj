$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.payTypeCode=$currentel.find(".oopayTypeCode").val();
        oo.payTypeName=$currentel.find(".oopayTypeName").val();
        oo.orderId=$currentel.find(".ooorderId").val();
        oo.orderSn=$currentel.find(".ooorderSn").val();
        oo.activityName=$currentel.find(".ooactivityName").val();
        oo.activityId=$currentel.find(".ooactivityId").val();
        oo.storeJson=$currentel.find(".oostoreJson").val();
        oo.goodsJson=$currentel.find(".oogoodsJson").val();
        oo.billFlag=$currentel.find(".oobillFlag").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        oo.updateTime=$currentel.find(".ooupdateTime").val();
        oo.tradeno=$currentel.find(".ootradeno").val();
        $.ajax({
            url: "/db/orderSubTb/update.do",
            type: "POST",
            data: $.toJSON(oo),
            dataType: "json",
            contentType:"application/json",
            success: function (data) {
                alert(data.msg);
            },
            error: function () {
                alert("请求失败");
            }
        });
    });
});