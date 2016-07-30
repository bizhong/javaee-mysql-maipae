<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>站领导 - MAIPAE - 建筑工程多主体交互平台</title>
        <meta name="keywords" content="MAIPAE,maipae,建筑工程多主体交互平台">
        <meta name="description" content="建筑工程多主体交互平台（MAIPAE）主要通过对建筑工程各责任主体进行质量监督。主要包括工程报监督、工程监督、竣工备案构成。">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
        <base href="<%=request.getContextPath() %>/">
        <meta name="author" content="Java EE 第8组：兰必钟，黄惠清，郭昊，杨雯升，怀智博，丹增乔热">
        <meta name="robots" content="index, follow">
        <link rel="shortcut icon" href="images/maipae-logo.png">
        <link rel="stylesheet" href="css/material.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
    	<%
    		request.setCharacterEncoding("utf-8");
    		
    		session = request.getSession(true);//获取会话对象
    		String personIdentity = (String)session.getAttribute("PERSON_Identity");//从会话中获取人员身份
    		
    		if(personIdentity == null || !(personIdentity.equals("站领导"))){
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">站领导 - 首页</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link is-active" href="StationleaderServlet?page=stationleader-index">分配监督组</a>
                </nav>
                <footer class="footer mdl-color-text--blue-grey-100" role="contentinfo">
                    <p>© 2016 MAIPAE</p>
                </footer>
            </div>
            <main class="mdl-layout__content mdl-color--grey-100" role="main">
                <!-- 主要内容 -->
                <section class="section">
                    <div class="mdl-grid page-main mdl-shadow--2dp">
                        <header class="page-header">
                            <h1>分配监督组</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th class="mdl-data-table__cell--non-numeric">项目名</th>
                                        <th>项目开始时间</th>
                                        <th>项目结束时间</th>
                                        <th>质监站属地</th>
                                        <th>质监站名称</th>
                                        <th>报监状态</th>
                                        <th>审核状态</th>
                                        <th>负责人</th>
                                        <th>分配监督组</th>
                                        <th>修改监督组</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${statedProjectList}" var="spl">
                                    <tr>
                                        <td class="mdl-data-table__cell--non-numeric">${spl.projectName }</td>
                                        <td>${spl.projectStartTime }</td>
                                        <td>${spl.projectEndTime }</td>
                                        <td>${spl.belongStations }</td>
                                        <td>${spl.stationName }</td>
                                        <td>${spl.monitorState }</td>
                                        <td>${spl.state }</td>
                                        <td>${spl.personID }</td>
                                    <c:choose>
                                    <c:when test="${psgList.size() > 0 }">
                                        <c:forEach items="${psgList}" var="psgl">
                                            <c:if test="${spl.projectID == psgl.projectID}"><% isHave = true; %></c:if>
                                        </c:forEach>
                                        <c:choose>
                                            <c:when test="${isHave != true }">
                                        <td><a href="StationleaderServlet?type=addPSGroup&projectID=${spl.projectID }">分配</a></td>
                                        <td></td>
                                            </c:when>
                                            <c:otherwise>
                                        <td></td>
                                        <td><a href="StationleaderServlet?type=modifyPSGroup&projectID=${spl.projectID }">修改</a></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="StationleaderServlet?type=addPSGroup&projectID=${spl.projectID }">分配</a></td>
                                        <td></td>
                                    </c:otherwise>
                                    </c:choose>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
            </main>
        </div>
        <script src="js/material.min.js"></script>
    </body>
</html>