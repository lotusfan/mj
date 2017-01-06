$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.content=$currentel.find(".oocontent").val();
        oo.picJson=$currentel.find(".oopicJson").val();
        oo.forwardFlag=$currentel.find(".ooforwardFlag").val();
        oo.forwardNewsId=$currentel.find(".ooforwardNewsId").val();
        oo.userId=$currentel.find(".oouserId").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        $.ajax({
            url: "/db/userNewsTb/update.do",
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