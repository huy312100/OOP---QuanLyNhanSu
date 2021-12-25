package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.Company;
import model.Director;
import model.Employee;
import model.HumanResource;
import model.Manager;

public class HRM {
	private List<HumanResource> listHR;
	private Company company;
	
	public HRM() {
		this.listHR = new ArrayList<>();
		company = new Company();
	}
	
	/* methods */
	public void inputCompany(Scanner scanner) {
		company.input(scanner);
	}
	
	public void outputCompany() {
		company.output();
	}
	
	//3.
	public boolean add(HumanResource hr) {
		// validate - black list
		if(hr == null)
			return false;
		
		if(hr.getID() == null || hr.getID().equals(""))
			return false;
		return listHR.add(hr);
	}
	
	//4.
	public void delete(String id) {
		if(id == null || id.equals("")) {
			System.out.println("ID invalid . Please try again");
			return;
		}
		for(int i=0;i<listHR.size();i++) {
			String className=listHR.get(i).getClass().getSimpleName();
			if(listHR.get(i).getID().equals(id) ) {
				
				if(className.equals("Director")) {
					listHR.removeIf(e->e.getID().equals(id));
				}
				
				else if(className.equals("Manager")){
					listHR.removeIf(e->e.getID().equals(id));
					for(HumanResource hr : listHR) {
						if(hr.getClass().getSimpleName().equals("Employee")) {
							Employee data = (Employee)hr;
							if(data.getManager().getID().equals(id) && data.getManager() != null) {
								data.setManager(null);
							}
						}
					}
				}
				
				else {
					listHR.removeIf(e->e.getID().equals(id));
				}
			}
			System.out.println("Delete succesfully");	
		}
	}
	
	//5.
	public void outputPersonel() {
		if(listHR.isEmpty()) {
			System.out.println("Empty");
		}
		else {
			System.out.println("All member of company");
			System.out.println("-----------------------------");
			for(HumanResource hr : listHR) {
				String className= hr.getClass().getSimpleName();
				System.out.println(""+className);
				if(className.equals("Employee")) {
					  Employee data=(Employee)hr;
					  String info = new StringBuilder() .append("---Personal information---")
					  .append("\nID : ").append(data.getID())
					  .append("\nName : ").append(data.getName())
					  .append("\nPhone : ").append(data.getPhone())
					  .append("\nDay of work : ").append(data.getDayWork())
					  .append("\nSalary per day : ").append(data.getSalaryPerDay()).toString();
					  //.append("\nManager ID : ").append(listHR.get(i).getMa()) .toString();
					  System.out.println(info);
					 
				}
				else if (className.equals("Manager")) {
					  Manager data=(Manager)hr;
					  String info = new StringBuilder() .append("---Personal information---")
					  .append("\nID : ").append( data.getID())
					  .append("\nName : ").append(data.getName())
					  .append("\nPhone : ").append(data.getPhone())
					  .append("\nDay of work : ").append(data.getDayWork())
					  .append("\nSalary per day : ").append(data.getSalaryPerDay()) //
					  .append("\nNumber of employee : ").append(data.getEmployeeNumber()) .toString();
					  System.out.println(info);
					 
					//System.out.println(listHR.get(i));
				}
				
				else {
					  Director data=(Director)hr;
					  String info = new StringBuilder() .append("---Personal information---")
							  .append("\nID : ").append( data.getID())
							  .append("\nName : ").append(data.getName())
							  .append("\nPhone : ").append(data.getPhone())
							  .append("\nDay of work : ").append(data.getDayWork())
							  .append("\nSalary per day : ").append(data.getSalaryPerDay()) //
							  .append("\nStock number  : ").append(data.getStockAmount()) .toString();
							  System.out.println(info);
					}
				}
			}
	}
	
	//6.
	public void allocateEmployeeToManager(Scanner scanner) {
		if(listHR.isEmpty()) {
			System.out.println("Member empty");
			return;
		}
		System.out.println("Enter employee id: ");
		String empID = scanner.nextLine();
		for(int i=0;i<listHR.size();i++) {
			String className=listHR.get(i).getClass().getSimpleName();
			if(className.equals("Employee")) {
				if(listHR.get(i).getID().equals(empID)) {
					Manager newManager=new Manager();
					newManager.setId(empID);
					newManager.setName(listHR.get(i).getName());
					newManager.setPhone(listHR.get(i).getPhone());
					newManager.setSalaryPerDay(listHR.get(i).getSalaryPerDay());
					newManager.setDayWork(listHR.get(i).getDayWork());
					newManager.setEmployeeNumber(0);
					listHR.add(newManager);
					listHR.remove(i);
				}
				else {
					System.out.println("Employee id invalid");
				}
			}
			else {
				System.out.println("Employee id invalid");
			}
		}
		
	}
	//7.
	public float outputSumSalary() {
		if(listHR.isEmpty()) {
			System.out.println("Empty");
			return -1;
		}
		float result = 0;
		for(int i = 0; i < listHR.size(); i++) {
			result +=  listHR.get(i).calculateSalary();
		}
		return result;
	}
	
