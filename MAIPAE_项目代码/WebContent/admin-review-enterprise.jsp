<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>审核单位资料 - MAIPAE - 建筑工程多主体交互平台</title>
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
                    <span class="mdl-layout-title">系统管理员 - 审核单位资料</span>
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
                <c:forEach items="${enterpriseToBeAuditedList}" var="etbal">
                    <div class="mdl-grid page-main mdl-shadow--2dp">
                        <header class="page-header">
                            <h1>单位注册信息详情</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <form class="page-form form-cell--4-col">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseName" value="${etbal.enterpriseName }" readonly="readonly" id="enterpriseName">
                                    <label class="mdl-textfield__label" for="enterpriseName">单位名称</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseStartTime" value="${etbal.enterpriseStartTime }" readonly="readonly" id="enterpriseStartTime">
                                    <label class="mdl-textfield__label" for="enterpriseStartTime">单位成立时间</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseCharacter" value="${etbal.enterpriseCharacter }" readonly="readonly" id="enterpriseCharacter">
                                    <label class="mdl-textfield__label" for="enterpriseCharacter">单位性质</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseAddress" value="${etbal.enterpriseAddress }" readonly="readonly" id="enterpriseAddress">
                                    <label class="mdl-textfield__label" for="enterpriseAddress">单位地址</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="number" name="enterpriseNumber" value="${etbal.enterpriseNumber }" readonly="readonly" id="enterpriseNumber">
                                    <label class="mdl-textfield__label" for="enterpriseNumber">单位员工规模</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="url" name="enterpriseWebSite" value="${etbal.enterpriseWebSite }" readonly="readonly" id="enterpriseWebSite">
                                    <label class="mdl-textfield__label" for="enterpriseWebSite">单位网址</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseOrganCode" value="${etbal.enterpriseOrganCode }" readonly="readonly" id="enterpriseOrganCode">
                                    <label class="mdl-textfield__label" for="enterpriseOrganCode">单位组织机构代码</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterprisePerson" value="${etbal.enterprisePerson }" readonly="readonly" id="enterprisePerson">
                                    <label class="mdl-textfield__label" for="enterprisePerson">单位联系人</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="email" name="enterpriseEmail" value="${etbal.enterpriseEmail }" readonly="readonly" id="enterpriseEmail">
                                    <label class="mdl-textfield__label" for="enterpriseEmail">单位邮箱</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="tel" name="enterprisePersonTel" value="${etbal.enterprisePersonTel }" readonly="readonly" id="enterprisePersonTel">
                                    <label class="mdl-textfield__label" for="enterprisePersonTel">单位联系人手机</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                	<input class="mdl-textfield__input" type="text" name="remarks" value="${etbal.remarks }" readonly="readonly" id="remarks">
                                    <label class="mdl-textfield__label" for="remarks">备注</label>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="mdl-grid page-main mdl-shadow--2dp">
                        <header class="page-header">
                            <h1>审核单位资料，选择审核结果</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                        	<form action="AdminServlet?page=admin-review-enterprise" method="POST" class="page-form form-cell--12-col">
                        		<input type="hidden" name="enterpriseID" value="${etbal.enterpriseID }">
                        		<input type="hidden" name="enterprisePerson" value="${etbal.enterprisePerson }">
                        		<input type="hidden" name="enterprisePassword" value="${etbal.enterprisePassword }">
                        		<input type="hidden" name="enterpriseEmail" value="${etbal.enterpriseEmail }">
                        		<input type="hidden" name="enterprisePersonTel" value="${etbal.enterprisePersonTel }">
                        		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">审核结果</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1">
                                    	<input type="radio" id="option-1" class="mdl-radio__button" name="enterpriseState" value="通过">
                                    	<span class="mdl-radio__label">通过</span>
                                	</label>
                                	<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
                                    	<input type="radio" id="option-2" class="mdl-radio__button" name="enterpriseState" value="不通过">
                                    	<span class="mdl-radio__label">不通过</span>
                                	</label>
                                </div>
                                <p>
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                                            提交
                                    </button>
                                </p>
                            </form>
                        </div>
                    </div>
                </c:forEach>
                </section>
            </main>
        </div>
        <script src="js/material.min.js"></script>
    </body>
</html>