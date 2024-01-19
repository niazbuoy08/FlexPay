public class FullTimeEmployeeTaxCalculator implements TaxCalculator{

    @Override
    public double calculateTax(Employee employee) {

        return employee.calculateSalary() * 0.08;
    }
}
