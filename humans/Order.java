package humans;

import java.util.ArrayList;

import restaurant.Menu;

public class Order {
	private Client orderer;// client
	private Waiter waiter;// waiter
	private ArrayList<Menu> orderList = new ArrayList<>();// list of ordered
															// items
	private double cost=0;// their cost

	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	void addToOrderList(Menu order) {
		orderList.add(order);
		this.cost = this.cost + order.getPrice();
	}

	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		String s = this.orderer.name + " " + this.waiter.name + " " + this.getCost()+ " "+ this.orderList;
		return s;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Client getOrderer() {
		return orderer;
	}

	public void setOrderer(Client orderer) {
		this.orderer = orderer;
	}
}
