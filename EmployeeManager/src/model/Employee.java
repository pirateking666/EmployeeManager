package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

	EmployeeManagerDbContext db;
	public Employee() {
		// TODO Auto-generated constructor stub
		db = new EmployeeManagerDbContext();
	}
	public int Count() {
		ResultSet res = db.getData("select * from emlpoyee");
		int count = 0;
		if(res != null) {
			try {
				while(res.next())
				{
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public int getEmployeeIDByUsername(String username) {
		ResultSet res = getList();
		try {
			while(res.next()) {
				if(res.getString(8).equals(username))
				{
					return res.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public ResultSet getList() {
		return db.getData("select * from emlpoyee");
	}
	public String getNameByID(int ID) {
		ResultSet res = db.getData("select * from emlpoyee where ID = "+ID);
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
