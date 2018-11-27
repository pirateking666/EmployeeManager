package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.EmployeeManagerDbContext;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.html")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int Position = 0;
		String username1 = "";
		ResultSet res = new Account().getList();
		try {
			while(res.next()) {
				if(res.getString(1).equals(username)&&res.getString(2).equals(password))
				{
					username1 = res.getString(1);
					Position = res.getInt(3);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Position == 0)
		{
			request.getRequestDispatcher("Fail.jsp").forward(request, response);
		}
		else if(Position == 1)
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username1);
			request.getRequestDispatcher("IndexAdmin.jsp").forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username1);
			request.getRequestDispatcher("IndexEmployee.jsp").forward(request, response);
		}
	}

}
