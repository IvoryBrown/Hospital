package application.setting.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import application.setting.file.DBFileWriter;

public class DataBaseLocal {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	static Connection conn = null;
	static Statement createStatement = null;

	public static Connection getConnection() {
		DBFileWriter.setDataBaseOutput();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection("jdbc:mysql://" + DBFileWriter.getDBOutput()
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					DBFileWriter.getNameOutput(), DBFileWriter.getPasswordOutput());
		} catch (SQLException ex) {
			System.out.println("Valami baj van a connection." + ex);
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
		if (conn != null) {
			try {
				createStatement = conn.createStatement();
				return conn;
			} catch (SQLException ex) {
				System.out.println("Valami baj van van a createStatament l�trehoz�sakor.");
				return null;
			}
		}
		return null;
	}

}
