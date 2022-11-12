package eprFinanceModule;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		menu();
		String command = sc.nextLine();

		while (!"exit".equalsIgnoreCase(command)) {

			switch (command) {
			case "report":
				Information t1 = new Information();
				double income = t1.total_income();
				double expenses = t1.total_expense();
				System.out.print("������� �����: ");
				System.out.print(income - expenses);
				System.out.println(" ��.");
				break;

			case "totalsal":
				Information salaries = new Information();
				salaries.total_salary();
				break;

			case "totalex":
				Information totalExpenses = new Information();
				totalExpenses.total_expense();
				break;

			case "totalin":
				Information totalIncome = new Information();
				totalIncome.total_income();
				break;

			case "emp":
				Information employees = new Information();
				employees.employees();
				break;

			case "in":
				Information incomeInfo = new Information();
				incomeInfo.income();
				break;

			case "ex":
				Information exp = new Information();
				exp.expenses();
				break;

			case "sa":
				Information sal = new Information();
				sal.salary();
				break;

			default:
				System.out.println("������ �������! �����e�� ������:");
			}
			command = sc.nextLine();
		}
		sc.close();

	}

	private static void menu() {
		System.out.println("�������� �������: \ntotalex - �� ��������� �� ������ �� ������ �������"
				+ "\ntotalin - �� ��������� �� ������ �� ������ �������"
				+ "\ntotalsal - �� ��������� �� ������ �� ������ �������" + "\nreport - �� ��������� �� �����"
				+ "\nemp - �� ��������� �� ���������� �� �����������"
				+ "\nin - ������� �� ������������ �� ��������� � �������"
				+ "\nex - ������� �� ������������ �� ��������� � ���������"
				+ "\nsa - ������� �� ������������ �� ��������� ��� ���������");
	}
}
