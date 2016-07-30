<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>系统管理员 - MAIPAE - 建筑工程多主体交互平台</title>
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
    		
    		if(personIdentity == null || !(personIdentity.equals("系统管理员"))){
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">系统管理员 - 首页</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link is-active" href="AdminServlet?page=admin-index">审核单位资料</a>
                    <a class="mdl-navigation__link" href="EnterpriseServlet?page=admin-person-list">用户管理</a>
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
                            <h1>待审核的单位注册列表</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th class="mdl-data-table__cell--non-numeric">单位名称</th>
                                        <th>单位成立时间</th>
                                        <th>单位性质</th>
                                        <th>单位员工规模</th>
                                        <th>单位网址</th>
                                        <th>单位联系人</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${enterpriseToBeAuditedList}" var="etbal">
                                	<tr>
                                		<td>${etbal.enterpriseName }</td>
                                		<td>${etbal.enterpriseStartTime }</td>
                                		<td>${etbal.enterpriseCharacter }</td>
                                		<td>${etbal.enterpriseNumber }</td>
                                		<td><a href="${etbal.enterpriseWebSite }">${etbal.enterpriseWebSite }</a></td>
                                		<td>${etbal.enterprisePerson }</td>
                                		<td><a href="AdminServlet?page=admin-review-enterprise-before&enterpriseID=${etbal.enterpriseID}">审核</a></td>
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