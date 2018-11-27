package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DayOff;
import model.EmployeeManagerDbContext;


@WebServlet("/AcceptDayOffAdmin.html")
public class AcceptDayOffAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AcceptDayOffAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet res = new DayOff().getListForAdmin();
		request.setAttribute("listoffer", res);
		request.getRequestDispatcher("AcceptOffer.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("ID");
		String action = request.getParameter("action");
		if(action.equals("1")) {
			new EmployeeManagerDbContext().updateData("update DayOff set status = 2 where ID = "+ID);
			request.setAttribute("type", 1);
			request.setAttribute("mes", "Duyệt nghỉ thành công");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
		else
		{
			new EmployeeManagerDbContext().updateData("update DayOff set status = 3 where ID = "+ID);
			request.setAttribute("type", 1);
			request.setAttribute("mes", "Hủy đề xuất nghỉ thành công");
			request.getRequestDispatcher("MessageAdmin.jsp").forward(request, response);
		}
	}

}
