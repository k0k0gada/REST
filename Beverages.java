package drinks;

import restaurant.Menu;

abstract public class Beverages extends Menu {

	@Override
	public String toString() {
		String s = "\nname: " + this.name + " amount left " + this.amountOfServingsAvailable;
		return s;
	}
}
