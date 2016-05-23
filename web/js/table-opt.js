var trNum = -1;
var resID = 'null';

function ajaxFileUpload(fileId) {
    if(resID=='null'){
        alert("Upload Error !");
    }

    $.ajaxFileUpload({
        url: "/file/upload.do",
        secureuri: false,
        fileElementId: fileId,
        dataType: 'text',
        data:{
            resID: resID
        },
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
        var filename = $("#picFile").val();
        var pos = -1;
        if (filename.indexOf("\\") > -1) {
            pos = filename.lastIndexOf("\\");
        } else if (filename.indexOf("") > -1) {
            pos = filename.lastIndexOf("/");
        }
        filename = filename.substring(pos + 1);

        var picTB = $("#picTable");
        var tnum = picTB.find("tbody").children("tr").length;
        var trHtml = "<tr><td><input type='radio' name='picRadio' class='ui radio checkbox'></td><td>" + (tnum + 1) + "</td><td>否</td><td>" + filename + "</td></tr>";
        if (tnum > 0) {
            // var temp = tnum-1;
            picTB.find("tbody tr:last").after(trHtml);
        } else {
            picTB.find("tbody").append(trHtml);
        }
    });

    //Save BUTTON for PIC
    $("#picFileSave").click(function () {
        if (trNum == -1 || resID == 'null') {
            alert("请选中一条记录 !");
            return;
        }
        var arr = [], v;
        $('.picSegment input').each(function () {
            v = $(this).val();
            arr.push(v);
        });
        arr.push($(".picSegment textarea").val());

        var tb = $("#picTable").find("tbody tr");
        var hiddenHtml = "<input type='hidden' name='" + resID + "' value='" + arr.join("###") + "'>";
        $("#picTable").find("tbody tr:eq(" + trNum + ")").append(hiddenHtml);
        tb[trNum].cells[2].innerHTML = "已保存，未提交";

        ajaxFileUpload("picFile");
    });
});

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

$(document).on('click', "input[name=picRadio]", function () {
    // trNum = $(this).parent().siblings('td')[0].innerHTML;
    var trs = $("#picTable").find("tbody tr");
    trNum = trs.index($(this).closest('tr'));
    resID = trs[trNum].cells[1].innerHTML;
});


$(function () {


    // var $saveItem = $('#save'),
    // 	$modifyItem = $('#modify'),

    // 	saveAction = {
    // 		activate: function() {
    // 			if ($('input, textarea').attr("disabled", false)) {
    // 				$('input, textarea').attr("disabled", true);

    // 				//store info here
    // 			}
    // 		}
    // 	},
    // 	modifyAction = {
    // 		activate: function() {
    // 			if ($('input, textarea').attr("disabled", true)) {
    // 				$('input, textarea').attr("disabled", false);
    // 			}
    // 		}
    // 	};

    // $saveItem.on('click', saveAction.activate);
    // $modifyItem.on('click', modifyAction.activate);
});