package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Salary {

	EmployeeManagerDbContext db;
	public Salary() {
		// TODO Auto-generated constructor stub
		db = new EmployeeManagerDbContext();
	}
	public double getSalaryByPosition(int positionID) {
		ResultSet res = db.getData("select * from salaryforpositionbyday where ID = "+positionID);
		double salary=0;
		try {
			while(res.next()) {
				salary = res.getDouble(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salary;
	}

}
