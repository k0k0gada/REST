package restaurant;

abstract public class Menu {
	protected String name;
	protected int price;
	protected int amountOfServingsAvailable;

	public int getPrice() {
		return price;
	}

	public int getAmountOfServingsAvailable() {
		return amountOfServingsAvailable;
	}

	public void setAmountOfServingsAvailable() {
		this.amountOfServingsAvailable--;
	}

	public String getName() {
		return name;
	}
	
}
