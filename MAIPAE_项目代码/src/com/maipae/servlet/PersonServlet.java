package com.maipae.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maipae.entity.PersonEntity;
import com.maipae.service.PersonService;
import com.maipae.service.impl.PersonServiceImpl;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		if ("verify".equals(type)) {//人员 - 验证登录
            this.verifyPerson(request, response);
        }
		else if ("personInfo".equals(type)) {//人员 - 个人信息
			this.personInfo(request, response);
		}
		else if ("logout".equals(type)) {//人员 - 退出登录
			this.logout(request, response);
		}
	}

	/**
     * Description:[人员 - 验证登录]
     */
    public void verifyPerson(HttpServletRequest request, HttpServletResponse response) {
        String personname = request.getParameter("personName");
        String password = request.getParameter("password");
        
        PersonService personService = new PersonServiceImpl();
        
        List<PersonEntity> personList = personService.verifyPerson(personname, password);
        
        int personid;
        String identity;
        int enterpriseid;
        if(personList != null && personList.size() > 0) {
        	personid = personList.get(0).getPersonID();
        	identity = personList.get(0).getPersonIdentity();
        	enterpriseid = personList.get(0).getEnterpriseID();
        }
        else {
        	personid = 0;
            identity = "no";
            enterpriseid = 0;
        }
        System.out.println(personid);
        System.out.println(identity);
        System.out.println(enterpriseid);
        
        String pageUrl = "";
        boolean verifyFalse = false;
        if("no".equals(identity)) {
        	pageUrl = "sign-in.jsp";
        	verifyFalse = true;
        }
        else if("系统管理员".equals(identity)) {
        	pageUrl = "AdminServlet?page=admin-index";
        }
        else if("各责任主体".equals(identity)) {
        	pageUrl = "EnterpriseServlet?page=enterprise-index";
        }
        else if("建设项目负责人".equals(identity)) {
        	pageUrl = "projectleader-index.jsp";
        }
        else if("报监审核员".equals(identity)) {
        	pageUrl = "AuditorServlet?page=auditor-index";
        }
        else if("站领导".equals(identity)) {
        	pageUrl = "StationleaderServlet?page=stationleader-index";
        }
        else if("监督员".equals(identity)) {
            pageUrl = "SupervisorServlet?type=querysupervisorygroup&flag=scheme&persionID=" + personid;
        }
        else if("监督组长".equals(identity)) {
            pageUrl = "SupervisionleaderServlet?type=querysupervisionleadergroup&flag=scheme&persionID=" + personid;
        }
        
        try {
        	if(!verifyFalse) {
        		HttpSession session = request.getSession();
        		session.setAttribute("PERSON_ID",personid);
        		session.setAttribute("PERSON_NAME",personname);
                session.setAttribute("PERSON_Identity",identity);
                session.setAttribute("PERSON_EnterpriseID",enterpriseid);
        	}
        	
        	response.sendRedirect(pageUrl);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Description:[人员 - 个人信息]
     */
    private void personInfo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int personID = Integer.valueOf(request.getParameter("personID"));
		
		PersonService personService = new PersonServiceImpl();
        
        List<PersonEntity> personInfo = personService.personInfo(personID);
        
        request.setAttribute("personInfo", personInfo);
        
        try {
    		request.getRequestDispatcher("person-info.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Description:[人员 - 退出登录]
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
    	HttpSession session = request.getSession(true);//获取会话对象
    	session.invalidate();
    	
    	try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
