package com.oam.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oam.daoimpl.UserDAOImpl;
import com.oam.models.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PrintWriter pw = null;
	Gson gson = new Gson();
    public LoginServlet() {
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
		if(request.getParameter("action")!=null)
		{
			if(request.getParameter("action").equals("validateEmail"))
			{
				pw = response.getWriter();
				response.setContentType("application/json");
				Integer result = validateEmail(request,response);
				if(result>0)
				{
					pw.write(gson.toJson("true"));
				}else{
					pw.write(gson.toJson("false"));
				}
			}else if(request.getParameter("action").equals("validateEmailWithPassword"))
			{
				getLogin(request,response);
			}else if(request.getParameter("action").equals("registerUser"))
			{
				String email = request.getParameter("email").trim();
				String password = request.getParameter("password").trim();
				String confirmPassword = request.getParameter("confirmPassword").trim();
				//Check if email already exists
				System.out.println("Checking email.");
				Integer result = validateEmail(request,response);
				if(result>0 || !password.equals(confirmPassword))
				{
					pw.write(gson.toJson("false"));
				}else{
					UserModel userModel = new UserModel();
					System.out.println("Adding record.");
					if(password.equals(confirmPassword))
					{
						userModel.setEmail(email);
						userModel.setPassword(password);
						userModel.setActive(1);
						result = new UserDAOImpl().addUser(userModel);
						if(result>0)
						{
							System.out.println("Record added.");
							pw.write(gson.toJson("true"));
						}else{
							System.out.println("Could not add record.");
							pw.write(gson.toJson("false"));
						}
					}
					
				}
			}
		}
	}

	private void getLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			pw = response.getWriter();
			response.setContentType("application/json");
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			Integer result = 0;
			UserModel userModel = new UserModel();
			userModel.setEmail(email);
			userModel.setPassword(password);
			if(!email.equals("") && !password.equals(""))
			{
				userModel = new UserDAOImpl().getLoggedIn(userModel);
			}
			if(userModel!=null)
			{
				System.out.println(gson.toJson(userModel));
				pw.write(gson.toJson(userModel));
			}else{
				pw.write(gson.toJson("false"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Integer validateEmail(HttpServletRequest request, HttpServletResponse response) {
		Integer result = 0;
		try {
			pw = response.getWriter();
			String email = request.getParameter("email").trim();
			if(!email.equals(""))
			{
				result = new UserDAOImpl().validateEmail(email);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
