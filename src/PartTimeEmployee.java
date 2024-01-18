public class PartTimeEmployee implements Employee {

    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return calculateBaseSalary() + calculateBonus();
    }

    @Override
    public double calculateBaseSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public double calculateBonus() {
        return 0; // Part-time employees might not have a bonus, so returning 0.
    }

    @Override
    public int getEmployeeId() {
        // Provide an implementation to return the employee's ID for PartTimeEmployee
        // You can return a constant, retrieve it from a field, database, etc.
        return 0; // Replace with the actual implementation
    }
}
