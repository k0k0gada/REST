package humans;

import java.util.Random;

import drinks.AlcBevs;
import menu.MainCourse;
import restaurant.Menu;

public class Mug extends Client {
	Random rd = new Random();

	public Mug() {
		super();

		this.type = "Mug";
		this.moneyAmount = 50;
	}

	@Override
	public void orderMeal() {
		// only main courses and alchohol
		if (this.getRest().isMugMenuEmpty()) {
			System.out.println("there is nothing left for the mugs to order.NEXT CLIENT!");
			return;
		}
		// num-remembers the chosen waiter
		int num = rd.nextInt(this.getRest().getPersonal().size());
		// temp remembers which is the chosen waiter and is the waiter
		Waiter temp = this.getRest().getPersonal().get(num);
		chooseOrder();// izbira poru4ka
		this.getOrder().setOrderer(this);// who is the orderer
		temp.getOrder(this.getOrder());// and gives the order to the waiter

	}

	private void chooseOrder() {
		do {
			// temp-random element from the menu
			int temp = rd.nextInt(this.getRest().getMenu().size());
			// if the element is instanceof mainCourse or AlcBevs,else continue
			if (this.getRest().getMenu().get(temp) instanceof MainCourse
					|| this.getRest().getMenu().get(temp) instanceof AlcBevs) {

				Menu temp1 = this.getRest().getMenu().get(temp);
				// temp1 saves the chosen item
				if (temp1.getAmountOfServingsAvailable() == 0) {
					// are there enough of the item available
					System.err.println("no more " + temp1.getName() + " left,choose something else!");
					continue;
				}
				/*
				 * if the cost of the order so far,and the cost of the current
				 * element is less then 90 % of the mug's amount of money the
				 * item is added,otherwise enough ordering
				 */
				if ((temp1.getPrice() + this.getOrder().getCost()) < 0.9 * this.moneyAmount) {
					// adds,the chosen meal to his order
					this.getOrder().addToOrderList(this.getRest().getMenu().get(temp));
					// reduces the Mug's money by the amount that needs to be
					// spent on this item from the menu
					this.moneyAmount = this.moneyAmount - temp1.getPrice();

					/*
					 * temp1 reduces it's amount from the amount in the
					 * restaurant
					 */
					if (temp1 instanceof MainCourse) {
						((MainCourse) (temp1)).setAmountOfServingsAvailable();
					} else {
						((AlcBevs) (temp1)).setAmountOfServingsAvailable();
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
		} while (!this.getRest().isMugMenuEmpty());

	}

}
