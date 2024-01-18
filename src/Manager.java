public class Manager implements Employee {

    private double baseSalary;
    private double bonus;
    private int employeeId;


    public Manager() {

    }


    public Manager(double baseSalary, double bonus) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.employeeId = generateEmployeeId();  
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
