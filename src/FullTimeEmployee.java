public class FullTimeEmployee implements Employee{

    private double monthlySalary;
    private double bonusPercentage;

    public FullTimeEmployee(double monthlySalary, double bonusPercentage) {
        this.monthlySalary = monthlySalary;
        this.bonusPercentage = bonusPercentage;
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
        return monthlySalary * bonusPercentage;
    }
}
