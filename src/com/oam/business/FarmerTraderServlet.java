package com.oam.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oam.daoimpl.FarmerTraderDAOImpl;
import com.oam.daoimpl.UserDAOImpl;
import com.oam.models.FarmerTraderModel;
import com.oam.models.UserModel;

/**
 * Servlet implementation class FarmerTraderServlet
 */
@WebServlet("/FarmerTraderServlet")
public class FarmerTraderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FarmerTraderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("action")!=null)
		{
			if(request.getParameter("action").equals("getAllFarmerTraders"))
			{
				
			}
			else if(request.getParameter("action").equals("addFarmerTrader"))
			{
				addFarmerTrader(request,response);
			}
		}
	}

	private void addFarmerTrader(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		String userName = request.getParameter("userName").trim();
		String cnic = request.getParameter("cnic").trim();
		String province = request.getParameter("province").trim();
		String city = request.getParameter("city").trim();
		String phoneNumber = request.getParameter("phoneNumber").trim();
		String mobileNumber = request.getParameter("mobileNumber").trim();
		String address = request.getParameter("address").trim();
		System.out.println("Adding record : "+userName+" "+cnic+" "+province+" "+city+" "+phoneNumber+" "+mobileNumber+" "+address);
		FarmerTraderModel farmerTraderModel = new FarmerTraderModel();
		farmerTraderModel.setAddress(address);
		farmerTraderModel.setActive(1);
		farmerTraderModel.setCnicNumber(cnic);
//		farmerTraderModel;
		Integer result = new FarmerTraderDAOImpl().addFarmerTrader(farmerTraderModel);
		response.setContentType("application/json");
		Gson gson = new Gson();
		if(result>0)
		{
			pw.write(gson.toJson("false"));
		}else{
			
		}
		
	}
}
