<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2016/5/23
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片信息</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
</head>
<body>
<div class="ui green segment picSegment">
    <div class="two fields">
        <div class="field">
            <div class="ui fluid large input">
                <div class="ui right pointing large label">
                    <i class="mini asterisk loading icon"></i> 照片名称
                </div>
                <input placeholder="照片名称" type="text">
            </div>
        </div>
        <div class="field">
            <div class="ui fluid large input">
                <div class="ui right pointing large label">
                    <i class="mini asterisk loading icon"></i>照片类型
                </div>
                <input placeholder="照片类型" type="text">
            </div>
        </div>
    </div>
    <div class="two fields">
        <div class="field">
            <div class="ui fluid large input">
                <div class="ui right pointing large label">照片来源</div>
                <input placeholder="照片名称" type="text">
            </div>
        </div>
        <div class="field">
            <div class="ui fluid large input">
                <div class="ui right pointing large label">照片年代</div>
                <input placeholder="照片类型" type="text">
            </div>
        </div>
    </div>
    <div class="two fields">
        <div class="field">
            <div class="ui fluid large input">
                <div class="ui right pointing large label">相关设计师</div>
                <input placeholder="照片名称" type="text">
            </div>
        </div>
        <div class="field">
            <div class="ui fluid large input">
                <div class="ui right pointing large label">相关营造厂</div>
                <input placeholder="照片类型" type="text">
            </div>
        </div>
    </div>
    <div class="two fields">
        <div class="field lb">
            <div class="ui right pointing large label">
                <i class="mini asterisk loading icon"></i>照片描述
            </div>
        </div>
        <textarea placeholder="描述"></textarea>
    </div>
</div>
</body>
</html>
