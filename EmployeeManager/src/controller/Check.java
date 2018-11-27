package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeManagerDbContext;
import model.TimeKeeping;

@WebServlet("/Check.html")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count1=0;
		LocalDateTime date = java.time.LocalDateTime.now();
		ResultSet resu = new TimeKeeping().getListToDayForEmp(new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username")),date.getDayOfMonth());
		request.setAttribute("listCheck", resu);
		ResultSet res = new TimeKeeping().getListByEmployeeID(new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username")), 1);
		try {
			while(res.next())
			{
				count1++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count1 == 0)
		{
			request.setAttribute("check", 1);
			request.getRequestDispatcher("Check.jsp").forward(request, response);
		}
		else{
			request.setAttribute("check", 2);
			request.getRequestDispatcher("Check.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDateTime date = java.time.LocalDateTime.now();
		int CheckLate = 0,count1=0,count2=0;
		ResultSet res = new TimeKeeping().getListByEmployeeID(new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username")), 1);	
		try {
			while(res.next())
			{
				count1++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count1 == 0)
		{
			String day = date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth()+" "+date.getHour()+":"+date.getMinute();
			if(date.getHour()>7)
			{
				CheckLate = 1;
			}
			new EmployeeManagerDbContext().updateData("insert into TimeKeeping(TimeIn,Late,EmployeeID,status) values('"+day+"',"+CheckLate+","+new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username"))+",1)");
			request.setAttribute("check", 2);
			ResultSet resu = new TimeKeeping().getListToDayForEmp(new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username")),date.getDayOfMonth());
			request.setAttribute("listCheck", resu);
			request.getRequestDispatcher("Check.jsp").forward(request, response);
		}
		else {
			String day = date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth()+" "+date.getHour()+":"+date.getMinute();
			new EmployeeManagerDbContext().updateData("update TimeKeeping set TimeOut = '"+day+"', status = 2 where status = 1 and EmployeeID = "+new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username"))+" and DAY(TimeIn) = "+date.getDayOfMonth());
			request.setAttribute("check", 1);
			ResultSet resu = new TimeKeeping().getListToDayForEmp(new Employee().getEmployeeIDByUsername((String)request.getSession().getAttribute("username")),date.getDayOfMonth());
			request.setAttribute("listCheck", resu);
			request.getRequestDispatcher("Check.jsp").forward(request, response);
		}
	}

}
