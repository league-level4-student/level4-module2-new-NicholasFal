package _06_Console_Store;

import java.util.ArrayList;
import java.util.Scanner;

import _02_Generics_Store.Candy;
import _02_Generics_Store.Cart;
import _02_Generics_Store.CartF;
import _02_Generics_Store.Cereal;
import _02_Generics_Store.Clothing;
import _02_Generics_Store.Toy;

public class ConsoleStore {

    /*
     * Write a program that simulates shopping in a store using the Scanner and
     * the classes in Generics_Store.
     * 
     * Note: You may need to modify existing code in Generics Store and/or add
     * additional items and pictures to fulfill all the requirements. You are
     * also free to add any additional methods or classes in Console Store that
     * might be helpful to you.
     * 
     * Requirements:
     * 
     * -Use Ternary operators in place of simple if/else statements and do-while
     * loops instead of while loops where appropriate.
     * 
     * - There should be at least four unique items the user can buy. These can
     * be food items, nonfood items or both.
     * 
     * - The user should have a stipend of money to spend and each item should
     * have its own price.
     * 
     * -The user should have the ability to add items to their cart, remove
     * items, view items or check out.
     * 
     * -The program should continue until the user chooses to check out.
     * 
     * -When the user checks out you should let them know if they do not have
     * enough money to purchase all their items and offer to put items back.
     * 
     * -If the user successfully purchases the items you should remove the
     * amount from their stipend, show them the pictures of what they bought and
     * print out a receipt showing their name, the individual prices of the
     * items and their total.
     */
	Cart cart = new Cart();
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> items = new ArrayList<String>();
	 static String name;
    public static void main(String[] args) {
    	int money = 100;
    	
    	System.out.println("You currently have " + money + " dollars");
    	String choice;
    	System.out.println("Name: ");
    	name = scan.nextLine();
    	do {
    	System.out.println("Would you like to add an item, remove an item, view items, or check out your cart? (add, remove, view, check out)");
    	choice = scan.nextLine(); 
    	if(choice.equals("add")) {
    		addItems();
    	} else if(choice.equals("remove")) {
    		removeItems();
    	} else if(choice.equals("view")) {
    		viewItems();
    	} else if(choice.equals("check out")) {
    		checkOut();
    	} else {
    		System.out.println("Answer not understood");
    	}
    	} while(!choice.equals("check out"));
    	scan.close();
    }
    public static void addItems() {
    	System.out.println("Items: \n Candy: $1 \n Cereal: $5 \n Clothing: $35 \n Toy: $15");
    	System.out.println("Which item would you like to add to your cart? (candy, cereal, clothing, toy)");
    	String item = scan.nextLine();
    	items.add(item);
    }
    public static void removeItems() {
    	viewItems();
    	System.out.println("Which item would you like to remove?");
    	String item = scan.nextLine();
    	boolean continues = true;
    	for(int i = 0; i < items.size(); i++) {
    		if(items.get(i).equals(item) && continues) {
    			items.remove(i);
    			continues = false;
    		}
    	}
        if(continues) {
    	System.out.println("Item could not be found");
        } else {
        	System.out.println("Item removed");
        }
  
    }
    public static void viewItems() {
    	for(int i = 0; i < items.size(); i++) {
    		System.out.println(items.get(i));
    	}
    }
    public static void checkOut() {
    	int price = countPrice();
    	if(price < 100) {
    		System.out.println("Name: " + name);
    	
    	int clothingP = 35;
    	int candyP = 1;
    	int toyP = 15;
    	int cerealP = 5;
    	for(int i = 0; i < items.size(); i++) {
    		if(items.get(i).equalsIgnoreCase("Clothing")) {
    		System.out.println(items.get(i) + " - $" + clothingP );
    		} else if(items.get(i).equalsIgnoreCase("Candy")) {
        		System.out.println(items.get(i) + " - $" + candyP );
    		} else if(items.get(i).equalsIgnoreCase("Toy")) {
        		System.out.println(items.get(i) + " - $" + toyP );
    		} else if(items.get(i).equalsIgnoreCase("Cereal")) {
        		System.out.println(items.get(i) + " - $" + cerealP );
    		}
    	}
    	System.out.println("Total: " + price);
    	showItems();
    	} else {
    		do {
    		price = countPrice();
    		System.out.println("Your total is " + price + ". You do not have enough money to pay for this, please remove an item.");
    		removeItems();
    		price = countPrice();
    		} while(price > 100);
    		int clothingP = 35;
        	int candyP = 1;
        	int toyP = 15;
        	int cerealP = 5;
        	for(int i = 0; i < items.size(); i++) {
        		if(items.get(i).equalsIgnoreCase("Clothing")) {
        		System.out.println(items.get(i) + " - $" + clothingP );
        		} else if(items.get(i).equalsIgnoreCase("Candy")) {
            		System.out.println(items.get(i) + " - $" + candyP );
        		} else if(items.get(i).equalsIgnoreCase("Toy")) {
            		System.out.println(items.get(i) + " - $" + toyP );
        		} else if(items.get(i).equalsIgnoreCase("Cereal")) {
            		System.out.println(items.get(i) + " - $" + cerealP );
        		}
        	}
        	System.out.println("Total: " + price);
    		showItems();
    	}
    }
    public static int countPrice() {
    	int price = 0;
    	for(int i = 0; i < items.size(); i++) {
    		if(items.get(i).equalsIgnoreCase("Candy")) {
    			price+=1;
    		} else if(items.get(i).equalsIgnoreCase("Cereal")) {
    			price+=5;
    		} else if(items.get(i).equalsIgnoreCase("Clothing")) {
    			price+=35;
    		} else if(items.get(i).equalsIgnoreCase("Toy")) {
    			price+=15;
    		}
    	}
    	
    	return price;
    }
    public static void showItems() {
    	Cart<Clothing> clothing = new Cart();
		Cart<Toy> toys = new Cart();
		CartF<Cereal> cereal = new CartF();
		CartF<Candy> candy = new CartF();
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).equalsIgnoreCase("clothing")) {
				clothing.add(new Clothing());
			} else if(items.get(i).equalsIgnoreCase("toy")) {
				toys.add(new Toy());
			} else if(items.get(i).equalsIgnoreCase("cereal")) {
				cereal.add(new Cereal());
			} else if(items.get(i).equalsIgnoreCase("candy")) {
				candy.add(new Candy());
			}
		}
		clothing.showCart();
		toys.showCart();
		cereal.showCart();
		candy.showCart();

    }

}
