<%@ page import="com.arch.service.VideoService" %>
<%@ page import="com.arch.entity.Video" %><%--
  Created by IntelliJ IDEA.
  User: I331314
  Date: 2016/6/10
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频信息</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
</head>
<%
    String id = request.getParameter("id");
    VideoService videoService = new VideoService();
    Video video = videoService.QueryVideo(id);
%>
<body>
    <div class="ui green segment picSegment">
        <header id="header">
            <ul class="header-inner">
                <li class="logo">
                    <a href="#">视频录入</a>
                </li>
            </ul>
        </header>
        <input type="hidden" id="videoId" value="<%=id%>">
        <div id="basic" style="display: block;width: 98%;margin: 80px auto 0;">
            <div class="ui raised segment h">
                <div class="two fields">
                    <div class="field">
                        <h2 class="ui header">
                            <i class="info circle icon"></i>

                            <div class="content">视频信息
                                <div class="sub header">建筑的视频信息 ( 打星号为必填属性 )</div>
                            </div>
                        </h2>
                    </div>
                    <div class="field">
                        <button id="videoSave" class="ui big green basic button">保存</button>
                        <button id="pic_close" onclick="c()" class="ui big green basic button" style="margin-right: 100px">返回</button>
                    </div>
                </div>
            </div>
            <form id="videoInfoForm" method="post" action="videoInfoSave.do">
                <div class="ui large fluid form">
                    <div class="ui tall stacked green segment">
                        <div class="two fields">
                            <div class="field">
                                <div class="ui fluid large input">
                                    <div class="ui right pointing large label">
                                        <i class="mini asterisk loading icon"></i> 视频名称
                                    </div>
                                    <input id="video_name" name="video_name" value="<%=video.getName()%>" placeholder="视频名称" type="text">
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui fluid large input">
                                    <div class="ui right pointing large label">
                                        <i class="mini asterisk loading icon"></i>视频年代
                                    </div>
                                    <input id="video_date" name="video_date" value="<%=video.getDate()%>" placeholder="视频年代" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <div class="ui fluid large input">
                                    <div class="ui right pointing large label">拥有者</div>
                                    <input id="video_owner" name="video_owner" value="<%=video.getOwner()%>" placeholder="拥有者" type="text">
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui fluid large input">
                                    <div class="ui right pointing large label">视频关键字</div>
                                    <input id="video_keyword" name="video_keyword" value="<%=video.getKey_word()%>" placeholder="关键字" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field lb">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>视频描述
                                </div>
                            </div>
                            <textarea id="video_desc" name="video_desc" placeholder="描述"><%=video.getDesc()%></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
