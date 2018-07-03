package com.oam.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oam.daoimpl.CityDAOImpl;
import com.oam.daoimpl.EmployeeDAOImpl;
import com.oam.daoimpl.OfficeDAOImpl;
import com.oam.dto.CityDTO;
import com.oam.dto.EmployeeDTO;
import com.oam.dtotransform.CityDTOTransform;
import com.oam.dtotransform.EmployeeDTOTransform;
import com.oam.models.CityModel;
import com.oam.models.EmployeeModel;
import com.oam.models.OfficeModel;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("method")!=null)
		{
			PrintWriter pw = response.getWriter();
			if(request.getParameter("method").equals("addEmployee"))
			{
				String employeeName = request.getParameter("employeeName");
				String contact = request.getParameter("contact");
				String address = request.getParameter("address");
				String officeName = request.getParameter("officeName");
				String cityName = request.getParameter("cityName");
				CityModel cityModel = new CityDAOImpl().getCityByName(cityName);
				OfficeModel officeModel = new OfficeDAOImpl().getOfficeByName(officeName);
				EmployeeModel employeeModel = new EmployeeModel();
				employeeModel.setActive(1);
				employeeModel.setAddress(address);
				employeeModel.setCityModel(cityModel);
				employeeModel.setContact(contact);
				employeeModel.setEmployeeName(employeeName);
				employeeModel.setOfficeModel(officeModel);
				employeeModel.setVerificationId(1);
				Integer result = new EmployeeDAOImpl().addEmployee(employeeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(result);
				pw.write(gson.toJson(result));
				
			}else if(request.getParameter("method").equals("updateEmployee"))
			{
				String employeeName = request.getParameter("employeeName");
				String contact = request.getParameter("contact");
				String address = request.getParameter("address");
				String officeName = request.getParameter("officeName");
				String cityName = request.getParameter("cityName");
				Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
				CityModel cityModel = new CityDAOImpl().getCityByName(cityName);
				OfficeModel officeModel = new OfficeDAOImpl().getOfficeByName(officeName);
				EmployeeModel employeeModel = new EmployeeModel();
				employeeModel.setActive(1);
				employeeModel.setAddress(address);
				employeeModel.setCityModel(cityModel);
				employeeModel.setContact(contact);
				employeeModel.setEmployeeName(employeeName);
				employeeModel.setOfficeModel(officeModel);
				employeeModel.setVerificationId(1);
				employeeModel.setEmployeeId(employeeId);
				
				Integer result = new EmployeeDAOImpl().updateEmployee(employeeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(result);
				pw.write(gson.toJson(result));
				
			}else if(request.getParameter("method").equals("deleteEmployee"))
			{
				Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
				EmployeeModel employeeModel = new EmployeeModel();
				employeeModel.setEmployeeId(employeeId);
				Integer result = new EmployeeDAOImpl().deleteEmployee(employeeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(result));
				pw.write(gson.toJson(result));
			}
			else if(request.getParameter("method").equals("getEmployeeById"))
			{
				Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
				EmployeeModel employeeModel = new EmployeeDAOImpl().getEmployeeById(employeeId);
				EmployeeDTO employeeDTO = EmployeeDTOTransform.transform(employeeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(employeeDTO));
				pw.write(gson.toJson(employeeDTO));
			}
			else if(request.getParameter("method").equals("getAllEmployees"))
			{
				List<EmployeeModel> employeesList = new EmployeeDAOImpl().getAllEmployees(); 
				List<EmployeeDTO> employeesDTOList = new ArrayList<>();
				for(EmployeeModel e : employeesList)
				{
					EmployeeDTO employeeDTO = new EmployeeDTO();
					employeeDTO = EmployeeDTOTransform.transform(e);
					employeesDTOList.add(employeeDTO);
				}
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(employeesDTOList));
				pw.write(gson.toJson(employeesDTOList));
			}
		}
	}

}
