package menu;

import java.util.Random;

public class MainCourse extends Meal {
	static private int counter = 1;
	private final int PRICE = 9;
	private Random rd = new Random();

	public MainCourse() {
		this.name = "MainCourse" + counter;
		countInc();
		this.amount = 400 + (10 * rd.nextInt(41));
		/*
		 * all main courses are rounded to tens of grams
		 */
		this.amountOfServingsAvailable=10;
	}

	static void countInc() {
		counter++;
	}
	@Override
	public int getPrice() {
		return this.PRICE;
	}
}
