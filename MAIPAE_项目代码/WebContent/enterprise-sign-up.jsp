<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>注册单位 - MAIPAE - 建筑工程多主体交互平台</title>
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
        <div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">各责任主体 - 注册单位</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link is-active" href="enterprise-sign-up.jsp">注册单位</a>
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
                            <h1>注册单位</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <form action="EnterpriseServlet?type=add" method="POST" class="page-form form-cell--12-col">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseName" autofocus id="enterpriseName">
                                    <label class="mdl-textfield__label" for="enterpriseName">单位名称</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="date" name="enterpriseStartTime" id="enterpriseStartTime">
                                    <label class="mdl-textfield__label" for="enterpriseStartTime">单位成立时间</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">单位性质</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="ec-option-1">
                                        <input type="radio" id="ec-option-1" class="mdl-radio__button" name="enterpriseCharacter" value="建设单位">
                                        <span class="mdl-radio__label">建设单位</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="ec-option-2">
                                        <input type="radio" id="ec-option-2" class="mdl-radio__button" name="enterpriseCharacter" value="施工单位">
                                        <span class="mdl-radio__label">施工单位</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="ec-option-3">
                                        <input type="radio" id="ec-option-3" class="mdl-radio__button" name="enterpriseCharacter" value="监理单位">
                                        <span class="mdl-radio__label">监理单位</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="ec-option-4">
                                        <input type="radio" id="ec-option-4" class="mdl-radio__button" name="enterpriseCharacter" value="设计单位">
                                        <span class="mdl-radio__label">设计单位</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="ec-option-5">
                                        <input type="radio" id="ec-option-5" class="mdl-radio__button" name="enterpriseCharacter" value="勘察单位">
                                        <span class="mdl-radio__label">勘察单位</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="ec-option-6">
                                        <input type="radio" id="ec-option-6" class="mdl-radio__button" name="enterpriseCharacter" value="检测单位">
                                        <span class="mdl-radio__label">检测单位</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseAddress" id="enterpriseAddress">
                                    <label class="mdl-textfield__label" for="enterpriseAddress">单位地址</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">单位员工规模</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-1">
                                        <input type="radio" id="en-option-1" class="mdl-radio__button" name="enterpriseNumber" value="100">
                                        <span class="mdl-radio__label">100</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-2">
                                        <input type="radio" id="en-option-2" class="mdl-radio__button" name="enterpriseNumber" value="200">
                                        <span class="mdl-radio__label">200</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-3">
                                        <input type="radio" id="en-option-3" class="mdl-radio__button" name="enterpriseNumber" value="300">
                                        <span class="mdl-radio__label">300</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-4">
                                        <input type="radio" id="en-option-4" class="mdl-radio__button" name="enterpriseNumber" value="400">
                                        <span class="mdl-radio__label">400</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-5">
                                        <input type="radio" id="en-option-5" class="mdl-radio__button" name="enterpriseNumber" value="500">
                                        <span class="mdl-radio__label">500</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-6">
                                        <input type="radio" id="en-option-6" class="mdl-radio__button" name="enterpriseNumber" value="600">
                                        <span class="mdl-radio__label">600</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-7">
                                        <input type="radio" id="en-option-7" class="mdl-radio__button" name="enterpriseNumber" value="700">
                                        <span class="mdl-radio__label">700</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-8">
                                        <input type="radio" id="en-option-8" class="mdl-radio__button" name="enterpriseNumber" value="800">
                                        <span class="mdl-radio__label">800</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-9">
                                        <input type="radio" id="en-option-9" class="mdl-radio__button" name="enterpriseNumber" value="900">
                                        <span class="mdl-radio__label">900</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="en-option-10">
                                        <input type="radio" id="en-option-10" class="mdl-radio__button" name="enterpriseNumber" value="1000">
                                        <span class="mdl-radio__label">1000</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="url" name="enterpriseWebSite" id="enterpriseWebSite">
                                    <label class="mdl-textfield__label" for="enterpriseWebSite">单位网址</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterpriseOrganCode" id="enterpriseOrganCode">
                                    <label class="mdl-textfield__label" for="enterpriseOrganCode">单位组织机构代码</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="enterprisePerson" id="enterprisePerson">
                                    <label class="mdl-textfield__label" for="enterprisePerson">单位联系人</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="email" name="enterpriseEmail" id="enterpriseEmail">
                                    <label class="mdl-textfield__label" for="enterpriseEmail">单位邮箱</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="tel" name="enterprisePersonTel" id="enterprisePersonTel">
                                    <label class="mdl-textfield__label" for="enterprisePersonTel">单位联系人手机</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="password" name="enterprisePassword" id="enterprisePassword">
                                    <label class="mdl-textfield__label" for="enterprisePassword">单位密码</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <textarea class="mdl-textfield__input" type="text" name="remarks" rows="5" id="remarks"></textarea>
                                    <label class="mdl-textfield__label" for="remarks">备注</label>
                                </div>
                                <p>
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                                        提交
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