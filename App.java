import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

        // Variable for storing items
        static List<String> cart = new ArrayList<>();
            
    public static void main(String[] args) {
        userInput();

    }

    // CREATE A GRAPHICAL MENU
    public static void menu() {
        System.out.println("Welcome to your shopping cart");
        System.out.println("-----------------------------");
        System.out.println("View list of items in the shopping cart, type list");
        System.out.println("To add item(s) into the shopping cart, type add (add apple / add apple, orange, pear)");
        System.out.println("To delete item(s) from your shopping cart, type delete 1 (item number)");
        System.out.println("End programme, type quit");
        System.out.println("");
    }

    public static void userInput() {

        Console console = System.console();
        String keyboardInput = "";

        while (!keyboardInput.equals("quit")) {
            menu();

            keyboardInput = console.readLine(">>> ");

            if (keyboardInput.toLowerCase().contains("list")) {
                if (cart.size() == 0) {
                    // If list empty, print empty
                    System.out.println("You shopping cart is empty! Add something.");
                } else {
                    // If list has items, print all labels items
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, cart.get(i));
                    }
                    System.out.println("");
                }
            } else if (keyboardInput.toLowerCase().startsWith("add")) {
                keyboardInput = keyboardInput.replace(",", " ");
                Scanner scan = new Scanner(keyboardInput.substring(4));
                String temp;

                while (scan.hasNext()) {
                    temp = scan.next();
                    cart.add(temp);
                }
                scan.close();

            } else if (keyboardInput.toLowerCase().startsWith("delete")) {
                Scanner scan = new Scanner(keyboardInput.substring(6));
                int indexToDelete;

                indexToDelete = Integer.parseInt(scan.next());

                if (indexToDelete <= cart.size()){
                    if (indexToDelete <= 0){
                        System.out.println("What are you trying to delete? check again");
                    } else {
                        cart.remove(cart.get(indexToDelete-1));
                    }
                } else {
                    System.out.println("Index out of bound, what are you trying to delete. Check again");
                }

                scan.close();

            }
        }

        System.out.println("Thank you for using java shopping cart. See you again.");
    }
}
