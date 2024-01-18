public class PartTimeEmployee implements Employee {

    private double hoursWorked; // Change int to double
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
        // Part-time employees might not have a bonus, so returning 0.
        return 0;
    }
}

