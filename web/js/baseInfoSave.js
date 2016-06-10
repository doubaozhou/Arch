/**
 * Created by zhou on 2016/5/21.
 * @author zhou
 */
$(function () {
    $("#save").click(function () {
        var name = $("#b_name").val();
        var city = $("#b_city").val();
        var date = $("#b_date").val();
        var address = $("#b_address").val();
        var type = $("#b_type").val();
        var structure = $("#b_structure").val();
        var style = $("#b_style").val();
        var desc = $("#b_desc").val();
        if (name == "" || city == "" || date == "" || address == "" || type == "" || structure == "" || style == "" || desc == "") {
            alert("加星号属性必填!!");
            return false;
        } else {
            var d = $("#baseInfoForm").serialize();
            $.post("baseInfoSave.do", d, function (data) {
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "buildingList.jsp";
                } else if (data.code == -1) {
                    alert("录入失败!");
                }
            });
        }
    })
});