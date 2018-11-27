package model;

import java.sql.ResultSet;

public class DayOff {
	EmployeeManagerDbContext db;
	public DayOff() {
		// TODO Auto-generated constructor stub
		db = new EmployeeManagerDbContext();
	}
	public ResultSet getListByEmployeeID(int emp) {
		ResultSet res = db.getData("select * from DayOff where EmployeeID = "+emp);
		return res;
	}
	public ResultSet getListForAdmin() {
		return db.getData("select DO.ID, DO.DayOff, E.Name from DayOff as DO inner join Emlpoyee as E on E.ID = DO.EmployeeID where status = 1");
	}
}
