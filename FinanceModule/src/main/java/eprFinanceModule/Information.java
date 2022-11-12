package eprFinanceModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Information {

	private PreparedStatement connection(String query) {
		PreparedStatement statement = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finances", "root", "root");
			statement = conn.prepareStatement(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;

	}

	void employees() throws Exception {

		String query = ("SELECT * FROM служители");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("ЕГН:");
			System.out.print(result.getString("ЕГН"));
			System.out.print("; Име:");
			System.out.print(result.getString("име"));
			System.out.print(" ");
			System.out.print(result.getString("фамилия"));
			System.out.print("; Години:");
			System.out.print(result.getInt("години"));
			System.out.print("; Телефон:");
			System.out.print(result.getLong("телефон"));
			System.out.print("; Имейл: ");
			System.out.println(result.getString("имейл"));
		}
	}

	void income() throws Exception {
		String query = ("SELECT * FROM приходи");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("Описание на прихода: ");
			System.out.print(result.getString("описание"));
			System.out.print("; Стойност:");
			System.out.println(result.getString("стойност"));
		}
	}

	void expenses() throws Exception {
		String query = ("SELECT * FROM разходи");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("Описание за разхода: ");
			System.out.print(result.getString("описание"));
			System.out.print("; Стойност:");
			System.out.println(result.getString("стойност"));
		}
	}

	void salary() throws Exception {
		String query = ("SELECT * FROM заплати");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("ЕГН на служителя:");
			System.out.print(result.getString("ЕГН"));
			System.out.print("; Заплатата ми в лева:");
			System.out.println(result.getString("заплата"));
		}
	}

	double total_income() throws Exception {
		String query = ("SELECT SUM(стойност) FROM приходи");
		ResultSet result = connection(query).executeQuery();
		result.next();
		double i = result.getDouble(1);

		System.out.print("Сумата на всички приходи е: ");
		System.out.println(i + " лв.");

		return i;
	}

	double total_expense() throws Exception {
		String query = ("SELECT SUM(стойност) FROM разходи");
		ResultSet result = connection(query).executeQuery();
		result.next();

		double e = result.getDouble(1);

		System.out.print("Сумата на всички разходи е: ");
		System.out.println(e + " лв.");

		return e;
	}

	void total_salary() throws Exception {
		String query = ("SELECT SUM(заплата) FROM заплати");
		ResultSet result = connection(query).executeQuery();
		result.next();

		System.out.print("Сумата на всички заплати е: ");
		System.out.println(result.getDouble(1) + " лв.");

	}
}
