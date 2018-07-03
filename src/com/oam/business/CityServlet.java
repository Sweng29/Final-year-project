package com.oam.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oam.daoimpl.CityDAOImpl;
import com.oam.daoimpl.ProvinceDAOImpl;
import com.oam.dto.CityDTO;
import com.oam.dto.OfficeDTO;
import com.oam.dtotransform.CityDTOTransform;
import com.oam.dtotransform.OfficeDTOTransform;
import com.oam.models.CityModel;
import com.oam.models.OfficeModel;
import com.oam.models.ProvinceModel;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
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
			
			if(request.getParameter("method").equals("addCity"))
			{
				String cityName = request.getParameter("cityName");
				String provinceName = request.getParameter("province");
				
				ProvinceModel provinceModel = new ProvinceDAOImpl().getProvinceByName(provinceName);
				
				CityModel cityModel = new CityModel();
				cityModel.setCityName(cityName);
				cityModel.setProvinceModel(provinceModel);
				Integer result = new CityDAOImpl().addCity(cityModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(result);
				pw.write(gson.toJson(result));
			}
			else if(request.getParameter("method").equals("updateCity"))
			{
				String cityName = request.getParameter("cityName");
				String provinceName = request.getParameter("province");
				Integer cityId = Integer.parseInt(request.getParameter("cityId"));
				ProvinceModel provinceModel = new ProvinceDAOImpl().getProvinceByName(provinceName);
				
				CityModel cityModel = new CityModel();
				cityModel.setCityName(cityName);
				cityModel.setCityId(cityId);
				cityModel.setProvinceModel(provinceModel);
				Integer result = new CityDAOImpl().updateCity(cityModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(result);
				pw.write(gson.toJson(result));
			}else if(request.getParameter("method").equals("getCityById"))
			{
				Integer cityId = Integer.parseInt(request.getParameter("cityId"));
				CityModel cityModel = new CityDAOImpl().getCityById(cityId);
				CityDTO cityDTO = CityDTOTransform.transform(cityModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(cityDTO));
				pw.write(gson.toJson(cityDTO));
			}
			else if(request.getParameter("method").equals("deleteCity"))
			{
				Integer cityId = Integer.parseInt(request.getParameter("cityId"));
				CityModel cityModel = new CityModel();
				cityModel.setCityId(cityId);
				Integer result = new CityDAOImpl().deleteCity(cityModel);
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(result));
				pw.write(gson.toJson(result));
			}
			else if(request.getParameter("method").equals("getAllCities"))
			{
					List<CityModel> citiesList = new CityDAOImpl().getAllCities(); 
					List<CityDTO> cityDTOList = new ArrayList<>();
					for(CityModel c : citiesList)
					{
						CityDTO cityDTO = new CityDTO();
						cityDTO = CityDTOTransform.transform(c);
						cityDTOList.add(cityDTO);
					}
					Gson gson = new Gson();
					response.setContentType("application/json");
					System.out.println(gson.toJson(cityDTOList));
					pw.write(gson.toJson(cityDTOList));
			}else if(request.getParameter("method").equals("getAllCitiesByProvince"))
			{
				String provinceName = request.getParameter("provinceName");
				ProvinceModel provinceModel = new ProvinceDAOImpl().getProvinceByName(provinceName);
				System.out.println(provinceModel.getProvinceId());
				CityModel cityModel = new CityModel();
				cityModel.setProvinceModel(provinceModel);
				Set<CityModel> cities = new HashSet<CityModel>();
				cityModel.setProvinceModel(provinceModel);
				for(CityModel c : provinceModel.getCities())
				{
					cities.add(c);
				}
				Set<CityDTO> citiesDTO  = new HashSet<CityDTO>();
				for(CityModel c  : cities)
				{
					CityDTO cityDTO = CityDTOTransform.transform(c);
					citiesDTO.add(cityDTO);
				}
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(citiesDTO));
				pw.write(gson.toJson(citiesDTO));
			}else if(request.getParameter("method").equals("getOfficeByCity"))
			{
				String cityName = request.getParameter("cityName");
				CityModel cityModel = new CityDAOImpl().getCityByName(cityName);
				Set<OfficeDTO> officeList = new HashSet<OfficeDTO>();
				
				for(OfficeModel o : cityModel.getOfficesList())
				{
					OfficeDTO officeDTO = OfficeDTOTransform.transform(o);
					officeList.add(officeDTO);
				}
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(officeList));
				pw.write(gson.toJson(officeList));
			}
		}		
	}
}