	//8.
	public void highestSalary() {
		if(listHR.isEmpty()) {
			System.out.println("Member empty");
			return;
		}
		float maxSalary = 0f;
		int index=-1;
		for(int i=0;i<listHR.size();i++) {
			if(listHR.get(i).getClass().getSimpleName().equals("Employee")){
				float salary=listHR.get(i).calculateSalary();
				if(maxSalary<salary) {
					maxSalary=salary;
					index=i;
				}
			}
		}
		if(maxSalary == 0f) {
			System.out.println("Employee dont have any day work");
			return;
		}
		System.out.println("--Information of employee has highest salary---");
		String info = new StringBuilder()
				.append("---Personal information---")
				.append("\nID : ").append( listHR.get(index).getID())
				.append("\nName : ").append(listHR.get(index).getName())
				.append("\nPhone : ").append(listHR.get(index).getPhone())
				.append("\nDay of work : ").append(listHR.get(index).getDayWork())
				.append("\nSalary per day : ").append(listHR.get(index).getSalaryPerDay())
				.append("\nSalary in month : ").append(maxSalary)
				.append("n-------------------------------------------")
				.toString();

		System.out.println(info);
	}
	
	//9.
	public void manageMostEmployee() {
		if(listHR.isEmpty()) {
			System.out.println("Empty list");
			return;
		}
		
		int maxEmployee = -1;
		int index=-1;
		int i=0;
		for(HumanResource hr : listHR) {
			String className= hr.getClass().getSimpleName();
			if(className.equals("Manager")){
				Manager data=(Manager)hr;
				if(maxEmployee<data.getEmployeeNumber()) {
					maxEmployee=data.getEmployeeNumber();
					index=i;
				}
			}
			i++;
		}
		if(index == -1) {
			System.out.println("All manager dont mange any employee");
			return;
		}
		System.out.println("--Information of manage has highest employee---");
		String info = new StringBuilder()
				.append("---Personal information---")
				.append("\nID : ").append( listHR.get(index).getID())
				.append("\nName : ").append(listHR.get(index).getName())
				.append("\nPhone : ").append(listHR.get(index).getPhone())
				.append("\nDay of work : ").append(listHR.get(index).getDayWork())
				.append("\nSalary per day : ").append(listHR.get(index).getSalaryPerDay())
				.append("\nEmployee number : ").append(maxEmployee)
				.append("\n-------------------------------------------")
				.toString();

		System.out.println(info);
	}
	
	//10.
	public void alphaOrder() {
		if(listHR.isEmpty()) {
			System.out.println("Empty list");
			return;
		}
		listHR.sort(new Comparator<HumanResource>() {
			@Override
			public int compare(HumanResource hr1, HumanResource hr2) {
				return hr1.getName().compareTo(hr2.getName());
			}
		});
		System.out.println("Alphabet order succesfully. Choose function number 5 to view alphabet list");
	}
	
	//11.
	public void decesendingSalaryOrder() {
		if(listHR.isEmpty()) {
			System.out.println("Empty list");
			return;
		}
		listHR.sort(new Comparator<HumanResource>() {
			@Override
			public int compare(HumanResource hr1, HumanResource hr2) {
				return hr2.calculateSalary()>hr1.calculateSalary()?1:-1;
			}
		});
		System.out.println("Descending order succesfully. Choose function number 5 to view descending list");
	}
	
	//12.
	public void highestStockNumber() {
		if(listHR.isEmpty()) {
			System.out.println("Member empty");
			return;
		}
		float maxStockNumber = 0f;
		int index=-1;
		int i=0;
		for(HumanResource hr : listHR) {
			String className= hr.getClass().getSimpleName();
			if(className.equals("Director")){
				Director data=(Director)hr;
				float stockNum=data.getStockAmount();
				if(maxStockNumber<stockNum) {
					maxStockNumber=stockNum;
					index=i;
				}
			}
			i++;
		}
		if(maxStockNumber == 0f) {
			System.out.println("Director dont have any stock");
			return;
		}
		System.out.println("--Information of director has highest stock number---");
		String info = new StringBuilder()
				.append("---Personal information---")
				.append("\nID : ").append( listHR.get(index).getID())
				.append("\nName : ").append(listHR.get(index).getName())
				.append("\nPhone : ").append(listHR.get(index).getPhone())
				.append("\nDay of work : ").append(listHR.get(index).getDayWork())
				.append("\nSalary per day : ").append(listHR.get(index).getSalaryPerDay())
				.append("\nStock number : ").append(maxStockNumber)
				.append("\n-------------------------------------------")
				.toString();

		System.out.println(info);
	}
	
	//13.
	public void totalIncomeDirector() {
		if(listHR.isEmpty()) {
			System.out.println("Member empty");
			return;
		}
		if(this.company.getTaxID() == null || this.company.getTaxID().equals("")) {
			System.out.println("Dont have any company in list. Please insert company information");
			return;
		}
		
		float revenueCompany = (float)(company.getrRevenuePerMonth()-outputSumSalary());
		
		for(HumanResource hr : listHR) {
			String className= hr.getClass().getSimpleName();
			if(className.equals("Director")){
				Director data=(Director)hr;
				float income= data.getSalaryPerDay()*data.getDayWork()+data.getStockAmount()*revenueCompany;
				System.out.println("--Information of total income of each director---");
				String info = new StringBuilder()
						.append("---Personal information---")
						.append("\nID : ").append( data.getID())
						.append("\nName : ").append(data.getName())
						.append("\nPhone : ").append(data.getPhone())
						.append("\nDay of work : ").append(data.getDayWork())
						.append("\nSalary per day : ").append(data.getSalaryPerDay())
						.append("\nStock number : ").append(data.getStockAmount())
						.append("\nIncome : ").append(income)
						.append("\n-------------------------------------------")
						.toString();

				System.out.println(info);
			}
		}
		
		
	}
	
	
}
