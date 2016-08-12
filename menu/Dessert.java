package menu;

import java.util.Random;

public class Dessert extends Meal {
	static private int counter = 1;
	private final int PRICE = 4;
	Random rd = new Random();

	public Dessert() {
		this.name = "Dessert" + counter;
		countInc();
		this.amount = 200 + (10 * rd.nextInt(11));
		/*
		 * all desserts are rounded to tens of grams
		 */
		this.amountOfServingsAvailable = 10;
	}
	@Override
	public int getPrice() {
		return this.PRICE;
	}

	static void countInc() {
		counter++;
	}
}
