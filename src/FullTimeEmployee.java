public class FullTimeEmployee implements Employee {

    private double monthlySalary;
    private double bonusPercentage;
    private int employeeId;  // Assuming you have added the getEmployeeId() method

    public FullTimeEmployee(double monthlySalary, double bonusPercentage) {
        this.monthlySalary = monthlySalary;
        this.bonusPercentage = bonusPercentage;
        this.employeeId = generateEmployeeId();  // Assuming you have a method to generate IDs
    }

    @Override
    public double calculateSalary() {
        return calculateBaseSalary() + calculateBonus();
    }

    @Override
    public double calculateBaseSalary() {
        return monthlySalary;
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * (bonusPercentage / 100);
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    // Helper method to generate unique employee IDs
    private static int nextEmployeeId = 1;

    private synchronized int generateEmployeeId() {
        return nextEmployeeId++;
    }
}
