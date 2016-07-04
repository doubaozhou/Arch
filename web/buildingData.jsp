<%@ page import="com.arch.entity.Building" %>
<%@ page import="com.arch.service.BuildingService" %><%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2016/5/20
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String id = request.getParameter("id");
    Building building;
    boolean isNew = false;
    if (id == null) {
        building = new Building();
        isNew = true;
        id = "";
    } else {
        BuildingService buildingService = new BuildingService();
        building = buildingService.QueryBuilding(id);
    }
%>
<head>
    <title>建筑基本信息录入</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
    <script type="text/javascript" src="js/InfoSave.js"></script>
    <script>
        function goPic() {
            window.open("pictureList.jsp<%if(!isNew) out.print("?id="+id);%>");
        }
        function goVideo() {
            window.open("videoList.jsp<%if(!isNew) out.print("?id="+id);%>");
        }
        function goDocument() {
            window.open("documentList.jsp<%if(!isNew) out.print("?id="+id);%>");
        }
        function goDrawing() {
            window.open("drawingList.jsp<%if(!isNew) out.print("?id="+id);%>");
        }
        function back() {
            window.location.href = "buildingList.jsp";
        }
    </script>
</head>

<body>
    <header id="header">
        <ul class="header-inner">
            <li class="logo">
                <a href="#">信息录入</a>
            </li>
        </ul>
    </header>
    <input type="hidden" id="bId" value="<%=id%>">
    <div id="basic" style="display: block;width: 98%;margin: 80px auto 0;">
        <div class="ui raised segment h">
            <div class="two fields">
                <div class="field">
                    <h2 class="ui header">
                        <i class="info circle icon"></i>

                        <div class="content">基本信息
                            <div class="sub header">建筑的基本信息 ( 打星号为必填属性 )</div>
                        </div>
                    </h2>
                </div>
                <div class="field">
                    <button id="save" class="ui big green basic button">保存</button>
                    <button id="back" onclick="back()" class="ui big green basic button" style="margin-right: 100px">返回</button>
                    <%
                        if(!isNew) {
                            out.println("<button id=\"pic\" class=\"ui big blue basic button\" onclick=\"goPic()\">图片</button>\n" +
                                    "<button id=\"video\" class=\"ui big blue basic button\" onclick=\"goVideo()\">视频</button>\n" +
                                    "<button id=\"document\" class=\"ui big blue basic button\" onclick=\"goDocument()\">文献</button>\n" +
                                    "<button id=\"drawing\" class=\"ui big blue basic button\" onclick=\"goDrawing()\">图纸</button>");
                        }
                    %>
                </div>
            </div>
        </div>
        <form id="baseInfoForm" method="post" action="baseInfoSave.do">
            <div class="ui large fluid form">
                <div class="ui tall stacked green segment">
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i> 建筑名称
                                </div>
                                <input id="b_name" name="b_name" placeholder="建筑名称" type="text" value="<%=building.getName()%>">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">设计师</div>
                                <input id="b_designer" name="b_designer" placeholder="设计师" type="text" value="<%=building.getDesigner()%>">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>城市
                                </div>
                                <input id="b_city" name="b_city" placeholder="城市" type="text" value="<%=building.getCity()%>">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>建筑年代
                                </div>
                                <input id="b_date" name="b_date" placeholder="建筑年代" type="text" value="<%=building.getDate()%>">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>地址
                                </div>
                                <input id="b_address" name="b_address" placeholder="地址" type="text" value="<%=building.getAddress()%>">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">营造厂</div>
                                <input id="b_company" name="b_company" placeholder="营造厂" type="text" value="<%=building.getConstruct_org()%>">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>建筑类型
                                </div>
                                <input id="b_type" name="b_type" placeholder="建筑类型" type="text" value="<%=building.getType()%>">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>建筑结构
                                </div>
                                <input id="b_structure" name="b_structure" placeholder="建筑结构" type="text" value="<%=building.getStructure()%>">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    <i class="mini asterisk loading icon"></i>建筑风格
                                </div>
                                <input id="b_style" name="b_style" placeholder="建筑风格" type="text" value="<%=building.getStyle()%>">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui fluid large input">
                                <div class="ui right pointing large label">
                                    城市邮编
                                </div>
                                <input id="b_postcode" name="b_postcode" placeholder="城市邮编" type="text" value="<%=building.getPost_code()%>">
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field lb">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>建筑描述
                            </div>
                        </div>
                        <textarea id="b_desc" name="b_desc" placeholder="描述" ><%=building.getDesc()%></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
