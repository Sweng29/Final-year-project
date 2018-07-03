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
import com.oam.daoimpl.ProvinceDAOImpl;
import com.oam.dto.ProvinceDTO;
import com.oam.dtotransform.ProvinceDTOTransform;
import com.oam.models.ProvinceModel;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
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
			
			if(request.getParameter("method").equals("getAllProvinces"))
			{
				List<ProvinceModel> provinceList = new ProvinceDAOImpl().getAllProvinces(); 
				List<ProvinceDTO> provinceDTOList = new ArrayList<>();
				for(ProvinceModel p : provinceList)
				{
					ProvinceDTO provinceDTO = new ProvinceDTO();
					provinceDTO = ProvinceDTOTransform.transform(p);
					provinceDTOList.add(provinceDTO);
				}
				Gson gson = new Gson();
				response.setContentType("application/json");
				System.out.println(gson.toJson(provinceDTOList));
				pw.write(gson.toJson(provinceDTOList));
			}
		}
	}

}
