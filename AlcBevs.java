package drinks;

public class AlcBevs extends Beverages {
	static private int counter = 1;
	private final int PRICE = 4;

	@Override
	public int getPrice() {
		return this.PRICE;
	}

	public AlcBevs() {
		this.name = "Alchohol" + counter;
		countInc();
		this.amountOfServingsAvailable = 20;
	}

	static void countInc() {
		counter++;
	}
}
