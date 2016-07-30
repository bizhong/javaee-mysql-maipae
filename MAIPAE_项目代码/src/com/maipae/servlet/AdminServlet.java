package com.maipae.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maipae.entity.EnterpriseEntity;
import com.maipae.entity.PersonEntity;
import com.maipae.service.EnterpriseService;
import com.maipae.service.PersonService;
import com.maipae.service.impl.EnterpriseServiceImpl;
import com.maipae.service.impl.PersonServiceImpl;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		
		String page = request.getParameter("page");
		if ("admin-index".equals(page) || "admin-review-enterprise-before".equals(page)) {//获取待审核的单位注册列表数据，或获取单个注册单位数据
            this.enterpriseToBeAuditedList(request, response);
        }
		if ("admin-review-enterprise".equals(page)) {//审核注册单位资料
            this.enterpriseAdminReview(request, response);
        }
	}
	
	/**
     * Description:[系统管理员 - 待审核的单位注册列表数据，或获取单个注册单位数据]
     */
    public void enterpriseToBeAuditedList(HttpServletRequest request, HttpServletResponse response) {
    	String parameterName = "";//参数名
    	String parameterValue = "";//参数值
    	String pageURL = "";//跳转页面URL
    	String enterpriseID = request.getParameter("enterpriseID");
    	System.out.println(enterpriseID);
    	if (enterpriseID != null) {//获取单个注册单位数据
    		parameterName = "EnterpriseID";
    		parameterValue = enterpriseID;
    		pageURL = "admin-review-enterprise.jsp";
    	}
    	else {//获取待审核的单位注册列表数据
    		parameterName = "EnterpriseState";
    		parameterValue = "未审核";
    		pageURL = "admin-index.jsp";
    	}
    	
    	EnterpriseService enterpriseService = new EnterpriseServiceImpl();
        
        List<EnterpriseEntity> enterpriseToBeAuditedList = enterpriseService.enterpriseToBeAuditedList(parameterName, parameterValue);
        
        request.setAttribute("enterpriseToBeAuditedList", enterpriseToBeAuditedList);
        
    	try {
			request.getRequestDispatcher(pageURL).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Description:[系统管理员 - 审核注册单位资料]
     */
    public void enterpriseAdminReview(HttpServletRequest request, HttpServletResponse response) {
    	String enterpriseID = request.getParameter("enterpriseID");
    	String enterpriseState = request.getParameter("enterpriseState");
    	System.out.println(enterpriseID);
    	System.out.println(enterpriseState);
    	if ("通过".equals(enterpriseState)) {
    		this.updateEnterprise(request, response);
    		this.addPreson(request, response);
    	}
    	else if ("不通过".equals(enterpriseState)) {
    		this.deleteEnterprise(request, response);
    	}
    	
    	try {
			response.sendRedirect("AdminServlet?page=admin-index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * Description:[系统管理员 - 更新注册单位的审核状态]
     */
    private void updateEnterprise(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
    	int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
    	String enterpriseState = request.getParameter("enterpriseState");
    	
		EnterpriseService enterpriseService = new EnterpriseServiceImpl();
		
		EnterpriseEntity epe = new EnterpriseEntity();
		epe.setEnterpriseID(enterpriseID);
		epe.setEnterpriseState(enterpriseState);
		
		enterpriseService.updateEnterprise(epe);
	}
    
    /**
     * Description:[系统管理员 - 审核通过的注册单位增加单位联系人到人员信息表]
     */
    private void addPreson(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
    	int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
    	String enterprisePerson = request.getParameter("enterprisePerson");
    	String enterprisePassword = request.getParameter("enterprisePassword");
    	String enterpriseEmail = request.getParameter("enterpriseEmail");
    	String enterprisePersonTel = request.getParameter("enterprisePersonTel");
    	
    	PersonService personService = new PersonServiceImpl();
		
		PersonEntity pe = new PersonEntity();
		pe.setPersonName(enterprisePerson);
		pe.setTelNumber(enterprisePersonTel);
		pe.setEmail(enterpriseEmail);
		pe.setPassword(enterprisePassword);
		pe.setPersonIdentity("各责任主体");
		pe.setEnterpriseID(enterpriseID);
		
		personService.addPreson(pe);
	}
    
    /**
     * Description:[系统管理员 - 删除审核不通过的注册单位资料]
     */
	private void deleteEnterprise(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
		
		EnterpriseService enterpriseService = new EnterpriseServiceImpl();
		
		enterpriseService.deleteEnterprise(enterpriseID);
	}

}
