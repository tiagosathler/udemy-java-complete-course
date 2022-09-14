package entities;

public class CompanyPayer extends Payer {
	private Integer employees;

	private static Integer CRITERIA = 10;

	private static double LOWER_TAX_RATE = 0.14;
	private static double HIGHER_TAX_RATE = 0.16;

	public CompanyPayer() {
		super();
	}

	public CompanyPayer(String name, double anualIncome, Integer employees) {
		super(name, anualIncome);
		this.employees = employees;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	@Override
	public double calculateTax() {
		double tax = 0.00;
		if (employees != null && employees > CRITERIA) {
			tax = anualIncome * LOWER_TAX_RATE;
		} else {
			tax = anualIncome * HIGHER_TAX_RATE;
		}
		return tax;
	}

}
