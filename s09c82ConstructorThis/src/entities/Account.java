package entities;

public class Account {
	private int id;
	private String holder;
	private double balance;
	private static final double TAX = 5.00;

	public Account(int id, String customerName) {
		this.id = id;
		this.holder = customerName;
	}

	public Account(int id, String holder, double initialDeposit) {
		this.id = id;
		this.holder = holder;
		this.deposit(initialDeposit);
	}

	public int getId() {
		return id;
	}

	public String getHolder() {
		return holder;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double value) {
		this.balance += value;
	}

	public void withdraw(double amount) {
		this.balance -= amount + TAX;
	}

	public String toString() {
		return "Account " + id
				+ ", Holder: " + holder
				+ ", Balance: $ " + String.format("%.2f", balance);
	}
}
