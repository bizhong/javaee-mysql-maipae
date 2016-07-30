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

import com.maipae.entity.ProjectEntity;
import com.maipae.service.ProjectService;
import com.maipae.service.impl.ProjectServiceImpl;

/**
 * Servlet implementation class ProjectleaderServlet
 */
@WebServlet("/ProjectleaderServlet")
public class ProjectleaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectleaderServlet() {
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
		if ("search-results".equals(type)) {//查询建设项目工程
            this.searchProjectList(request, response);
        }
		else if ("addProject".equals(type)) {//新增建设项目工程
            this.addProject(request, response);
        }
		else if ("projectDetail".equals(type)) {//建设项目工程详情
            this.projectDetail(request, response);
        }
		else if ("modifyProject".equals(type)) {//修改建设项目工程
            this.modifyProject(request, response);
        }
		else if ("changeMState".equals(type)) {//提交建设项目工程
            this.changeMState(request, response);
        }
		else if ("deleteProject".equals(type)) {//删除建设项目工程
            this.deleteProject(request, response);
        }
		
	}

	/**
     * Description:[建设项目负责人 - 查询建设项目工程]
     */
	public void searchProjectList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String s = request.getParameter("s");
		
		System.out.println(s);
		
		ProjectService projectService = new ProjectServiceImpl();
        
        List<ProjectEntity> searchProjectList = projectService.searchProjectList(s);
        
        request.setAttribute("searchProjectList", searchProjectList);
        request.setAttribute("s", s);
        
        try {
    		request.getRequestDispatcher("projectleader-search-results.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[建设项目负责人 - 新增建设项目工程]
     */
	private void addProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String projectName = request.getParameter("projectName");
		String projectFiles = request.getParameter("projectFiles");
		int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
		String projectStartTimeString = request.getParameter("projectStartTime");
        String projectEndTimeString = request.getParameter("projectEndTime");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date projectStartTime = null;
        Date projectEndTime = null;
		try {
			projectStartTime = sdf.parse(projectStartTimeString);//字符串转日期
			projectEndTime = sdf.parse(projectEndTimeString);//字符串转日期
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int personID = Integer.valueOf(request.getParameter("personID"));
        String belongStations = request.getParameter("belongStations");
        String stationName = request.getParameter("stationName");
        String remarks = request.getParameter("remarks");
        
        ProjectService projectService = new ProjectServiceImpl();
        
        ProjectEntity pe = new ProjectEntity();
        pe.setProjectName(projectName);
        pe.setProjectFiles(projectFiles);
        pe.setEnterpriseID(enterpriseID);
        pe.setState("未审核");
        pe.setProjectStartTime(projectStartTime);
        pe.setProjectEndTime(projectEndTime);
        pe.setPersonID(personID);
        pe.setBelongStations(belongStations);
        pe.setStationName(stationName);
        pe.setRemarks(remarks);
        pe.setMonitorState("未报监");
        
        projectService.addProject(pe);
        
        try {
			response.sendRedirect("projectleader-index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[建设项目负责人 - 建设项目工程详情]
     */
	private void projectDetail(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		
		ProjectService projectService = new ProjectServiceImpl();
        
        List<ProjectEntity> projectDetail = projectService.projectDetail(projectID);
        
        request.setAttribute("projectDetail", projectDetail);
        request.setAttribute("projectID", projectID);
        
    	try {
    		
    		request.getRequestDispatcher("projectleader-modify-project.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[建设项目负责人 - 修改建设项目工程]
     */
	public void modifyProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		String projectName = request.getParameter("projectName");
		String projectFiles = request.getParameter("projectFiles");
		int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
		String projectStartTimeString = request.getParameter("projectStartTime");
        String projectEndTimeString = request.getParameter("projectEndTime");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date projectStartTime = null;
        Date projectEndTime = null;
		try {
			projectStartTime = sdf.parse(projectStartTimeString);//字符串转日期
			projectEndTime = sdf.parse(projectEndTimeString);//字符串转日期
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int personID = Integer.valueOf(request.getParameter("personID"));
        String stationName = request.getParameter("stationName");
        String remarks = request.getParameter("remarks");
        String monitorState = request.getParameter("monitorState");
        
        ProjectService projectService = new ProjectServiceImpl();
        
        ProjectEntity pe = new ProjectEntity();
        pe.setProjectID(projectID);
        pe.setProjectName(projectName);
        pe.setProjectFiles(projectFiles);
        pe.setEnterpriseID(enterpriseID);
        pe.setProjectStartTime(projectStartTime);
        pe.setProjectEndTime(projectEndTime);
        pe.setPersonID(personID);
        pe.setBelongStations("四川省成都市");
        pe.setStationName(stationName);
        pe.setRemarks(remarks);
        pe.setMonitorState(monitorState);
        
        projectService.modifyProject(pe);
        
        try {
			response.sendRedirect("projectleader-index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[建设项目负责人 - 提交建设项目工程]
     */
	private void changeMState(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		
		ProjectService projectService = new ProjectServiceImpl();
		
		projectService.changeMState(projectID);
        
        try {
			response.sendRedirect("projectleader-index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[建设项目负责人 - 删除建设项目工程]
     */
	public void deleteProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		String s = request.getParameter("s");
		
		ProjectService projectService = new ProjectServiceImpl();
		
		projectService.deleteProject(projectID);
        
        try {
			response.sendRedirect("ProjectleaderServlet?type=search-results&s=" + s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}