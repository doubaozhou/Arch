<%@ page import="com.arch.service.PictureService" %>
<%@ page import="com.arch.entity.Picture" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2016/5/21
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片列表</title>
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
                <a href="#">图片录入</a>
            </li>
        </ul>
    </header>
    <div id="pic" style="display:block;width: 98%;height: 100%;margin: 80px auto 0;">
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
                </div>
            </div>
        </div>
        <%
            String bId = request.getParameter("id");
            PictureService pictureService = new PictureService();
            List<Picture> list = pictureService.QueryPictureList();
        %>
        <input type="hidden" id="bId" value="<%=bId%>">
        <div class="ui large fluid form">
            <div class="ui green segment tableSegment" style="height: 700px;">
                <table id="picTable" class="ui selectable fixed celled table">
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
                    <%
                        for (Picture picture : list) {
                            String id = picture.getId();
                            %>
                    <tr>
                        <td><%=id%></td>
                        <td><%=picture.getName()%></td>
                        <td><%=picture.getCreate_time()%></td>
                        <td><%=picture.getSize()%></td>
                        <td><%=picture.getDesc()%></td>
                        <td>
                            <a style="margin-left: 20px" href="javascript:void(0)" onclick="picData('<%=id%>')">编辑</a>
                            <a style="margin-left: 20px" href="javascript:void(0)" onclick="delPic('<%=id%>')">删除</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
