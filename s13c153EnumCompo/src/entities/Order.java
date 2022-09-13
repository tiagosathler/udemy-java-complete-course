package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment = new Date();
	private OrderStatus status;
	private Client client;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Client client, OrderStatus status) {
		this.client = client;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0.00;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("ORDER SUMMARY: \n");
		sb.append("ORDER MOMENT: " + sdf.format(moment) + "\n");
		sb.append("Client: " + client.getName() + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Order items: \n");

		Double total = 0.00;

		for (OrderItem item : items) {
			sb.append(item);
			total += item.subTotal();
		}

		sb.append("Total price: $" + String.format("%.2f", total));
		return sb.toString();

	}

}
