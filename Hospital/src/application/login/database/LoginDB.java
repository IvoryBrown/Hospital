package application.login.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.login.pojo.Login;
import application.setting.database.DataBaseLocal;

public class LoginDB {

	// login database check
	public ArrayList<Login> getAllUserLogin(String name) {
		String sql = "SELECT * FROM `user` "
//				+ "WHERE username = " + name
				;
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Login> extruder = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			extruder = new ArrayList<>();

			while (rs.next()) {
				Login actualExtruder = new Login(rs.getString("username"), rs.getString("password"));
				extruder.add(actualExtruder);
			}
		} catch (SQLException ex) {
			System.out.println("Valami baj van a userek kiolvasásakor");
			System.out.println("" + ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (createStatement != null) {
					createStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Valami baj van a userek kiolvasásakor");
				System.out.println("" + e);
			}
		}
		return extruder;
	}
}
