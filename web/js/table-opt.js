var trNum = -1;
var resID = 'null';

function ajaxFileUpload(fileId,id) {
    $.ajaxFileUpload({
        url: "/file/upload.do?id="+id,
        secureuri: false,
        fileElementId: fileId,
        dataType: 'text',
        success: function (data, status) {
            alert(data);
        },
        error: (function (data, status, e) {
            /* Act on the event */
        })
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
        var tnum = picTB.find("tbody").children("tr").length;
        var trHtml = "<tr><td>" + id + "</td><td>" + filename + "</td><td></td><td>" + size + "</td><td></td>" +
            "<td><a style='margin-left: 20px' href='javascript:void(0)' onclick='picData(\"" + id + "\")'>编辑</a>" +
            "<a style='margin-left: 20px' href='javascript:void(0)' onclick='delPic(" + id + ")'>删除</a></td></tr>";
        if (tnum > 0) {
            picTB.find("tbody tr:last").after(trHtml);
        } else {
            picTB.find("tbody").append(trHtml);
        }

        ajaxFileUpload("picFile",id);
    });

});

function picData(id) {
    window.open("pictureData.jsp?id=" + id);
}

function delPic(id) {
    alert("delete");
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
