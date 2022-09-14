package entities;

public class IndividualPayer extends Payer {
	private Double health;

	private static double CRITERIA = 2000.00;

	private static double LOWER_TAX_RATE = 0.15;
	private static double HIGHER_TAX_RATE = 0.25;

	public IndividualPayer() {
		super();
	}

	public IndividualPayer(String name, double anualIncome, double health) {
		super(name, anualIncome);
		this.health = health;
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	@Override
	public double calculateTax() {
		double tax = 0.00;
		if (anualIncome < CRITERIA) {
			tax = anualIncome * LOWER_TAX_RATE;
		} else {
			tax = anualIncome * HIGHER_TAX_RATE;
		}
		if (health != null) {
			tax -= health / 2;
		}
		return tax;
	}

}
