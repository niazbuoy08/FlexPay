import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of FullTimeEmployees:");
        int numFullTimeEmployees = scanner.nextInt();

        double totalFullTimeSalary = 0;

        for (int i = 0; i < numFullTimeEmployees; i++) {
            System.out.println("Enter salary and bonus percentage for FullTimeEmployee " + (i + 1) + " (separated by space):");
            double fullTimeSalary = scanner.nextDouble();
            double fullTimeBonus = scanner.nextDouble();
            Employee fullTimeEmployee = new FullTimeEmployee(fullTimeSalary, fullTimeBonus);

            // Calculate total salary for FullTimeEmployees
            totalFullTimeSalary += fullTimeEmployee.calculateSalary();
        }

        // Input for Manager and PartTimeEmployee remains the same...

        System.out.println("Enter salary and bonus for Manager (separated by space):");
        double managerSalary = scanner.nextDouble();
        double managerBonus = scanner.nextDouble();
        Employee managerEmployee = new Manager(managerSalary, managerBonus);

        System.out.println("Enter hours worked and hourly rate for PartTimeEmployee (separated by space):");
        double hoursWorked = scanner.nextDouble();
        double hourlyRate = scanner.nextDouble();
        Employee partTimeEmployee = new PartTimeEmployee(hoursWorked, hourlyRate);

        Employee[] employees = { managerEmployee, partTimeEmployee };

        // Adding the total salary for FullTimeEmployees to the total salary calculation
        PayrollProcessor payrollProcessor = new PayrollProcessor();
        double totalSalary = payrollProcessor.calculateTotalSalary(employees) + totalFullTimeSalary;

        System.out.println("Total Salary for the month: Tk " + String.valueOf(totalSalary));

        scanner.close();
    }
}
