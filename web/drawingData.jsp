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
    <title>图纸信息</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
</head>
<body>
    <div class="ui green segment picSegment">
        <header id="header">
            <ul class="header-inner">
                <li class="logo">
                    <a href="#">图纸录入</a>
                </li>
            </ul>
        </header>
        <div id="basic" style="display: block;width: 98%;margin: 80px auto 0;">
            <div class="ui raised segment h">
                <div class="two fields">
                    <div class="field">
                        <h2 class="ui header">
                            <i class="info circle icon"></i>

                            <div class="content">图纸信息
                                <div class="sub header">建筑的图纸信息 ( 打星号为必填属性 )</div>
                            </div>
                        </h2>
                    </div>
                    <div class="field">
                        <button id="drawingSave" class="ui big green basic button" style="margin-right: 200px">保存</button>
                    </div>
                </div>
            </div>
            <form id="drawingInfoForm" method="post" action="drawingInfoSave.do">
                <div class="ui large fluid form">
                    <div class="ui tall stacked green segment">
                        <div class="two fields">
                            <div class="field">
                                <div class="ui fluid large input">
                                    <div class="ui right pointing large label">
                                        <i class="mini asterisk loading icon"></i> 图纸名称
                                    </div>
                                    <input id="dr_name" name="dr_name" value="" placeholder="图纸名称" type="text">
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui fluid large input">
                                    <div class="ui right pointing large label">拥有者</div>
                                    <input id="dr_owner" name="dr_owner" value="" placeholder="拥有者" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field lb">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>图纸描述
                                </div>
                            </div>
                            <textarea id="dr_desc" name="dr_desc" placeholder="描述"></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
