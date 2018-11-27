package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeManagerDbContext;
import model.Position;


@WebServlet("/AddEmployeeTypeAdmin.html")
public class AddEmployeeType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddEmployeeType() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("AddEmployeeType.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employeeType = request.getParameter("employeetype");
		boolean check = true;
		ResultSet res = new Position().getList();
		try {
			while(res.next()) {
				if(res.getString(2).equals(employeeType)) {
					check = false;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check == true) {
			request.setAttribute("mes", "Thêm loại nhân viên mới thành công");
			request.setAttribute("type", 1);
			new EmployeeManagerDbContext().updateData("insert into positiion values("+(new Position().Count()+1)+",'"+employeeType+"')");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("mes", "Loại nhân viên này đã tồn tại");
			request.setAttribute("type", 2);
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
	}

}
