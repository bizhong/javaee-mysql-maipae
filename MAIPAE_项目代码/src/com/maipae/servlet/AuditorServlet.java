package com.maipae.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maipae.entity.ProjectEntity;
import com.maipae.service.ProjectService;
import com.maipae.service.impl.ProjectServiceImpl;

/**
 * Servlet implementation class AuditorServlet
 */
@WebServlet("/AuditorServlet")
public class AuditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditorServlet() {
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
		if ("auditor-index".equals(page)) {//获取建设项目工程列表数据
            this.projectList(request, response);
        }
		
		String type = request.getParameter("type");
		if ("reviewProjectBefore".equals(type)) {//审核已报监前先获取建设项目工程信息数据
            this.projectDetail(request, response);
        }
		else if ("reviewProject".equals(type)) {//报监审查
            this.reviewProject(request, response);
        }
	}

	/**
     * Description:[报监审核员 - 获取建设项目工程列表数据]
     */
	public void projectList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProjectService projectService = new ProjectServiceImpl();
        
        List<ProjectEntity> projectList = projectService.projectList();
        
        request.setAttribute("projectList", projectList);
        
    	try {
			request.getRequestDispatcher("auditor-index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[报监审核员 - 审核已报监前先获取建设项目工程信息数据]
     */
	public void projectDetail(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		
		ProjectService projectService = new ProjectServiceImpl();
        
        List<ProjectEntity> projectDetail = projectService.projectDetail(projectID);
        
        request.setAttribute("projectDetail", projectDetail);
        request.setAttribute("projectID", projectID);
        
    	try {
    		
    		request.getRequestDispatcher("auditor-audit-project.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[报监审核员 - 报监审查]
     */
	public void reviewProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		String state = request.getParameter("state");
		
		ProjectService projectService = new ProjectServiceImpl();
		
		projectService.reviewProject(projectID,state);
        
        try {
			response.sendRedirect("AuditorServlet?page=auditor-index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
