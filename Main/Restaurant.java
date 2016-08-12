package restaurant;

import java.util.ArrayList;
import java.util.Random;

import drinks.AlcBevs;
import drinks.NoAlcBevs;
import humans.Client;
import humans.Waiter;
import menu.Dessert;
import menu.MainCourse;
import menu.Salad;

public class Restaurant {
	Random rd = new Random();
	public static final String NAME = "При Бай Коста";
	private final String ADDRES;
	private double capital;
	private ArrayList<Menu> menu = new ArrayList<Menu>();
	private ArrayList<Waiter> personal = new ArrayList<>();
	private ArrayList<Client> customers = new ArrayList<>();

	public ArrayList<Client> getCustomers() {
		return customers;
	}

	public Restaurant(String ADDRESS, double capital) {
		this.ADDRES = ADDRESS;
		this.capital = capital;
		this.setMenu();
		this.setPersonal();
	}

	private void setMenu() {
		// 3 salads
		for (int i = 0; i < 3; i++) {
			Salad tempSalad = new Salad();
			menu.add(tempSalad);
		}
		for (int i = 0; i < 3; i++) {
			// 3 main coursees
			MainCourse tempMainCourse = new MainCourse();
			menu.add(tempMainCourse);
		} // 3 desserts
		for (int i = 0; i < 3; i++) {
			Dessert tempDessert = new Dessert();
			menu.add(tempDessert);
		}
		for (int i = 0; i < 2; i++) {
			// 2 alc bevarages
			AlcBevs tempAlcBev = new AlcBevs();
			menu.add(tempAlcBev);
		}
		for (int i = 0; i < 2; i++) {
			// 2 non alchohol bevereges
			NoAlcBevs tempNoAlcBevs = new NoAlcBevs();
			menu.add(tempNoAlcBevs);
		}
	}

	private void setPersonal() {
		for (int i = 0; i < 5; i++) {
			Waiter tempWaiter = new Waiter();
			tempWaiter.setRest(this);
			personal.add(tempWaiter);

		}
	}

	public void addCustomer(Client temp) {
		this.customers.add(temp);
		temp.addRest(this);
	}

	public ArrayList<Waiter> getPersonal() {
		return personal;
	}

	public ArrayList<Menu> getMenu() {
		return menu;
	}

	@SuppressWarnings("static-access")
	public void getRestaurantInfo() {
		System.out.println("the name is : " + this.NAME);
		System.out.println("the address : " + this.ADDRES);
		System.out.println("the amount of money in the cash register is :" + this.capital);
		System.out.println("the menu: " + this.menu);
		System.out.println("the personal: " + this.personal);
		System.out.println("the customers: " + this.customers);

	}

	public boolean isMenuEmpty() {
		boolean emptyRest = true;
		// is there anything left in the restaurant
		for (int i = 0; i < this.menu.size(); i++) {
			if (this.menu.get(i).getAmountOfServingsAvailable() != 0) {
				emptyRest = false;
				break;
			}
		}
		return emptyRest;
	}

	public boolean isMugMenuEmpty() {
		boolean emptyMugRest = true;
		// is there anything left in the restaurant
		for (int i = 0; i < this.menu.size(); i++) {
			if (this.menu.get(i).getAmountOfServingsAvailable() != 0
					&& (this.menu.get(i) instanceof MainCourse || this.menu.get(i) instanceof AlcBevs)) {
				emptyMugRest = false;
				break;
			}
		}
		return emptyMugRest;
	}

	public boolean isVeganMenuEmpty() {
		boolean emptyVegRest = true;
		// is there anything left in the restaurant
		for (int i = 0; i < this.menu.size(); i++) {
			if (this.menu.get(i).getAmountOfServingsAvailable() != 0
					&& (this.menu.get(i) instanceof Salad || this.menu.get(i) instanceof NoAlcBevs)) {
				emptyVegRest = false;
				break;
			}
		}
		return emptyVegRest;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public Waiter getBestWaiter(ArrayList<Waiter> waiters) {
		Waiter temp;
		temp = waiters.get(0);
		for (int i = 1; i < waiters.size(); i++) {
			if (temp.getMoneyAmount() < waiters.get(i).getMoneyAmount()) {
				temp = waiters.get(i);
			}
		}
		return temp;
	}

	public void rankWaiters() {
		ArrayList<Waiter> personal1 = new ArrayList<>();
		for (int i = 0; i < this.personal.size(); i++) {
			personal1.add(this.personal.get(i));
		}
		for (int i = 0; i < this.personal.size(); i++) {
			Waiter temp = getBestWaiter(personal1);
			
			System.out.println(temp);
			personal1.remove(temp);
		}
	}
}
