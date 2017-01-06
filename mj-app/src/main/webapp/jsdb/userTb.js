$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.loginName=$currentel.find(".oologinName").val();
        oo.password=$currentel.find(".oopassword").val();
        oo.realName=$currentel.find(".oorealName").val();
        oo.cardNum=$currentel.find(".oocardNum").val();
        oo.signature=$currentel.find(".oosignature").val();
        oo.nickName=$currentel.find(".oonickName").val();
        oo.sex=$currentel.find(".oosex").val();
        oo.age=$currentel.find(".ooage").val();
        oo.city=$currentel.find(".oocity").val();
        oo.school=$currentel.find(".ooschool").val();
        oo.job=$currentel.find(".oojob").val();
        oo.jobTrade=$currentel.find(".oojobTrade").val();
        oo.headPic=$currentel.find(".ooheadPic").val();
        oo.backgroundPic=$currentel.find(".oobackgroundPic").val();
        oo.authentication=$currentel.find(".ooauthentication").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        oo.updateTime=$currentel.find(".ooupdateTime").val();
        $.ajax({
            url: "/db/userTb/update.do",
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