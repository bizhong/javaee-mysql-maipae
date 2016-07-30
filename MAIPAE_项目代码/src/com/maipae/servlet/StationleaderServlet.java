package com.maipae.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maipae.entity.PersonEntity;
import com.maipae.entity.ProjectEntity;
import com.maipae.entity.ProjectSuperviseGroupEntity;
import com.maipae.service.PersonService;
import com.maipae.service.ProjectService;
import com.maipae.service.ProjectSuperviseGroupService;
import com.maipae.service.SuperviseGroupPersonService;
import com.maipae.service.impl.PersonServiceImpl;
import com.maipae.service.impl.ProjectServiceImpl;
import com.maipae.service.impl.ProjectSuperviseGroupServiceImpl;
import com.maipae.service.impl.SuperviseGroupPersonServiceImpl;

/**
 * Servlet implementation class StationleaderServlet
 */
@WebServlet("/StationleaderServlet")
public class StationleaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StationleaderServlet() {
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
		if ("stationleader-index".equals(page)) {//获取审核通过的建设项目工程列表数据
            this.statedProjectList(request, response);
        }
        
        String type = request.getParameter("type");
		if ("addPSGroup".equals(type)) {//分配监督组
            this.addPSGroup(request, response);
        }
		else if ("modifyPSGroup".equals(type)) {//修改监督组
            this.modifyPSGroup(request, response);
		}
        else if ("stationleaderAddPSG".equals(type)) {//处理分配监督组
        	this.stationleaderAddPSG(request, response);
        }
	}
	
	/**
     * Description:[站领导 - 处理分配监督组]
     */

	private void stationleaderAddPSG(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
        String personID = request.getParameter("personID");
        
        String[] jdypersonIDList = request.getParameterValues("personIDJDY");
        
        ProjectSuperviseGroupService psgService = new ProjectSuperviseGroupServiceImpl();
        SuperviseGroupPersonService sgpService = new SuperviseGroupPersonServiceImpl();
        
        psgService.addPSG(projectID);
        
        List<ProjectSuperviseGroupEntity> psgList = psgService.PSGList(projectID);

        int projectSuperviseGroupID = psgList.get(0).getProjectSuperviseGroupID();
        
        sgpService.addPSGperson(projectSuperviseGroupID, personID, "监督组长");

        if (jdypersonIDList != null && jdypersonIDList.length > 0) {
            for (int i= 0 ; i < jdypersonIDList.length; i++) {
                sgpService.addPSGperson(projectSuperviseGroupID, jdypersonIDList[i], "监督员");
            }
        }
        
        try {
			response.sendRedirect("StationleaderServlet?page=stationleader-index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
     * Description:[站领导 - 获取审核通过的建设项目工程列表数据，获取工程监督组列表数据]
     */
	public void statedProjectList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProjectService projectService = new ProjectServiceImpl();
		ProjectSuperviseGroupService psgService = new ProjectSuperviseGroupServiceImpl();
        
        List<ProjectEntity> statedProjectList = projectService.statedProjectList("通过");//获取审核通过的建设项目工程列表数据
        List<ProjectSuperviseGroupEntity> psgList = psgService.psgList();//获取工程监督组列表数据
        
        request.setAttribute("statedProjectList", statedProjectList);
        request.setAttribute("psgList", psgList);
        
        
        System.out.println(psgList.size());
        
        try {
    		request.getRequestDispatcher("stationleader-index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[站领导 - 分配监督组]
     */
	private void addPSGroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		
		ProjectService projectService = new ProjectServiceImpl();
		PersonService personService = new PersonServiceImpl();
        
        List<ProjectEntity> projectDetail = projectService.projectDetail(projectID);
        List<PersonEntity> jdzzList = personService.jdpList("监督组长");//获取监督组长列表数据
        List<PersonEntity> jdyList = personService.jdpList("监督员");//获取监督员列表数据
        
        request.setAttribute("projectDetail", projectDetail);
        request.setAttribute("projectID", projectID);
        request.setAttribute("jdzzList", jdzzList);
        request.setAttribute("jdyList", jdyList);
        
    	try {
    		
    		request.getRequestDispatcher("stationleader-add-projectsupervisegroup.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
     * Description:[站领导 - 修改监督组]
     */
	private void modifyPSGroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
