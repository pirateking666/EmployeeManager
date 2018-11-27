package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DayOff;
import model.Employee;
import model.EmployeeManagerDbContext;


@WebServlet("/OfferDayOff.html")
public class OfferDayOff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OfferDayOff() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listOffer",new DayOff().getListByEmployeeID(new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username"))));
		request.getRequestDispatcher("OfferDayOff.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String day = request.getParameter("day");
		if(day.equals(""))
		{
			request.setAttribute("mes", "Thông tin không hợp lệ");
			request.setAttribute("type", 2);
			request.getRequestDispatcher("MessageEmployee.jsp").forward(request, response);
		}
		else
		{
			String[] splitDay = day.split("-");
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String[] splitDayNow = date.toString().split("-");
			if(Integer.parseInt(splitDayNow[2]) < Integer.parseInt(splitDay[2]) && Integer.parseInt(splitDayNow[1]) <= Integer.parseInt(splitDay[1]) && Integer.parseInt(splitDayNow[0]) <= Integer.parseInt(splitDay[0]))
			{
				new EmployeeManagerDbContext().updateData("insert into dayoff(DayOff,EmployeeID,status) values('"+day+"',"+new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username"))+",1)");
				request.setAttribute("mes", "Đề xuất ngày nghỉ thành công");
				request.setAttribute("type", 1);
				request.getRequestDispatcher("MessageEmployee.jsp").forward(request, response);				
			}
			else
			{
				request.setAttribute("mes", "Không thể chọn nghỉ ngày hôm nay hoặc cũ hơn");
				request.setAttribute("type", 2);
				request.getRequestDispatcher("MessageEmployee.jsp").forward(request, response);
			}
		}
	}

}
