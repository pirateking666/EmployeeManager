package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	EmployeeManagerDbContext db;
	public Account() {
		// TODO Auto-generated constructor stub
		db = new EmployeeManagerDbContext();
	}
	public ResultSet getList() {
		return db.getData("select * from account");
	}
	public int getPositionByUsername(String username) {
		ResultSet res = db.getData("select * from Account where username='"+username+"'");
		int Pos = 0;
		try {
			while(res.next()) {
				Pos = res.getInt(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Pos;
	}
}
