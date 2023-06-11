package _06_Console_Store;

import java.util.ArrayList;
import java.util.Scanner;

import _02_Generics_Store.Cart;

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
    public static void main(String[] args) {
    	int money = 100;
    	
    	System.out.println("You currently have " + money + " dollars");
    	String choice;
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
    	
    }
    public static int countPrice() {
    	int price = 0;
    	for(int i = 0; i < items.size(); i++) {
    		if(items.get(i).equals("Candy")) {
    			price+=1;
    		} else if(items.get(i).equals("Cereal")) {
    			price+=5;
    		} else if(items.get(i).equals("Clothing")) {
    			price+=35;
    		} else if(items.get(i).equals("Toy")) {
    			price+=15;
    		}
    	}
    	return 0;
    }

}
