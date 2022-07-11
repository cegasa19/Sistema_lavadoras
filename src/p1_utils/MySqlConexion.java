package p1_utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {

	public static Connection getConexion() {
		Connection cn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// crear variables
			String url, user, pass;
			url = "jdbc:mysql://localhost/sislav_pp?serverTimezone=UTC";
			user = "root";
			pass = "mysql";
			// crear cn
			cn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cn;
	}
}
