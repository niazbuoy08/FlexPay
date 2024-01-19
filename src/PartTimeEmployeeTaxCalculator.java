public class PartTimeEmployeeTaxCalculator implements TaxCalculator{

    @Override
    public double calculateTax(Employee employee) {

        return employee.calculateBaseSalary() * 0.05;
    }
}
