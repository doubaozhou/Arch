<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2016/5/21
  Time: 14:18
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
    <header id="header">
        <ul class="header-inner">
            <li class="logo">
                <a href="#">图片录入</a>
            </li>
        </ul>
    </header>
    <div id="pic" style="display:block;width: 98%;margin: 80px auto 0;">
        <div class="ui raised segment h">
            <div class="two fields">
                <div class="field">
                    <h2 class="ui header">
                        <i class="photo icon"></i>

                        <div class="content">照片信息
                            <div class="sub header">照片信息录入 ( 打星号为必填属性 )</div>
                        </div>
                    </h2>
                </div>
                <div class="field">
                    <input type="file" id="picFile" name="picFile" style="display:none" onchange="">
                    <input type="button" class="ui big primary button" value="选择照片" onclick="picFile.click()">
                    <button id="picFileSave" class="ui big primary button">保存信息</button>
                </div>
            </div>
        </div>
        <div class="ui large fluid form">
            <div class="ui green segment tableSegment">
                <table id="picTable" class="ui selectable fixed celled table">
                    <thead>
                    <tr>
                        <th class="one wide">选择</th>
                        <th class="three wide">编号</th>
                        <th class="four wide">是否保存</th>
                        <th class="eight wide">文件名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
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
        </div>
    </div>
</body>
</html>
