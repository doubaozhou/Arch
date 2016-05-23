<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2015/11/6
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>信息录入</title>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/table-opt.js"></script>
    <script type="text/javascript" src="js/semantic.min.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
</head>

<body>
<header id="header">
    <ul class="header-inner">
        <li class="logo">
            <a href="#">信息录入</a>
        </li>
    </ul>
</header>
<div class="left-menu">
    <div class="ui vertical pointing menu">
        <a class="item pic active">图片数据录入</a>
        <a class="item drawing">图纸数据录入</a>
        <a class="item video">视频数据录入</a>
        <a class="item document">文献数据录入</a>
    </div>
</div>
<div id="main">
    <div id="pic" style="display:block">
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
    <div id="drawing" style="display:none">
        <div class="ui raised segment">
            <h2 class="ui header">
                <i class="write square icon"></i>

                <div class="content">
                    图纸信息
                    <div class="sub header">图纸信息录入 ( 打星号为必填属性 )</div>
                </div>
            </h2>
        </div>
        <div class="ui large fluid form">
            <div class="ui green segment tableSegment">
                <table class="ui selectable fixed celled table">
                    <thead>
                    <tr>
                        <th class="two wide">序号</th>
                        <th class="six wide">图纸名称</th>
                        <th class="eight wide">本地路径</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="ui green segment">
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i> 图纸名称
                            </div>
                            <input placeholder="图纸名称" type="text">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>图纸年代
                            </div>
                            <input placeholder="图纸年代" type="text">
                        </div>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">拥有者</div>
                            <input placeholder="拥有者" type="text">
                        </div>
                    </div>
                    <div class="field"></div>
                </div>
                <div class="two fields">
                    <div class="field lb">
                        <div class="ui right pointing large label">
                            <i class="mini asterisk loading icon"></i>图纸描述
                        </div>
                    </div>
                    <textarea placeholder="描述"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div id="video" style="display:none">
        <div class="ui raised segment">
            <h2 class="ui header">
                <i class="film icon"></i>

                <div class="content">
                    视频信息
                    <div class="sub header">视频信息录入 ( 打星号为必填属性 )</div>
                </div>
            </h2>
        </div>
        <div class="ui large fluid form">
            <div class="ui green segment tableSegment">
                <table class="ui selectable fixed celled table">
                    <thead>
                    <tr>
                        <th class="two wide">序号</th>
                        <th class="six wide">视频名称</th>
                        <th class="eight wide">本地路径</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="ui green segment">
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i> 视频名称
                            </div>
                            <input placeholder="视频名称" type="text">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>视频年代
                            </div>
                            <input placeholder="视频年代" type="text">
                        </div>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">拥有者</div>
                            <input placeholder="拥有者" type="text">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">视频关键字</div>
                            <input placeholder="关键字" type="text">
                        </div>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field lb">
                        <div class="ui right pointing large label">
                            <i class="mini asterisk loading icon"></i>视频描述
                        </div>
                    </div>
                    <textarea placeholder="描述"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div id="document" style="display:none">
        <div class="ui raised segment">
            <h2 class="ui header">
                <i class="newspaper icon"></i>

                <div class="content">
                    文献信息
                    <div class="sub header">文献信息录入 ( 打星号为必填属性 )</div>
                </div>
            </h2>
        </div>
        <div class="ui large fluid form">
            <div class="ui green segment tableSegment">
                <table class="ui selectable fixed celled table">
                    <thead>
                    <tr>
                        <th class="two wide">序号</th>
                        <th class="six wide">文献名称</th>
                        <th class="eight wide">本地路径</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="ui green segment">
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i> 文献名称
                            </div>
                            <input placeholder="文献名称" type="text">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>作者
                            </div>
                            <input placeholder="作者" type="text">
                        </div>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">
                                <i class="mini asterisk loading icon"></i>关键字
                            </div>
                            <input placeholder="关键字" type="text">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">发表年份</div>
                            <input placeholder="发表年份" type="text">
                        </div>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <div class="ui fluid large input">
                            <div class="ui right pointing large label">文献编号</div>
                            <input placeholder="文献编号" type="text">
                        </div>
                    </div>
                    <div class="field"></div>
                </div>
                <div class="two fields">
                    <div class="field lb">
                        <div class="ui right pointing large label">
                            <i class="mini asterisk loading icon"></i>文献描述
                        </div>
                    </div>
                    <textarea placeholder="描述"></textarea>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
