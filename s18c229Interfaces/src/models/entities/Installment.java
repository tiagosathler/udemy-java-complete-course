package models.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	private LocalDate dueDate;
	private double amount;

	public Installment(LocalDate dueDate, double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString(DateTimeFormatter fmt) {
		return getDueDate().format(fmt) + " - " + String.format("%.2f", getAmount());
	}

	@Override
	public String toString() {
		return getDueDate() + " - " + String.format("%.2f", getAmount());
	}

}
