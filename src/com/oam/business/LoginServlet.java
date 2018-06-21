package com.oam.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		if(request.getParameter("action")!=null)
		{
			if(request.getParameter("action").equals("validateEmail"))
			{
				pw = response.getWriter();
				String email = request.getParameter("email").trim();
				response.setContentType("application/json");
				Integer result = validateEmail(request,response);
				if(result>0)
				{
					session.setAttribute("userEmail", email);
					pw.write(gson.toJson("true"));
				}else{
					pw.write(gson.toJson("false"));
				}
			}else if(request.getParameter("action").equals("validateEmailWithPassword"))
			{
				getLogin(request,response,session);
			}else if(request.getParameter("action").equals("registerUser"))
			{
				String email = request.getParameter("email").trim();
				String password = request.getParameter("password").trim();
				String confirmPassword = request.getParameter("confirmPassword").trim();
				Integer result = validateEmail(request,response);
				response.setContentType("application/json");
				if(result>0 || !password.equals(confirmPassword))
				{
					pw.write(gson.toJson("false"));
				}else{
					UserModel userModel = new UserModel();
					if(password.equals(confirmPassword))
					{
						userModel.setEmail(email);
						userModel.setPassword(password);
						userModel.setActive(1);
						result = new UserDAOImpl().addUser(userModel);
						if(result>0)
						{
							pw.write(gson.toJson("record added"));
						}else{
							pw.write(gson.toJson("error"));
						}
					}
					
				}
			}
		}
	}

	private void getLogin(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		try {
			pw = response.getWriter();
			response.setContentType("application/json");
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			Integer result = 0;
			UserModel userModel = new UserModel();
			userModel.setEmail(email);
			userModel.setPassword(password);
			UserModel resultModel = new UserModel();
			if(!email.equals("") && !password.equals(""))
			{
				resultModel = new UserDAOImpl().getLoggedIn(userModel);
			}
			if(resultModel!=null)
			{
				result = 1;
				session.setAttribute("confirmed", resultModel.getEmail());
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
