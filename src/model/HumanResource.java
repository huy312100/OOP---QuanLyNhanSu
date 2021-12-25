package model;

import java.util.Scanner;

public class HumanResource {
	/* properties */
	protected String id;
	protected String name;
	protected String phone;
	protected float dayWork;
	protected float salaryPerDay;
	
	/* constructors */
	
	
	/* getters and setters */
	public String getID() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getDayWork() {
		return dayWork;
	}

	public void setDayWork(float dayWork) {
		this.dayWork = dayWork;
	}

	public float getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(float salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}
	
	/* methods */
	public float calculateSalary() {
		return -1;
	}
	
	public void output() {
		String thongTin = new StringBuilder()
				.append("---Personal information---")
				.append("\nID : ").append(this.id)
				.append("\nName : ").append(this.name)
				.append("\nPhone : ").append(this.phone)
				.append("\nDay of work : ").append(this.dayWork)
				.append("\nSalary per day : ").append(this.salaryPerDay)
				.toString();
		System.out.println(thongTin);
	}
	
	public void input(Scanner scanner) {
		System.out.println("--Input information---");
		System.out.print("ID : ");
		this.id = scanner.nextLine();
		System.out.print("Name : ");
		this.name = scanner.nextLine();
		System.out.print("Phone : ");
		this.phone = scanner.nextLine();
		System.out.print("Day of work : ");
		this.dayWork = Float.parseFloat(scanner.nextLine());
		System.out.print("Salary per day : ");
		this.salaryPerDay = Float.parseFloat(scanner.nextLine());
	}

}
