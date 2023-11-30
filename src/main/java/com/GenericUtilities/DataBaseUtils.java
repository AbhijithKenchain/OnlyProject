package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * This class for database generic methods
 */
public class DataBaseUtils {
	Connection con = null;

	public void dataBaseConnection() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// connect to database
		con = DriverManager.getConnection(IPathConstants1.DBURL, IPathConstants1.DB_UserName,
				IPathConstants1.DB_Password);

	}

	public String executeSelectQuery(int colData, String ExpData, String query) throws SQLException {
		Statement state = con.createStatement();

		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String actual = result.getString(colData);
			if (actual.equalsIgnoreCase(ExpData)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("project created successfully");
			return ExpData;
		} else {
			System.out.println("project not created");
		}
		return "";

	}

	public int executeUpdate(String query, int colData) throws SQLException {
		Statement s = con.createStatement();

		int result = s.executeUpdate(query);
		if (result > 0) {

			System.out.println("project or data updated successfully");
			return result;
		} else {
			System.out.println("project or data not updated");
		}

		return result;

	}

	public void disConnect() throws SQLException {
		con.close();
	}
}
