package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeKeeping {
	EmployeeManagerDbContext db;
	public TimeKeeping() {
		// TODO Auto-generated constructor stub
		db = new EmployeeManagerDbContext();
	}
	public ResultSet getListByEmployeeID(int emp, int status) {
		return db.getData("select * from TimeKeeping where EmployeeID = "+emp+" and status = "+status);
	}
	public ResultSet getList() {
		return db.getData("select * from TimeKeeping");
	}
	public ResultSet getListToDayForEmp(int emp, int day) {
		return db.getData("select * from TimeKeeping where EmployeeID = "+emp+" and DAY(TimeIn) = "+day);
	}
	public int CountDayForEmp(int EmpID, int month) {
		ResultSet res = db.getData("select COUNT(*) from TimeKeeping where EmployeeID = "+EmpID+" and MONTH(TimeIn) = "+month);
		int count = 0;
		try {
			while(res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
