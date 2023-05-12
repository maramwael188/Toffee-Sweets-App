import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Order> orders;
    private String customerName;
    private String customerAddress;
    private int customerPhone;
    private boolean orderPlaced;
    private boolean orderDelivered;
    private ShoppingCart Cart;
    private Payment payment;
    private int orderID = 0;
    private boolean orderStatus = true;

    public Order(ShoppingCart cart){
        this.Cart = cart;

    }
    public Order(String customerName, String customerAddress, int customerPhone, ShoppingCart Cart) {
        this.Cart = Cart;
        this.orderPlaced = true;
        //this.orderDelivered = false;
        this.orderID += 1;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.orders = new ArrayList<Order>();
    }

    public void makeOrder() {
        if (Cart.cart.isEmpty()) {
            System.out.println("Cannot place an empty order.");
            return;
        }

        if (orderPlaced) {
            System.out.println("An order is already placed and pending delivery.");
            return;
        }

        System.out.println("Placing order...");
        orderPlaced = true;
        System.out.println("Order placed successfully. Total cost: $" + Cart.totalCost);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        customerName = scanner.nextLine();
        System.out.println("Enter your address:");
        customerAddress = scanner.nextLine();
        System.out.println("Enter your phone number:");
        customerPhone = scanner.nextInt();
        System.out.println(customerName + ", Your order will be delivered to " + customerAddress + " and you will be contacted at " + customerPhone + " when it arrives.");
        Order order = new Order(customerName, customerAddress, customerPhone, Cart);
        orders.add(order);
    }

  /*      while (!orderDelivered) {
            System.out.println("Enter 'delivered' when your order has been delivered:");
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            if (input.equalsIgnoreCase("delivered")) {
                orderDelivered = true;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }*/
    public void getOrders(){
        for (Order order : orders) {
            System.out.println("Name: " + customerName);
            System.out.println("Address " + customerAddress);
            System.out.println("Phone " + customerPhone);
            Cart.displayCart();
        }
    }
        public void closedOrder(){
            if (orderStatus) {
                if (payment.pay()) {
                    orderStatus = false;
                    System.out.println("Thank you for your order!");
                }
                else{
                    System.out.println("Order can't be closed!");
                }
            }
        }
 }