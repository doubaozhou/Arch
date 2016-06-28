<%--
  Created by IntelliJ IDEA.
  User: I331314
  Date: 2016/6/13
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图纸列表</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/uuid.js"></script>
    <script type="text/javascript" src="js/table-opt.js"></script>
</head>
<body>
<header id="header">
    <ul class="header-inner">
        <li class="logo">
            <a href="#">视频录入</a>
        </li>
    </ul>
</header>
    <div id="drawing" style="display:block;width: 98%;height: 100%;margin: 80px auto 0;">
        <div class="ui raised segment h">
            <div class="two fields">
                <div class="field">
                    <h2 class="ui header">
                        <i class="photo icon"></i>

                        <div class="content">视频信息
                            <div class="sub header">视频信息录入 ( 打星号为必填属性 )</div>
                        </div>
                    </h2>
                </div>
                <div class="field">
                    <input type="file" id="drawingFile" name="drawingFile" style="display:none" onchange="">
                    <input type="button" class="ui big primary button" value="选择视频" onclick="drawingFile.click()">
                </div>
            </div>
        </div>
        <div class="ui large fluid form">
            <div class="ui green segment tableSegment" style="height: 700px;">
                <table id="drawingTable" class="ui selectable fixed celled table">
                    <thead>
                    <tr>
                        <th class="four wide">ID</th>
                        <th class="two wide">文件名</th>
                        <th class="two wide">创建时间</th>
                        <th class="two wide">文件大小</th>
                        <th class="four wide">文件描述</th>
                        <th class="two wide">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>