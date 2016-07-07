<%@ page import="com.arch.service.BuildingService" %>
<%@ page import="com.arch.entity.Building" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2016/5/19
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>建筑列表</title>
    <link rel="stylesheet" type="text/css" href="css/myCss.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
<div class="new_header">
    <div class="new_header_div">
        <a href="#" class="logo_img"><img src="img/doge.jpg" width="80" height="80"></a>
        <ul class="header_ul" style=" position:relative">
            <li class="new_cur"><a href="#">建筑列表</a></li>
            <li class="select_head"><a href="#">预留</a></li>
            <li class="select_head"><a href="#">预留</a></li>
            <li class="select_head"><a href="#">预留</a></li>
        </ul>
        <div class="clear"></div>
    </div>
</div>
<!-- topic header -->
<div class="top-pic goods">
    <div class="title">
        <h2 class="text-center">
            <a href="#">建筑列表</a>
        </h2>
    </div>
</div>
<!-- 货源信息 -->
<div class="info-content">
    <!-- search bar -->
    <div class="search_bar">
        <div class="begin">
            <input type="text" id="building_name" class="form-control beginCity_input" placeholder="请输入建筑名称">
        </div>
        <button id="search" class="search">搜索</button>
        <button id="create_building" class="search" onclick="newBuilding()">新建建筑</button>
        <p class="help-block" style="display: none"></p>
    </div>
    <div class="nav_body">
        <div class="home_list">
            <!-- table head -->
            <div class="home_list_top">
                <ul>
                    <li class="b_id">建筑ID</li>
                    <li class="b_name">建筑名称</li>
                    <li class="b_create_time">创建时间</li>
                    <li class="b_desc">建筑描述</li>
                    <li class="b_opr">操作</li>
                </ul>
                <div class="clear"></div>
            </div>
            <!--货源信息-->
            <div id="home_list_body">
                <%
                    BuildingService buildingService = new BuildingService();
                    List<Building> list = buildingService.QueryBuildingList();
                    for (Building building : list) {
                %>
                <div class="home_list_bottom">
                    <div class="home_list_bottom_info">
                        <ul>
                            <li class="b_id"><%=building.getId()%></li>
                            <li class="b_name"><%=building.getName()%></li>
                            <li class="b_create_time"><%=building.getCreate_time()%></li>
                            <li class="b_desc"><%=building.getDesc()%></li>
                            <li class="b_opr"><a class="b_info" href="buildingData.jsp?id=<%=building.getId()%>">建筑信息</a>
                                <a href="DeleteBuilding.do" class="delete">删除</a></li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
                <%
                    }
                %>
            </div>
            <div class="show-more">
                <button id="go_hy" onclick="showmore('QueryInfo.do')"></button>
            </div>
            <!--货源信息-->
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- footer -->
<div class="footer">
    <div class="footer_div" style="height: 30px;">
        <div class="clear"></div>
    </div>
    <div class="footer_bottom">Copyright © 2012-2016 207动物园 版权所有</div>
</div>
</body>
<script>
    function newBuilding() {
        window.location.href = "buildingData.jsp";
    }
</script>
</html>
