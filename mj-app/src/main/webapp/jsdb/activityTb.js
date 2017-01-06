$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.name=$currentel.find(".ooname").val();
        oo.place=$currentel.find(".ooplace").val();
        oo.detail=$currentel.find(".oodetail").val();
        oo.createUserId=$currentel.find(".oocreateUserId").val();
        oo.time=$currentel.find(".ootime").val();
        oo.storeJson=$currentel.find(".oostoreJson").val();
        oo.headPic=$currentel.find(".ooheadPic").val();
        oo.deleteFlag=$currentel.find(".oodeleteFlag").val();
        oo.status=$currentel.find(".oostatus").val();
        oo.qrcode=$currentel.find(".ooqrcode").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        $.ajax({
            url: "/db/activityTb/update.do",
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