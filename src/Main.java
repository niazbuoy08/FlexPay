import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login or signup based on user input
        System.out.print("Do you want to login (L) or signup (S)? ");
        char choice = scanner.next().toUpperCase().charAt(0);

        User loggedInUser = null;

        if (choice == 'L') {
            loggedInUser = loginUser(scanner, "admin");  // Replace "admin" with the actual role
            if (loggedInUser != null) {
                System.out.println("Admin logged in successfully!");
            } else {
                System.out.println("Invalid credentials. Exiting...");
                return; // Exit the program if login is unsuccessful
            }
        } else if (choice == 'S') {
            signupUser(scanner, "admin");  // Replace "admin" with the actual role
            System.out.println("Admin signed up successfully!");

            loggedInUser = loginUser(scanner, "admin");
        } else {
            System.out.println("Invalid choice. Exiting...");
            return; // Exit the program if the choice is invalid
        }

        // Only allow access to Payroll Management functionality if the user is logged in
        if (loggedInUser != null) {
            // Rest of your Payroll Management functionality
            System.out.println("Access to Payroll Management functionality granted.");
        }


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

        TaxCalculator managerTaxCalculator = new ManagerTaxCalculator();
        GenerateHandler generateHandler = new GenerateHandler(managerTaxCalculator);


        for (FullTimeEmployee fullTimeEmployee : fullTimeEmployees) {
            generateHandler.generateSalarySlip(fullTimeEmployee, monthName + "_salary_slip.txt");
            generateHandler.generateTaxSummary(fullTimeEmployee, monthName + "_tax_summary.txt");
        }

        generateHandler.generateSalarySlip(managerEmployee, monthName + "_salary_slip.txt");
        generateHandler.generateTaxSummary(managerEmployee, monthName + "_tax_summary.txt");

        generateHandler.generateSalarySlip(partTimeEmployee, monthName + "_salary_slip.txt");
        generateHandler.generateTaxSummary(partTimeEmployee, monthName + "_tax_summary.txt");


        scanner.close();
    }

    private static User loginUser(Scanner scanner, String role) {
        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        // Placeholder logic, replace with actual login logic
        System.out.println("Login logic for " + role + " user");

        // Return a User object upon successful login, or null for unsuccessful login
        return null;  // Replace with actual return value
    }

    private static void signupUser(Scanner scanner, String role) {
        System.out.print("Enter a new username: ");
        String newUsername = scanner.next();

        System.out.print("Enter a new password: ");
        String newPassword = scanner.next();

        // Placeholder logic, replace with actual signup logic
        System.out.println("Signup logic for " + role + " user");

        // Replace with actual implementation
    }
}
