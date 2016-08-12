package humans;

import drinks.NoAlcBevs;
import menu.Salad;
import restaurant.Menu;

public class Vegans extends Client {

	public Vegans() {
		super();
		this.type = "Vegan";
		this.moneyAmount = 30;
	}

	@Override
	public void orderMeal() {
		// only main courses and alchohol
		if (this.getRest().isVeganMenuEmpty()) {
			System.out.println("there is nothing left for the Vegens to order.NEXT CLIENT!");
			return;
		}
		// num-remembers the chosen waiter
		int num = rd.nextInt(this.getRest().getPersonal().size());
		// temp remembers which is the chosen waiter and is the waiter
		Waiter temp = this.getRest().getPersonal().get(num);
		chooseOrder();// izbira poru4ka
		this.getOrder().setOrderer(this);// who is the orderer
		temp.getOrder(this.getOrder());// and gives the order to the waiter
		this.moneyAmount = this.moneyAmount - this.getOrder().getCost();
	}

	private void chooseOrder() {
		do {
			// temp-random element from the menu
			int temp = rd.nextInt(this.getRest().getMenu().size());
			// if the element is instanceof Salad or NoAlcBevs,else continue
			if (this.getRest().getMenu().get(temp) instanceof Salad
					|| this.getRest().getMenu().get(temp) instanceof NoAlcBevs) {

				Menu temp1 = this.getRest().getMenu().get(temp);
				// temp1 saves the chosen item
				if (temp1.getAmountOfServingsAvailable() == 0) {
					// are there enough of the item available
					System.err.println("no more " + temp1.getName() + " left,choose something else!");
					continue;
				}
				/*
				 * if the cost of the order so far,and the cost of the current
				 * element is less then 90 % of the vegan's amount of money the
				 * item is added,otherwise enough ordering
				 */
				if ((temp1.getPrice() + this.getOrder().getCost()) < 0.9 * this.moneyAmount) {
					// adds,the chosen meal to his order
					this.getOrder().addToOrderList(this.getRest().getMenu().get(temp));
					// reduces the Vegan's money by the amount that needs to be
					// spent on this item from the menu
					this.moneyAmount = this.moneyAmount - temp1.getPrice();
					/*
					 * temp1 reduces it's amount from the amount in the
					 * restaurant
					 */
					if (temp1 instanceof Salad) {
						((Salad) (temp1)).setAmountOfServingsAvailable();
					} else {
						((NoAlcBevs) (temp1)).setAmountOfServingsAvailable();
					}
				} else {
					break;
				}
			} else {
				continue;
			}
			if (rd.nextBoolean()) {
				break;// does the client want anything else ?
			}
		} while (!this.getRest().isVeganMenuEmpty());

	}

}
