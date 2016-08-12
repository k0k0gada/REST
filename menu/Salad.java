package menu;

import java.util.Random;

public class Salad extends Meal {
	static private int counter = 1;
	private final int PRICE = 5;
	Random rd = new Random();

	public Salad() {
		this.name = "salad" + counter;
		countInc();
		this.amount = 300 + (10 * rd.nextInt(31));
		/*
		 * all salads are rounded to tens of grams
		 */
		this.amountOfServingsAvailable = 10;
	}

	static void countInc() {
		counter++;
	}

	@Override
	public int getPrice() {
		return this.PRICE;
	}
}
