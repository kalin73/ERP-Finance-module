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

		String query = ("SELECT * FROM ���������");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("���:");
			System.out.print(result.getString("���"));
			System.out.print("; ���:");
			System.out.print(result.getString("���"));
			System.out.print(" ");
			System.out.print(result.getString("�������"));
			System.out.print("; ������:");
			System.out.print(result.getInt("������"));
			System.out.print("; �������:");
			System.out.print(result.getLong("�������"));
			System.out.print("; �����: ");
			System.out.println(result.getString("�����"));
		}
	}

	void income() throws Exception {
		String query = ("SELECT * FROM �������");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("�������� �� �������: ");
			System.out.print(result.getString("��������"));
			System.out.print("; ��������:");
			System.out.println(result.getString("��������"));
		}
	}

	void expenses() throws Exception {
		String query = ("SELECT * FROM �������");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("�������� �� �������: ");
			System.out.print(result.getString("��������"));
			System.out.print("; ��������:");
			System.out.println(result.getString("��������"));
		}
	}

	void salary() throws Exception {
		String query = ("SELECT * FROM �������");
		ResultSet result = connection(query).executeQuery();

		while (result.next()) {
			System.out.print("��� �� ���������:");
			System.out.print(result.getString("���"));
			System.out.print("; ��������� �� � ����:");
			System.out.println(result.getString("�������"));
		}
	}

	double total_income() throws Exception {
		String query = ("SELECT SUM(��������) FROM �������");
		ResultSet result = connection(query).executeQuery();
		result.next();
		double i = result.getDouble(1);

		System.out.print("������ �� ������ ������� �: ");
		System.out.println(i + " ��.");

		return i;
	}

	double total_expense() throws Exception {
		String query = ("SELECT SUM(��������) FROM �������");
		ResultSet result = connection(query).executeQuery();
		result.next();

		double e = result.getDouble(1);

		System.out.print("������ �� ������ ������� �: ");
		System.out.println(e + " ��.");

		return e;
	}

	void total_salary() throws Exception {
		String query = ("SELECT SUM(�������) FROM �������");
		ResultSet result = connection(query).executeQuery();
		result.next();

		System.out.print("������ �� ������ ������� �: ");
		System.out.println(result.getDouble(1) + " ��.");

	}
}
