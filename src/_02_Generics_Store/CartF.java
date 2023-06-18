package _02_Generics_Store;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CartF<T extends Food> {
	private T[] cart;

    public CartF() {
        cart = (T[]) new Food[5];
    }

    // Adds an item to the cart
    public void add(T item) {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                cart[i] = item;
                return;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Your cart is full!\nNo more than 5 items");
    }

    // Displays everything currently in the cart
    public void showCart() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                panel.add(cart[i].getFood());
            }
        }
        frame.pack();

    }

    public int length() {
        return cart.length;
    }
}
