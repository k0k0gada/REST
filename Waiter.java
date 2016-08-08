package humans;

import java.util.ArrayList;

import restaurant.Restaurant;

public class Waiter extends Humans {
	static private int counter = 1;
	protected ArrayList<Order> listOfOrders = new ArrayList<>();
	@SuppressWarnings("unused")
	private Restaurant rest;

	public void setRest(Restaurant rest) {
		this.rest = rest;
	}

	public Waiter() {
		this.name = "Waiter" + counter;
		countInc();
		this.moneyAmount = 0;
	}

	@Override
	public String toString() {
		
		String s = "\nname of waiter: " + this.name + " extra money made: " + this.moneyAmount;
		return s;
	}

	private void countInc() {
		counter++;
	}

	void getOrder(Order temp) {
		temp.setWaiter(this);
		this.listOfOrders.add(temp);
	}

}
