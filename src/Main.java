import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


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


        Employee[] employees = {managerEmployee, partTimeEmployee};
        PayrollProcessor payrollProcessor = new PayrollProcessor();
        double totalSalary = payrollProcessor.calculateTotalSalary(employees) + totalFullTimeSalary;


        System.out.println("Total Salary for the month: Tk " + String.valueOf(totalSalary));

        // Generate reports for FullTimeEmployees
        for (FullTimeEmployee fullTimeEmployee : fullTimeEmployees) {
            ReportGenerator.generateSalarySlip(fullTimeEmployee, "salary_slip.txt");
            ReportGenerator.generateTaxSummary(fullTimeEmployee, "tax_summary.txt");
            ReportGenerator.generatePerformanceReport(fullTimeEmployee, "performance_report.txt");
        }

        // Generate reports for Manager and PartTimeEmployee
        ReportGenerator.generateSalarySlip(managerEmployee, "salary_slip.txt");
        ReportGenerator.generateTaxSummary(managerEmployee, "tax_summary.txt");
        ReportGenerator.generatePerformanceReport(managerEmployee, "performance_report.txt");

        ReportGenerator.generateSalarySlip(partTimeEmployee, "salary_slip.txt");
        ReportGenerator.generateTaxSummary(partTimeEmployee, "tax_summary.txt");
        ReportGenerator.generatePerformanceReport(partTimeEmployee, "performance_report.txt");

        scanner.close();
    }
}
