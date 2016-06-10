<%@ page import="com.arch.entity.Picture" %>
<%@ page import="com.arch.service.PictureService" %><%--
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
<%
    String id = request.getParameter("id");
    Picture picture;
    boolean isNew = false;
    if (id == null) {
        picture = new Picture();
        isNew = true;
    } else {
        PictureService pictureService = new PictureService();
        picture = pictureService.QueryPicture(id);
    }
%>
<body>
<div class="ui green segment picSegment">
    <header id="header">
        <ul class="header-inner">
            <li class="logo">
                <a href="#">信息录入</a>
            </li>
        </ul>
    </header>
    <div id="basic" style="display: block;width: 98%;margin: 80px auto 0;">
        <div class="ui raised segment h">
            <div class="two fields">
                <div class="field">
                    <h2 class="ui header">
                        <i class="info circle icon"></i>

                        <div class="content">图片信息
                            <div class="sub header">建筑的图片信息 ( 打星号为必填属性 )</div>
                        </div>
                    </h2>
                </div>
                <div class="field">
                    <button id="save" class="ui big green basic button" style="margin-right: 200px">保存</button>
                </div>
            </div>
        </div>
        <form id="picInfoForm" method="post" action="picInfoSave.do">
            <div class="ui large fluid form">
                <div class="ui tall stacked green segment">
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i> 照片名称
                                </div>
                                <input id="pic_name" name="pic_name" placeholder="照片名称" type="text" value="">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>照片类型
                                </div>
                                <input id="pic_type" name="pic_type" value="" placeholder="照片类型" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">照片来源</div>
                                <input id="pic_origin" name="pic_origin" value="" placeholder="照片来源" type="text">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">照片年代</div>
                                <input id="pic_date" name="pic_date" value="" placeholder="照片年代" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">相关设计师</div>
                                <input id="pic_relative_designer" name="pic_relative_designer" value=""
                                       placeholder="相关设计师" type="text">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">相关营造厂</div>
                                <input id="pic_relative_com" name="pic_relative_com" value="" placeholder="相关营造厂"
                                       type="text">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field lb">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>照片描述
                            </div>
                        </div>
                        <textarea id="pic_desc" name="pic_desc" placeholder="描述"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>


</div>
</body>
</html>
