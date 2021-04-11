package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Department;
import entites.HourContract;
import entites.Worker;
import entites.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		System.out.print("Departament's name: ");
		String departmentName =  sc.nextLine();
		System.out.println("Enter Worker data: ");
		System.out.print("name: ");
		String workerName =  sc.nextLine();
		System.out.print("Level: ");
		String workerLevel =  sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary =  sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		System.out.print("How many contracts to this worker ");
		int n  =  sc.nextInt();
		for (int i = 1; i <=n; i++) {
			System.out.print("Enter contracts #"+i+" data: ");
			System.out.print("Date (DD/MM/YYYY)");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration Hours");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
			
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY)");
		String moonthAndYear = sc.next();
		int moonth = Integer.parseInt(moonthAndYear.substring(0,2));
		int year = Integer.parseInt(moonthAndYear.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+moonthAndYear+": "+ String.format("R$ %.2f", worker.income(year, moonth)));
		
		sc.close();
		 

	}

}
