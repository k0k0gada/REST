package restaurant;

import java.util.Random;
import java.util.Scanner;

import humans.Mug;
import humans.Students;
import humans.Vegans;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Restaurant rest = new Restaurant("ivan grozni 4", 1000);
		do {
			System.out.println("how many clients should the restaurant have ?");
			int n = sc.nextInt();
			if (n <= 0) {
				System.out.println("can't be negative amount of clients");
				continue;
			} else if (n > 40) {
				System.out.println("not enough space for that many clients!add lesss ");
				continue;
			} else {
				CreateCustomerList(rest, n);
				break;
			}
		} while (true);
		rest.getRestaurantInfo();
		// the clients are ordering
		for (int i = 0; i < rest.getCustomers().size(); i++) {
			rest.getCustomers().get(i).orderMeal();
		}
		// the clients want their checks
		for (int i = 0; i < rest.getCustomers().size(); i++) {
			rest.getCustomers().get(i).askForCheck();
		}
		// the clients are paying their bills
		for (int i = 0; i < rest.getCustomers().size(); i++) {
			rest.getCustomers().get(i).payCheck();
		}
		rest.getRestaurantInfo();
		System.out.println("The best waiter is :\n" + rest.getBestWaiter(rest.getPersonal()));
		System.out.println("the waiters are ranked: ");
		rest.rankWaiters();
		sc.close();

	}

	private static void CreateCustomerList(Restaurant rest, int num) {
		Random rd = new Random();
		for (int i = 0; i < num; i++) {

			switch (rd.nextInt(10)) {
			case 0:
			case 1:
				Vegans tempV = new Vegans();
				rest.addCustomer(tempV);
				break;
			case 2:
			case 3:
			case 4:
				Students tempS = new Students();
				rest.addCustomer(tempS);
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				Mug tempM = new Mug();
				rest.addCustomer(tempM);
				break;
			}
		}
	}
}
