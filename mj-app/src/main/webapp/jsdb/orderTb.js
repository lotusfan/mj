$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.sn=$currentel.find(".oosn").val();
        oo.price=$currentel.find(".ooprice").val();
        oo.payPrice=$currentel.find(".oopayPrice").val();
        oo.payStatus=$currentel.find(".oopayStatus").val();
        oo.status=$currentel.find(".oostatus").val();
        oo.userId=$currentel.find(".oouserId").val();
        oo.activityId=$currentel.find(".ooactivityId").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        oo.updateTime=$currentel.find(".ooupdateTime").val();
        $.ajax({
            url: "/db/orderTb/update.do",
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