<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>用户管理 - MAIPAE - 建筑工程多主体交互平台</title>
        <meta name="keywords" content="MAIPAE,maipae,建筑工程多主体交互平台">
        <meta name="description" content="建筑工程多主体交互平台（MAIPAE）主要通过对建筑工程各责任主体进行质量监督。主要包括工程报监督、工程监督、竣工备案构成。">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
        <base href="<%=request.getContextPath() %>/">
        <meta name="author" content="兰必钟（Basfed Lan）, http://www.basfed.com">
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
    		Integer enterpriseid = (Integer)session.getAttribute("PERSON_EnterpriseID");//从会话中获取各责任主体ID
    		
    		if(personIdentity == null || !(personIdentity.equals("系统管理员"))){
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">系统管理员 - 用户管理</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link" href="AdminServlet?page=admin-index">审核单位资料</a>
                    <a class="mdl-navigation__link is-active" href="EnterpriseServlet?page=admin-person-list">用户管理</a>
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
                            <h1>本系统人员</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th class="mdl-data-table__cell--non-numeric">用户名</th>
                                        <th>手机</th>
                                        <th>邮箱</th>
                                        <th>身份</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${enterprisePersonList}" var="epl">
                                    <tr>
                                        <td class="mdl-data-table__cell--non-numeric">${epl.personName }</td>
                                        <td>${epl.telNumber }</td>
                                        <td>${epl.email }</td>
                                        <td>${epl.personIdentity }</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="mdl-grid page-main mdl-shadow--2dp">
                        <header class="page-header">
                            <h1>注册本单位人员</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <form action="EnterpriseServlet?type=addPerson" method="POST" class="page-form form-cell--12-col">
                            	<input type="hidden" name="enterpriseID" value="<%=enterpriseid%>">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="personName" id="personName">
                                    <label class="mdl-textfield__label" for="personName">用户名</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="tel" name="telNumber" id="telNumber">
                                    <label class="mdl-textfield__label" for="telNumber">手机</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="email" name="email" id="email">
                                    <label class="mdl-textfield__label" for="email">邮箱</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">身份</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="pi-option-1">
                                        <input type="radio" id="pi-option-1" class="mdl-radio__button" name="personIdentity" value="系统管理员">
                                        <span class="mdl-radio__label">系统管理员</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="pi-option-2">
                                        <input type="radio" id="pi-option-2" class="mdl-radio__button" name="personIdentity" value="报监审核员">
                                        <span class="mdl-radio__label">报监审核员</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="pi-option-3">
                                        <input type="radio" id="pi-option-3" class="mdl-radio__button" name="personIdentity" value="站领导">
                                        <span class="mdl-radio__label">站领导</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="pi-option-4">
                                        <input type="radio" id="pi-option-4" class="mdl-radio__button" name="personIdentity" value="监督组长">
                                        <span class="mdl-radio__label">监督组长</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="pi-option-5">
                                        <input type="radio" id="pi-option-5" class="mdl-radio__button" name="personIdentity" value="监督员">
                                        <span class="mdl-radio__label">监督员</span>
                                    </label>
                                </div>
                                <p>
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                                        新增用户
                                    </button>
                                </p>
                            </form>
                        </div>
                    </div>
                </section>
            </main>
        </div>
        <script src="js/material.min.js"></script>
    </body>
</html>