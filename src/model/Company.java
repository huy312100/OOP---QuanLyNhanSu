package model;

import java.util.Scanner;

public class Company {
	/* properties */
	private String name;
	private String taxID;
	private double revenuePerMonth;
	
	/* constructors */
	
	
	/* getters and setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public double getrRevenuePerMonth() {
		return revenuePerMonth;
	}

	public void setRevenuePerMonth(double revenuePerMonth) {
		this.revenuePerMonth = revenuePerMonth;
	}
	
	/* methods */
	public void input(Scanner scanner) {
		System.out.println("---Input company infomation---");
		System.out.print("Name : ");
		this.name = scanner.nextLine();
		System.out.print("Tax ID: ");
		this.taxID = scanner.nextLine();
		System.out.print("Revenue per month: ");
		this.revenuePerMonth = Double.parseDouble(scanner.nextLine());
	}
	
	public void output() {
		System.out.println("---Company information---");
		System.out.println(new StringBuilder()
				.append("Name :  ").append(this.name)
				.append("\nTax ID : ").append(this.taxID)
				.append("\nRevenue per month: ").append(this.revenuePerMonth));
	}

}
