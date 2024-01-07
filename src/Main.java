public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee(5000, 0.1),
                new Manager(8000, 2000),
                new PartTimeEmployee(20, 15)

        };

        PayrollProcessor payrollProcessor = new PayrollProcessor();
        double totalSalary = payrollProcessor.calculateTotalSalary(employees);

        System.out.println("Total Salary: Tk " + totalSalary);
    }
}