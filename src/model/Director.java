package model;

import java.util.Scanner;

public class Director extends HumanResource {
	/* properties */
	private float stockAmount;
	
	/* constructors */
	
	
	/* getters and setters */
	public float getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(float stockAmount) {
		this.stockAmount = stockAmount;
	}

	
	/* methods */
	@Override
	public float calculateSalary() {
		float result = super.getSalaryPerDay()*super.getDayWork();
		return result;
	}
	
	@Override
	public void input(Scanner scanner) {
		super.input(scanner);
		System.out.print("Stock amount: ");
		this.stockAmount = Float.parseFloat(scanner.nextLine());
	}

	@Override
	public void output() {
		super.output();
		System.out.println(new StringBuilder()
				.append("Stock amount : ")
				.append(this.stockAmount));
	}
	
	
}
