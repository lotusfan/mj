$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.position1=$currentel.find(".ooposition1").val();
        oo.position2=$currentel.find(".ooposition2").val();
        oo.name=$currentel.find(".ooname").val();
        oo.type=$currentel.find(".ootype").val();
        oo.position3=$currentel.find(".ooposition3").val();
        oo.time=$currentel.find(".ootime").val();
        oo.general=$currentel.find(".oogeneral").val();
        oo.recommend=$currentel.find(".oorecommend").val();
        oo.picJson=$currentel.find(".oopicJson").val();
        oo.headPic=$currentel.find(".ooheadPic").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        oo.updateTime=$currentel.find(".ooupdateTime").val();
        $.ajax({
            url: "/db/storeTb/update.do",
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