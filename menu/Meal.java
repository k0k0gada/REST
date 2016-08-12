package menu;

import restaurant.Menu;

abstract public class Meal extends Menu {
	protected int amount;// gramaj



	@Override
	public String toString() {
		String s = "\n" + "name of meal: " + this.name + " amount left " + this.amountOfServingsAvailable;
		return s;
	}
}
