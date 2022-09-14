package entities;

public abstract class Payer {
	protected String name;
	protected Double anualIncome;
	
	public Payer() {
	}

	public Payer(String name, double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	abstract public double calculateTax();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
}
