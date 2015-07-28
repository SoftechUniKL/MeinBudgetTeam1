package GUI;

import java.sql.Connection;
import java.sql.DriverManager;

public class BPDatenbank {

	static Connection conn = null;

	public static Connection dbCon() {
		try {
			Class.forName("org.sqlite.JDBC");
			String db = "jdbc:sqlite:src/BudgetPlan/BudgetÜbersicht";
			conn = DriverManager.getConnection(db);
			System.out.println("---> Verbindung zur Budget-Datenbank OK!");
			return conn;
		} catch (Exception e) {

			System.out
					.println("---> Verbindung zur Budget-Datenbank gescheitert!");
			System.out.println("Exception " + e);

			return null;
		}
	}
}
