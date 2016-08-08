package humans;

import java.util.Random;

import restaurant.Restaurant;

abstract public class Client extends Humans {
	Random rd = new Random();
	static private int counter = 1;
	protected String type;
	private Restaurant rest;
	private Order order = new Order();

	Client() {
		this.name = ("client" + counter);
		countInc();
	}

	public Order getOrder() {
		return order;
	}

	public Restaurant getRest() {
		return rest;
	}

	private void countInc() {
		counter++;
	}

	@Override
	public String toString() {
		String s = "\nname: " + this.name + " " + this.type;
		return s;
	}

	public void addRest(Restaurant temp) {
		this.rest = temp;
	}

	public void orderMeal() {
	}

	public void askForCheck() {
		System.out.println("the check of " + this.name + " " + this.type + " is : " + this.getOrder().getCost());
	}

	public void payCheck() {
		double newCapital = this.getRest().getCapital() + this.getOrder().getCost();
		this.getRest().setCapital(newCapital);
		if (this.leaveTip()) {
			Waiter temp = this.getOrder().getWaiter();
			double tempTipAmount = temp.getMoneyAmount() + ((this.getOrder().getCost() * (5 + rd.nextInt(6))) / 100);
			temp.setMoneyAmount(tempTipAmount);
			System.out.println(this.name + " " + this.type + " left "
					+ ((this.getOrder().getCost() * (5 + rd.nextInt(6))) / 100) + " as a tip");
		} else {
			System.out.println(this.name + " " + this.type + " left no tip");
		}
	}

	public boolean leaveTip() {
		int temp = rd.nextInt(9);
		switch (temp) {
		case 0:
		case 1:
			return false;
		default:
			return true;

		}

	}
}
