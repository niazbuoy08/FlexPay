public class Manager implements Employee{

    private double baseSalary;
    private double bonus;

    public Manager(double baseSalary, double bonus) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return calculateBaseSalary() + calculateBonus();
    }

    @Override
    public double calculateBaseSalary() {
        return baseSalary;
    }

    @Override
    public double calculateBonus() {
        return bonus;
    }
}
