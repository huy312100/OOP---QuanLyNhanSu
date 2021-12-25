package model;

public class Employee extends HumanResource {
	/* properties */
	private Manager manager;
	
	/* constructors */
	
	
	/* getters and setters */
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/* methods */
	
	@Override
	public float calculateSalary() {
		float result = super.getSalaryPerDay()*super.getDayWork();
		return result;
	}
	
	//@Override
	//public void input(Scanner scanner) {
		//super.input(scanner);
		//System.out.print("Manager ID :  ");
		//this.manager.id=scanner.nextLine();
	//}
}
