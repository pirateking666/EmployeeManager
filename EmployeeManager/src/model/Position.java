package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Position {

	EmployeeManagerDbContext db;
	public Position() {
		// TODO Auto-generated constructor stub
		db = new EmployeeManagerDbContext();
	}
	public ResultSet getList() {
		return db.getData("select * from positiion");
	}
	public int Count() {
		ResultSet res = getList();
		int count = 0;
		if(res != null) {
			try {
				while(res.next()) {
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public String getPositionNameByID(int ID) {
		ResultSet res = db.getData("select * from positiion where ID = "+ID);
		String name = "";
		try {
			while(res.next()) {
				name = res.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
