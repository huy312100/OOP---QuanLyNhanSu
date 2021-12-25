package model;

import java.util.Scanner;

public class Manager extends HumanResource {
	/* properties */
	private int employeeNumber;
	
	/* constructors */
	
	
	/* getters and setters */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	/* methods */
	@Override
	public float calculateSalary() {
		float result = super.getSalaryPerDay()*super.getDayWork()+100*employeeNumber;
		return result;
	}

	@Override
	public void input(Scanner scanner) {
		super.input(scanner);
		System.out.print("Number of employee :  ");
		this.employeeNumber=Integer.parseInt(scanner.nextLine());
	}
	
	public void output() {
		super.output();
		System.out.println(new StringBuilder()
				.append("Number of employee : ")
				.append(this.employeeNumber));
	}

}
