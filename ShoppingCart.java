import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    protected ArrayList<items> cart;
    private catalog catalog;
    protected double totalCost;


    public ShoppingCart() {
        this.cart = new ArrayList<>();
        this.catalog = new catalog("catalog.txt");
        this.totalCost = 0.0;
    }

    public void displayCatalog() {
        System.out.println("Catalog:");
        catalog.displayItem("catalog.txt");
    }

    public void addToCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the item you want to add to the cart:");
        String itemName = scanner.nextLine();
        System.out.println("Enter the quantity to add:");
        int quantity = scanner.nextInt();
        ArrayList<items> searchResults = catalog.searchItems(itemName);
        if (searchResults.isEmpty()) {
            System.out.println("Sorry, the item '" + itemName + "' is not found in the catalog.");
        } else {
            items item = searchResults.get(0);
            if (item.getQuantity() == 0) {
                System.out.println("Sorry, this item is out of stock.");
            } else if (item.getQuantity() < quantity) {
                System.out.println("Sorry, there are only " + item.getQuantity() + " items of '" + itemName + "' available.");
            } else {
                item.setQuantity(item.getQuantity() - quantity);
                items cartItem = new items(item.getNameOfItem(), item.getBrandName(), item.getDescription(), item.getCategory(), item.getPriceOfItem(), quantity);
                cart.add(cartItem);
                System.out.println(quantity + " " + itemName + "(s) added to the cart.");
                totalCost += item.getPriceOfItem() * quantity;
            }
        }
    }
    public void displayCart () {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart items:");
            for (items item : cart) {
                System.out.println(item.getNameOfItem() + " x " + item.getQuantity() + " = $" + item.getPriceOfItem() * item.getQuantity());
            }
            System.out.println("Total Cost: " + totalCost);
        }
    }
    public void getTotalCost(){
        System.out.println("Total Cost: " + totalCost);
    }
}
