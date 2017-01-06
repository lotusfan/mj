$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.relationId=$currentel.find(".oorelationId").val();
        oo.type=$currentel.find(".ootype").val();
        oo.userId=$currentel.find(".oouserId").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        $.ajax({
            url: "/db/userLifeLineTb/update.do",
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