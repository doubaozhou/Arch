var trNum = -1;
var resID = 'null';

function ajaxFileUpload(fileId, id, table) {
    $.ajaxFileUpload({
        type: 'POST',
        url: "/file/upload.do?id=" + id,
        // url: "/file/upload.do",
        secureuri: false,
        fileElementId: fileId,
        dataType: 'json',
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
                var time = data.result;
                table.find("tbody tr:last").find("td").eq(2).html(time);
            } else if (data.code == -1) {
                alert(data.msg);
            }
        },
        error: function (data) {
            alert("Fail !");
        }
    });
}

$(function () {
    //Menu change
    var $menuItem = $('.left-menu .menu a.item'),
        handler = {
            activate: function () {
                if (!$(this).hasClass('dropdown browse')) {
                    $(this)
                        .addClass('active')
                        .closest('.ui.menu')
                        .find('.item')
                        .not($(this))
                        .removeClass('active');

                    var lk = $(this).attr("class").replace("item", "").replace("active", "").trim();
                    $("#main").children().each(function () {
                        // var id = $(this).attr('id');
                        if ($(this).attr('id') == lk) {
                            $(this).show();
                        } else {
                            $(this).hide();
                        }
                    });
                }

                trNum = -1;
                resID = 'null';
            }
        };
    $menuItem.on('click', handler.activate);

    //Add PIC
    $("#picFile").on('change', function () {
        var file = this.files[0];
        var filename = file.name;
        var size = ((file.size / 1024) / 1024).toFixed(2) + "M";
        var id = Math.uuid();
        var pos = -1;
        if (filename.indexOf("\\") > -1) {
            pos = filename.lastIndexOf("\\");
        } else if (filename.indexOf("") > -1) {
            pos = filename.lastIndexOf("/");
        }
        filename = filename.substring(pos + 1);

        var picTB = $("#picTable");
        // var curTime = CurentTime();
        var tnum = picTB.find("tbody").children("tr").length;
        var trHtml = "<tr><td>" + id + "</td><td>" + filename + "</td><td></td><td>" + size + "</td><td></td>" +
            "<td><a style='margin-left: 20px' href='javascript:void(0)' onclick='picData(\"" + id + "\")'>编辑</a>" +
            "<a style='margin-left: 20px' href='javascript:void(0)' onclick='delPic(" + id + ")'>删除</a></td></tr>";
        if (tnum > 0) {
            picTB.find("tbody tr:last").after(trHtml);
        } else {
            picTB.find("tbody").append(trHtml);
        }

        ajaxFileUpload("picFile", id, picTB);
    });

    //Add video
    $("#videoFile").on('change', function () {
        var file = this.files[0];
        var filename = file.name;
        var size = ((file.size / 1024) / 1024).toFixed(2) + "M";
        var id = Math.uuid();
        var pos = -1;
        if (filename.indexOf("\\") > -1) {
            pos = filename.lastIndexOf("\\");
        } else if (filename.indexOf("") > -1) {
            pos = filename.lastIndexOf("/");
        }
        filename = filename.substring(pos + 1);

        var videoTB = $("#videoTable");
        // var curTime = CurentTime();
        var tnum = videoTB.find("tbody").children("tr").length;
        var trHtml = "<tr><td>" + id + "</td><td>" + filename + "</td><td></td><td>" + size + "</td><td></td>" +
            "<td><a style='margin-left: 20px' href='javascript:void(0)' onclick='picData(\"" + id + "\")'>编辑</a>" +
            "<a style='margin-left: 20px' href='javascript:void(0)' onclick='delVideo(" + id + ")'>删除</a></td></tr>";
        if (tnum > 0) {
            videoTB.find("tbody tr:last").after(trHtml);
        } else {
            videoTB.find("tbody").append(trHtml);
        }

        ajaxFileUpload("videoFile", id, videoTB);
    });

    //Add document
    $("#documentFile").on('change', function () {
        var file = this.files[0];
        var filename = file.name;
        var size = ((file.size / 1024) / 1024).toFixed(2) + "M";
        var id = Math.uuid();
        var pos = -1;
        if (filename.indexOf("\\") > -1) {
            pos = filename.lastIndexOf("\\");
        } else if (filename.indexOf("") > -1) {
            pos = filename.lastIndexOf("/");
        }
        filename = filename.substring(pos + 1);

        var documentTB = $("#documentTable");
        // var curTime = CurentTime();
        var tnum = documentTB.find("tbody").children("tr").length;
        var trHtml = "<tr><td>" + id + "</td><td>" + filename + "</td><td></td><td>" + size + "</td><td></td>" +
            "<td><a style='margin-left: 20px' href='javascript:void(0)' onclick='documentData(\"" + id + "\")'>编辑</a>" +
            "<a style='margin-left: 20px' href='javascript:void(0)' onclick='delDocument(" + id + ")'>删除</a></td></tr>";
        if (tnum > 0) {
            documentTB.find("tbody tr:last").after(trHtml);
        } else {
            documentTB.find("tbody").append(trHtml);
        }

        ajaxFileUpload("documentFile", id, documentTB);
    });

});

//open data
function picData(id) {
    window.open("pictureData.jsp?id=" + id);
}

function videoData(id) {
    window.open("videoData.jsp?id=" + id)
}

function drawingData(id) {
    window.open("videoData.jsp?id=" + id)
}

function documentData(id) {
    window.open("videoData.jsp?id=" + id)
}

//delete
function delPic(id) {
    alert("delete");
}

function delVideo(id) {
    alert("delete");
}

function delDrawing(id) {
    alert("delete");
}

function delDocument(id) {
    alert("delete");
}

//get time
/**
 * @return {string}
 */
function CurentTime() {
    var now = new Date();

    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日

    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分

    var clock = year + "-";

    if (month < 10)
        clock += "0";

    clock += month + "-";

    if (day < 10)
        clock += "0";

    clock += day + " ";

    if (hh < 10)
        clock += "0";

    clock += hh + ":";
    if (mm < 10) clock += '0';
    clock += mm;
    return clock;
}

//register dynamic event
$(document).on("click", "table tbody tr", function () {
    if (!$(this).hasClass('active')) {
        $(this)
            .addClass('active')
            .closest('.ui.table')
            .find('tbody tr')
            .not($(this))
            .removeClass('active');
    }
});
