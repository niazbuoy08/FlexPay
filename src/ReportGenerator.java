import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ReportGenerator {
    public static void generateSalarySlip(Employee employee, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true))) {
            writer.println("Salary Slip for Employee: " + employee.getClass().getSimpleName());
            writer.println("Employee ID: " + employee.getEmployeeId());
            writer.println("Base Salary: " + employee.calculateBaseSalary());
            writer.println("Bonus: " + employee.calculateBonus());
            writer.println("Total Salary: " + employee.calculateSalary());
            writer.println("------------------------------");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void generateTaxSummary(Employee employee, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true))) {
            writer.println("Tax Summary for Employee: " + employee.getClass().getSimpleName());
            // Add tax-related information
            writer.println("------------------------------");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void generatePerformanceReport(Employee employee, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true))) {
            writer.println("Performance Report for Employee: " + employee.getClass().getSimpleName());
            // Add performance-related information
            writer.println("------------------------------");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
