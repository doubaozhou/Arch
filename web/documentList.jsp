<%@ page import="com.arch.service.DocumentService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arch.entity.Document" %><%--
  Created by IntelliJ IDEA.
  User: I331314
  Date: 2016/6/13
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文献列表</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/uuid.js"></script>
    <script type="text/javascript" src="js/table-opt.js"></script>
    <script type="text/javascript" src="js/InfoSave.js"></script>
</head>
<body>
<header id="header">
    <ul class="header-inner">
        <li class="logo">
            <a href="#">文献录入</a>
        </li>
    </ul>
</header>
<%
    String bId = request.getParameter("id");
    DocumentService documentService = new DocumentService();
    List<Document> list = documentService.QueryDocumentList(bId);
%>
<input type="hidden" id="bId" value="<%=bId%>">
<div id="document" style="display:block;width: 98%;height: 100%;margin: 80px auto 0;">
    <div class="ui raised segment h">
        <div class="two fields">
            <div class="field">
                <h2 class="ui header">
                    <i class="photo icon"></i>

                    <div class="content">文献信息
                        <div class="sub header">文献信息录入 ( 打星号为必填属性 )</div>
                    </div>
                </h2>
            </div>
            <div class="field">
                <input type="file" id="documentFile" name="documentFile" style="display:none" onchange="">
                <input type="button" class="ui big primary button" value="选择文献" onclick="documentFile.click()">
                <button onclick="c()" class="ui big green basic button">返回</button>
            </div>
        </div>
    </div>
    <div class="ui large fluid form">
        <div class="ui green segment tableSegment" style="height: 700px;">
            <table id="documentTable" class="ui selectable fixed celled table">
                <thead>
                <tr>
                    <th class="four wide">ID</th>
                    <th class="two wide">文件名</th>
                    <th class="two wide">创建时间</th>
                    <th class="two wide">文件大小</th>
                    <th class="four wide">摘要</th>
                    <th class="two wide">操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Document document : list) {
                        String id = document.getId();
                %>
                <tr>
                    <td><%=id%>
                    </td>
                    <td><%=document.getName()%>
                    </td>
                    <td><%=document.getCreate_time()%>
                    </td>
                    <td><%=document.getSize()%>
                    </td>
                    <td><%=document.getD_abstract()%>
                    </td>
                    <td>
                        <a style="margin-left: 20px" href="javascript:void(0)" onclick="documentData('<%=id%>')">编辑</a>
                        <a style="margin-left: 20px" href="javascript:void(0)" onclick="delDocument('<%=id%>')">删除</a>
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
