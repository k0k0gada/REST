package drinks;

public class NoAlcBevs extends Beverages {
	static private int counter = 1;
	private final int PRICE = 2;

	public NoAlcBevs() {
		this.name = "Non Alchohol beverage " + counter;
		countInc();
		this.amountOfServingsAvailable = 20;
	}

	static void countInc() {
		counter++;
	}

	@Override
	public int getPrice() {
		return this.PRICE;
	}
}
