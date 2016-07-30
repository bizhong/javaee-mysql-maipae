<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
                    <%
                    	request.setCharacterEncoding("utf-8");
                        
                        session = request.getSession(true);//获取会话对象
                        Integer personid = (Integer) session.getAttribute("PERSON_ID");//从会话中获取人员ID
                        String personname = (String)session.getAttribute("PERSON_NAME");//从会话中获取人员信息
                        String identity = (String)session.getAttribute("PERSON_Identity");//从会话中获取人员身份
                        
                        String homepageURL = "";//主页URL
                        if("系统管理员".equals(identity)) {
                        	homepageURL = "AdminServlet?page=admin-index";
                        }
                        else if("各责任主体".equals(identity)) {
                        	homepageURL = "EnterpriseServlet?page=enterprise-index";
                        }
                        else if("建设项目负责人".equals(identity)) {
                        	homepageURL = "projectleader-index.jsp";
                        }
                        else if("报监审核员".equals(identity)) {
                        	homepageURL = "auditor-index.jsp";
                        }
                        else if("监督员".equals(identity)) {
                            homepageURL = "SupervisorServlet?type=querysupervisorygroup&flag=scheme&persionID=" + personid;
                        }
                        else if("监督组长".equals(identity)) {
                            homepageURL = "SupervisionleaderServlet?type=querysupervisionleadergroup&flag=scheme&persionID=" + personid;
                        }
                        else {
                        	homepageURL = "";
                        }
                        
                        if(personname != null){//登录成功后显示
                    %>
                    <div class="user-name"><%=personname%></div>
                    <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                        <i class="material-icons">arrow_drop_down</i>
                    </button>
                    <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                        <li class="mdl-menu__item">
                            <a href="<%=homepageURL%>">角色主页</a>
                        </li>
                        <li class="mdl-menu__item">
                            <a href="PersonServlet?type=personInfo&personID=<%=personid%>">个人信息</a>
                        </li>
                        <li class="mdl-menu__item">
                            <a href="PersonServlet?type=logout">退出登录</a>
                        </li>
                    </ul>
                    <%	} else { %>
                    <div class="user-name"><a href="sign-in.jsp">用户登录</a></div>
                    <%  } %>
                </div>
            </header>
            <div class="mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
                <header class="maipae-drawer-header">
                    <h1 class="mdl-layout-title">MAIPAE</h1>
                    <div class="maipae-contact-dropdown mdl-color-text--grey-500">
                        <span>建筑工程多主体交互平台</span>
                        <div class="mdl-layout-spacer"></div>
                        <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
                            <i class="material-icons" role="presentation">arrow_drop_down</i>
                            <span class="visuallyhidden">Accounts</span>
                        </button>
                        <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
                            <li class="mdl-menu__item">
                                <a href="index.jsp">首页</a>
                            </li>
                            <li class="mdl-menu__item">
                                <a href="mailto:contact@maipae.com" target="_blank">邮件</a>
                            </li>
                        </ul>
                    </div>
                </header>
                <nav class="maipae-navigation mdl-navigation mdl-color--blue-grey-800" role="navigation" aria-label="Global Navigation">