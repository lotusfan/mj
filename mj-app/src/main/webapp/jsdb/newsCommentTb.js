$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.newsId=$currentel.find(".oonewsId").val();
        oo.newsUserId=$currentel.find(".oonewsUserId").val();
        oo.userId=$currentel.find(".oouserId").val();
        oo.replyUserId=$currentel.find(".ooreplyUserId").val();
        oo.parentCommentId=$currentel.find(".ooparentCommentId").val();
        oo.deleteFlag=$currentel.find(".oodeleteFlag").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        $.ajax({
            url: "/db/newsCommentTb/update.do",
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