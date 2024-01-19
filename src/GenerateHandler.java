import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GenerateHandler {

    private TaxCalculator taxCalculator;

    public GenerateHandler(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void generateTaxSummary(Employee employee, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true))) {
            writer.println("Tax Summary for Employee: " + employee.getClass().getSimpleName());
            writer.println("Employee ID: " + employee.getEmployeeId());
            writer.println("Tax: " + taxCalculator.calculateTax(employee));
            writer.println("------------------------------");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public void generateSalarySlip(Employee employee, String outputFile) {
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
}
