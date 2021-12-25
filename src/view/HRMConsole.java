package view;

import java.util.Scanner;

import controller.HRM;
import model.Director;
import model.HumanResource;
import model.Employee;
import model.Manager;

public class HRMConsole {
	private HRM controller;
	private Scanner scanner = new Scanner(System.in);
	
	public HRMConsole() {
		controller = new HRM();
	}
	
	public void start() {
		
		int option;
		
		do {
			printMenu();
			option = Integer.parseInt(scanner.nextLine());
		} while (handleMenu(option));
	}
	
	public void printMenu() {
		System.out.println("--Human Resource Management Program--");
		System.out.println("\t1. Enter company information");
		System.out.println("\t2. View company information");
		System.out.println("\t3. Add personnel");
		System.out.println("\t4. Delete personnel");
		System.out.println("\t5. List of members in the company");
		System.out.println("\t6. Allocate staff to Head of Department");
		System.out.println("\t7. Export the company's total salary");
		System.out.println("\t8. Export information of highest paid employee");
		System.out.println("\t9. Output the manager who is managing the most employees");
		System.out.println("\t10. Sort employees alphabetically");
		System.out.println("\t11. Sort employees in descending salary order");
		System.out.println("\t12. Output the director with the highest number of stock");
		System.out.println("\t13. Output total income of each director");
		System.out.println("\t0. Exit.");
		System.out.print("Select : ");
	}
	
	public boolean handleMenu(int option) {
		boolean isContinue = true;
		
		switch (option) {
		case 1: //Enter company information
			controller.inputCompany(scanner);
			break;
		case 2: // View company information
			controller.outputCompany();
			break;
		case 3: //  Add personnel
			addPersonnel();
			break;
		case 4://Delete personnel
			System.out.println("Enter ID employee to delete : ");
			String id = scanner.nextLine();
			controller.delete(id);
			break;
		case 5:// List of members in the company
			controller.outputPersonel();
			break;
		case 6://Allocate staff to Head of Department
			controller.allocateEmployeeToManager(scanner);
			break;
		case 7://Export the company's total salary
			System.out.println("Salary all member of company : "+ controller.outputSumSalary());
			break;
		case 8 ://Export information of highest paid employee
			controller.highestSalary();
			break;
		case 9://Output the manager who is managing the most employees
			controller.manageMostEmployee();
			break;
		case 10://Sort employees alphabetically
			controller.alphaOrder();
			break;
		case 11://Sort employees in descending salary order
			controller.decesendingSalaryOrder();
			break;
		case 12://Output the director with the highest number of stock
			controller.highestStockNumber();
			break;
		case 13://Output total income of each director
			controller.totalIncomeDirector();
			break;
		case 0: 
			isContinue = false;
			break;
		default:
			System.out.println("Selection is invalid.");
			break;
		}
		
		return isContinue;
	}

	private void addPersonnel() {
		System.out.println("Type personel:");
		System.out.println("1. Employee");
		System.out.println("2. Manager");
		System.out.println("3. Director");
		System.out.print("Select : ");
		
		HumanResource hr;
		
		switch (Integer.parseInt(scanner.nextLine())) {
		case 1:
			hr = new Employee();
			hr.input(scanner);
			break;
		case 2:
			hr = new Manager();
			hr.input(scanner);
			break;
		case 3:
			hr = new Director();
			hr.input(scanner);
			break;
		default:
			System.out.println("Personel invalid.");
			return;
		}
		controller.add(hr);
	}
}
