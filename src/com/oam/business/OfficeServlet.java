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
import com.oam.daoimpl.OfficeDAOImpl;
import com.oam.dto.OfficeDTO;
import com.oam.dtotransform.OfficeDTOTransform;
import com.oam.models.CityModel;
import com.oam.models.OfficeModel;

/**
 * Servlet implementation class OfficeServlet
 */
@WebServlet("/OfficeServlet")
public class OfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeServlet() {
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
			PrintWriter pw  = response.getWriter();
			
			if(request.getParameter("method").equals("addOffice"))
			{
				String officeName = request.getParameter("officeName");
				String cityName = request.getParameter("cityName");
				CityModel cityModel = new CityDAOImpl().getCityByName(cityName);
				OfficeModel officeModel = new OfficeModel();
				officeModel.setCityModel(cityModel);
				officeModel.setOfficeName(officeName);
				Integer result = new OfficeDAOImpl().addOffice(officeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(result);
				pw.write(gson.toJson(result));
			}
			else if(request.getParameter("method").equals("updateOffice"))
			{
				String officeName = request.getParameter("officeName");
				String cityName = request.getParameter("cityName");
				Integer officeId = Integer.parseInt(request.getParameter("officeId"));
				OfficeModel officeModel = new OfficeModel();
				CityModel cityModel = new CityDAOImpl().getCityByName(cityName);
				officeModel.setOfficeId(officeId);
				officeModel.setOfficeName(officeName);
				officeModel.setCityModel(cityModel);
				Integer result = new OfficeDAOImpl().updateOffice(officeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(result);
				pw.write(gson.toJson(result));
			}else if(request.getParameter("method").equals("getOfficeById"))
			{
				Integer officeId = Integer.parseInt(request.getParameter("officeId"));
				OfficeModel officeModel = new OfficeDAOImpl().getOfficeById(officeId);
				OfficeDTO officeDTO = OfficeDTOTransform.transform(officeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(officeDTO));
				pw.write(gson.toJson(officeDTO));
			}
			else if(request.getParameter("method").equals("deleteOffice"))
			{
				Integer officeId = Integer.parseInt(request.getParameter("officeId"));
				OfficeModel officeModel = new OfficeModel();
				officeModel.setOfficeId(officeId);
				Integer result = new OfficeDAOImpl().deleteOffice(officeModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(result));
				pw.write(gson.toJson(result));
			}
			else if(request.getParameter("method").equals("getAllOffices"))
			{
					List<OfficeModel> officeList = new OfficeDAOImpl().getAllOfficies(); 
					List<OfficeDTO> officeDTOList = new ArrayList<>();
					for(OfficeModel o : officeList)
					{
						OfficeDTO officeDTO = new OfficeDTO();
						officeDTO = OfficeDTOTransform.transform(o);
						officeDTOList.add(officeDTO);
					}
					Gson gson = new Gson();
					response.setContentType("application/json");
					System.out.println(gson.toJson(officeDTOList));
					pw.write(gson.toJson(officeDTOList));
			}
		}
	}

}
