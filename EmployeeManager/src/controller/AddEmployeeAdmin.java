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
import model.Employee;
import model.EmployeeManagerDbContext;
import model.Position;


@WebServlet("/AddEmployeeAdmin.html")
public class AddEmployeeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddEmployeeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listPosition", new Position().getList());
		request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		String position = request.getParameter("position");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean check = true;
		ResultSet res = new Account().getList();
		try {
			while(res.next()) {
				if(res.getString(1).equals(username))
				{
					check = false;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name.equals("") || gender.equals("") || country.equals("")|| address.equals("") || username.equals("") || password.equals("") || birth.equals(""))
		{
			request.setAttribute("type", 2);
			request.setAttribute("mes", "Thông tin không hợp lệ");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
		else if(check == false) {
			request.setAttribute("type", 2);
			request.setAttribute("mes", "Trùng tên đăng nhập");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("type", 1);
			request.setAttribute("mes", "Thêm nhân viên thành công");
			new EmployeeManagerDbContext().updateData("insert into account values('"+username+"','"+password+"',"+position+")");
			new EmployeeManagerDbContext().updateData("insert into emlpoyee values("+(new Employee().Count()+1)+",'"+name+"','"+birth+"','"+address+"','"+gender+"','"+country+"',"+position+",'"+username+"')");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
	}

}
