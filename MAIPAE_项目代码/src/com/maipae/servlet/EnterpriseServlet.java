package com.maipae.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maipae.entity.EnterpriseEntity;
import com.maipae.entity.PersonEntity;
import com.maipae.service.EnterpriseService;
import com.maipae.service.PersonService;
import com.maipae.service.impl.EnterpriseServiceImpl;
import com.maipae.service.impl.PersonServiceImpl;

/**
 * Servlet implementation class EnterpriseServlet
 */
@WebServlet("/EnterpriseServlet")
public class EnterpriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterpriseServlet() {
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
		if ("add".equals(type)) {//注册单位
            this.addEnterprise(request, response);
        }
		else if ("addPerson".equals(type)) {//注册本单位人员
            this.addPreson(request, response);
        }
		
		String page = request.getParameter("page");
		if ("enterprise-index".equals(page)  || "admin-person-list".equals(page)) {//获取本单位人员列表数据
            this.enterprisePersonList(request, response);
        }
	}

	/**
     * Description:[各责任主体 - 获取本单位人员列表数据]
     */
	public void enterprisePersonList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);//获取会话对象
		int enterpriseid = (Integer)session.getAttribute("PERSON_EnterpriseID");//从会话中获取各责任主体ID
		
		String parameterName = "EnterpriseID";//参数名
    	int parameterValue = enterpriseid;//参数值
    	
    	System.out.println(parameterValue);
		
		PersonService personService = new PersonServiceImpl();
        
        List<PersonEntity> enterprisePersonList = personService.enterprisePersonList(parameterName, parameterValue);
        
        request.setAttribute("enterprisePersonList", enterprisePersonList);
        
    	try {
    		if (enterpriseid == 350001) {
    			request.getRequestDispatcher("admin-person-manage.jsp").forward(request, response);
    		}
    		else {
    			request.getRequestDispatcher("enterprise-index.jsp").forward(request, response);
    		}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
     * Description:[各责任主体 - 注册单位]
     */
    public void addEnterprise(HttpServletRequest request, HttpServletResponse response) {
    	String enterpriseName = request.getParameter("enterpriseName");
        String enterpriseStartTimeString = request.getParameter("enterpriseStartTime");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date enterpriseStartTime = null;
		try {
			enterpriseStartTime = sdf.parse(enterpriseStartTimeString);//字符串转日期
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String enterpriseCharacter = request.getParameter("enterpriseCharacter");
        String enterpriseAddress = request.getParameter("enterpriseAddress");
        int enterpriseNumber = Integer.valueOf(request.getParameter("enterpriseNumber"));
        String enterpriseWebSite = request.getParameter("enterpriseWebSite");
        String enterpriseOrganCode = request.getParameter("enterpriseOrganCode");
        String enterprisePerson = request.getParameter("enterprisePerson");
        String enterpriseEmail = request.getParameter("enterpriseEmail");
        String enterprisePersonTel = request.getParameter("enterprisePersonTel");
        String enterprisePassword = request.getParameter("enterprisePassword");
        String remarks = request.getParameter("remarks");
        
        EnterpriseService enterpriseService = new EnterpriseServiceImpl();
        
        EnterpriseEntity epe = new EnterpriseEntity();
        epe.setEnterpriseName(enterpriseName);
        epe.setEnterpriseStartTime(enterpriseStartTime);
        epe.setEnterpriseCharacter(enterpriseCharacter);
        epe.setEnterpriseAddress(enterpriseAddress);
        epe.setEnterpriseNumber(enterpriseNumber);
        epe.setEnterpriseWebSite(enterpriseWebSite);
        epe.setEnterpriseOrganCode(enterpriseOrganCode);
        epe.setEnterprisePerson(enterprisePerson);
        epe.setEnterpriseEmail(enterpriseEmail);
        epe.setEnterprisePersonTel(enterprisePersonTel);
        epe.setEnterprisePassword(enterprisePassword);
        epe.setEnterpriseState("未审核");//各责任主体注册单位默认设置，等待系统管理员审核通过
        epe.setRemarks(remarks);
        
        enterpriseService.addEnterprise(epe);
        
        try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Description:[各责任主体 - 注册本单位人员]
     */
    private void addPreson(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
    	int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
    	String personName = request.getParameter("personName");
    	String telNumber = request.getParameter("telNumber");
    	String email = request.getParameter("email");
    	String personIdentity = request.getParameter("personIdentity");
    	
    	PersonService personService = new PersonServiceImpl();
		
		PersonEntity pe = new PersonEntity();
		pe.setPersonName(personName);
		pe.setTelNumber(telNumber);
		pe.setEmail(email);
		pe.setPassword("123456");
		pe.setPersonIdentity(personIdentity);
		pe.setEnterpriseID(enterpriseID);
		
		personService.addPreson(pe);
		
		try {
			response.sendRedirect("EnterpriseServlet?page=enterprise-index");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
}
