<%@ page import="com.arch.service.DocumentService" %>
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
    <title>文献信息</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
    <script type="text/javascript" src="js/InfoSave.js"></script>
</head>
<%
    String id = request.getParameter("id");
    DocumentService documentService = new DocumentService();
    Document document = documentService.QueryDocument(id);
%>
<body>
<div class="ui green segment docSegment">
    <header id="header">
        <ul class="header-inner">
            <li class="logo">
                <a href="#">文献录入</a>
            </li>
        </ul>
    </header>
    <input type="hidden" id="documentId" value="<%=id%>">
    <div id="basic" style="display: block;width: 98%;margin: 80px auto 0;">
        <div class="ui raised segment h">
            <div class="two fields">
                <div class="field">
                    <h2 class="ui header">
                        <i class="info circle icon"></i>

                        <div class="content">文献信息
                            <div class="sub header">建筑的文献信息 ( 打星号为必填属性 )</div>
                        </div>
                    </h2>
                </div>
                <div class="field">
                    <button id="documentSave" class="ui big green basic button" style="margin-right: 100px">保存</button>
                </div>
            </div>
        </div>
        <form id="documentInfoForm" method="post" action="documentInfoSave.do">
            <div class="ui large fluid form">
                <div class="ui tall stacked green segment">
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i> 文献名称
                                </div>
                                <input id="doc_name" name="doc_name" value="<%document.getName()=%>" placeholder="文献名称"
                                       type="text">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>作者
                                </div>
                                <input id="doc_author" name="doc_author" value="<%=document.getAuthor()%>"
                                       placeholder="作者" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>关键字
                                </div>
                                <input id="doc_kword" name="doc_kword" value="<%=document.getKey_word()%>"
                                       placeholder="关键字" type="text">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">发表年份</div>
                                <input id="doc_date" name="doc_date" value="<%=document.getDate()%>" placeholder="发表年份"
                                       type="text">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">文献编号</div>
                                <input id="doc_no" name="doc_no" value="<%=document.getSerial_number()%>"
                                       placeholder="文献编号" type="text">
                            </div>
                        </div>
                        <div class="field"></div>
                    </div>
                    <div class="two fields">
                        <div class="field lb">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>摘要
                            </div>
                        </div>
                        <textarea placeholder="摘要"><%document.getD_abstract() =%></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
