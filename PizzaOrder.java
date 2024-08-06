import java.util.*;
import java.text.DecimalFormat;

public class PizzaOrder
{
	public static void main (String [] args)
	{
		DecimalFormat money = new DecimalFormat ("#0.00");
		Scanner keyboard = new Scanner (System.in);

		//Create an instance of a Pizza
		Pizza order = new Pizza ();

		String firstName;		//user's first name
		boolean discount = false;//flag, true if user is eligible for discount
		int inches;				//size of the pizza
		char crustType;			//type of crust
		double cost;			//cost of the pizza
		final double TAX_RATE = .12;//sales tax rate 12%
		double tax;				//amount of tax
		char choice;			//user's choice
		String input;			//user input
		ArrayList<String> toppings = new ArrayList<>();//list of toppings
		toppings.add("Cheese");
		int numberOfToppings = 0;	//number of toppings

		//prompt user and get first name
		System.out.println("Welcome to LJU Pizza");
		System.out.print("Enter your first name:-  ");
		firstName = keyboard.nextLine();

		//determine if user is eligible for discount by
		//having the same first name as one of the owners
		if (firstName.equalsIgnoreCase("Malhar") 
		|| firstName.equalsIgnoreCase("John") 
		|| firstName.equalsIgnoreCase("Peter")
		|| firstName.equalsIgnoreCase("Dwayne"))
			discount= true;


		//prompt user and get pizza size choice
		System.out.println("Pizza Size (inches)   Cost");
		System.out.println("              10      Rs.250");
		System.out.println("              12      Rs.350");
		System.out.println("              14      Rs.450");
		System.out.println("              16      Rs.550");
		System.out.println("What size pizza would you like?");
		System.out.print("10, 12, 14, or 16 (enter the number only): ");
		inches = keyboard.nextInt();

		//set price and size of pizza ordered
		if (inches == 10)
		{
			order.setSize(10);
			order.setCost(-100);
		}
		else if (inches ==12)
		{
			order.setSize(12);
			order.setCost(0);
		}
		else if (inches == 14)
		{
			order.setSize(14);
			order.setCost(100);
		}
		else if (inches == 16)
		{
			order.setSize(16);
			order.setCost(200);
		}
		else
		{
			System.out.print("User input was not one of the choices, so a 12 inch pizza will be made");
			order.setSize(12);
			order.setCost(0);
		}
		//consume the remaining newline character
		keyboard.nextLine();

		//prompt user and get crust choice
		System.out.println("What type of crust do you want? ");
		System.out.print("(H)Hand-tossed, (T) Thin-crust, or " +
			"(D) Deep-dish (enter H, T, or D): ");
		input = keyboard.nextLine();
		crustType = input.charAt(0);

		//set user's crust choice on pizza ordered
		switch(crustType)
		{
			case 'H':
			case 'h':
				order.setCrust("Hand-Tossed");
				break;
			case 'T':
			case 't':
				order.setCrust("Thin-Crust");
				break;
			case 'D':
			case 'd':
				order.setCrust("Deep Dish");
				break;
			default:
				System.out.print("User's input not one of the choices, so a hand tossed crust will be made");
				order.setCrust("Hand-Tossed");
		}

		//prompt user and get topping choices one at a time
		System.out.println("All pizzas come with cheese.");
		System.out.println("Additional toppings are Rs 30.0 each,"
				+ " choose from");
		System.out.println("Pepperoni, Sausage, Onion, Mushroom");

		//if topping is desired,
		//add to topping list and number of toppings
		System.out.print("Do you want Pepperoni?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings.add("Pepperoni");
		}
		System.out.print("Do you want Sausage?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings.add("Sausage");
		}
		System.out.print("Do you want Onion?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings.add("Onion");
		}
		System.out.print("Do you want Mushroom?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings.add("Mushroom");
		}
		keyboard.close();
		//set number of toppings and topping list on pizza ordered
		order.setNumToppings (numberOfToppings);
		order.setToppingList(toppings);

		//add additional toppings cost to cost of pizza
		order.setCost(30*numberOfToppings);

		//display order confirmation
		System.out.println();
		System.out.println("Your order is as follows: ");
		System.out.println("Size:- "+order.getSize() + " inch pizza");
		System.out.println("Crust type:- "+order.getCrust());
		System.out.println("Your toppings:- "+order.getToppingList());

		//apply discount if user is elibible
		if (discount==true)
		{
			System.out.print("User is eligible for a Rs 100.0 discount. ");
			order.setCost(-100);
		}

		//SO ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES
		//display cost of pizza
		cost = order.getCost();
		System.out.println("The cost of your order is: Rs" + money.format(cost));

		//calculate and display tax and total cost
		tax = cost * TAX_RATE;
		System.out.println("The tax is:  Rs" + money.format(tax));
		System.out.println("The total due is:  Rs" + money.format(tax + cost));

		System.out.println("Your order will be ready for pickup in 30 minutes.");
	}
}