package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.EmployeeManagerDbContext;

@WebServlet("/ChangePassAdmin.html")
public class ChangePassAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangePassAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("ChangePassAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oldpass = request.getParameter("oldpassword");
		String newpass = request.getParameter("newpassword");
		String username = (String)request.getSession().getAttribute("username");
		EmployeeManagerDbContext db = new EmployeeManagerDbContext();
		ResultSet res = new Account().getList();
		boolean check = false;
		try {
			while(res.next())
			{
				if(res.getString(2).equals(oldpass))
				{
					check = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(oldpass.equals("") || newpass.equals("")) {
			request.setAttribute("type", 2);
			request.setAttribute("mes", "Thông tin không hợp lệ");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
		else
		{
			if(check == true)
			{
				db.updateData("update account set password = '"+newpass+"' where username = '"+username+"'");
				request.setAttribute("type", 1);
				request.setAttribute("mes", "Đổi mật khẩu thành công");
				request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("type", 2);
				request.setAttribute("mes", "Sai mật khẩu cũ");
				request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
			}
		}
	}

}
