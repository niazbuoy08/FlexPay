import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the month name
        System.out.print("Enter the month name: ");
        String monthName = scanner.next();

        System.out.print("Enter number of FullTimeEmployees: ");
        int numFullTimeEmployees = scanner.nextInt();
        FullTimeEmployee[] fullTimeEmployees = new FullTimeEmployee[numFullTimeEmployees];

        for (int i = 0; i < numFullTimeEmployees; i++) {
            System.out.printf("Enter salary and bonus percentage for FullTimeEmployee %d (separated by space): ", (i + 1));
            double fullTimeSalary = scanner.nextDouble();
            double fullTimeBonus = scanner.nextDouble();
            fullTimeEmployees[i] = new FullTimeEmployee(fullTimeSalary, fullTimeBonus);
        }

        System.out.print("Enter salary and bonus for Manager (separated by space): ");
        double managerSalary = scanner.nextDouble();
        double managerBonus = scanner.nextDouble();
        Employee managerEmployee = new Manager(managerSalary, managerBonus);

        System.out.print("Enter hours worked and hourly rate for PartTimeEmployee (separated by space): ");
        double hoursWorked = scanner.nextDouble();
        double hourlyRate = scanner.nextDouble();
        Employee partTimeEmployee = new PartTimeEmployee(hoursWorked, hourlyRate);

        double totalFullTimeSalary = 0;
        for (FullTimeEmployee fullTimeEmployee : fullTimeEmployees) {
            totalFullTimeSalary += fullTimeEmployee.calculateSalary();
        }

        Employee[] employees = { managerEmployee, partTimeEmployee };
        PayrollProcessor payrollProcessor = new PayrollProcessor();
        double totalSalary = payrollProcessor.calculateTotalSalary(employees) + totalFullTimeSalary;

        System.out.println("Total Salary for " + monthName + ": Tk " + String.valueOf(totalSalary));

        for (FullTimeEmployee fullTimeEmployee : fullTimeEmployees) {
            GenerateHandler.generateSalarySlip(fullTimeEmployee, monthName + "_salary_slip.txt");
            GenerateHandler.generateTaxSummary(fullTimeEmployee, monthName + "_tax_summary.txt");
            GenerateHandler.generatePerformanceReport(fullTimeEmployee, monthName + "_performance_report.txt");
        }

        GenerateHandler.generateSalarySlip(managerEmployee, monthName + "_salary_slip.txt");
        GenerateHandler.generateTaxSummary(managerEmployee, monthName + "_tax_summary.txt");
        GenerateHandler.generatePerformanceReport(managerEmployee, monthName + "_performance_report.txt");

        GenerateHandler.generateSalarySlip(partTimeEmployee, monthName + "_salary_slip.txt");
        GenerateHandler.generateTaxSummary(partTimeEmployee, monthName + "_tax_summary.txt");
        GenerateHandler.generatePerformanceReport(partTimeEmployee, monthName + "_performance_report.txt");

        scanner.close();
    }
}
