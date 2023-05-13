import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    protected ArrayList<Order> orders;

    private boolean orderPlaced;
   // private boolean orderDelivered;
    private ShoppingCart Cart;
    private Payment payment;
    private Customer customer;
    private int orderID = 0;
    private boolean orderStatus = true;
    public Order(ShoppingCart Cart, Customer customer) {
        this.Cart = Cart;
        this.customer = customer;
        this.orderPlaced = false;
        //this.orderDelivered = false;
        this.orders = new ArrayList<>();
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
        String customerName = scanner.nextLine();
        customer.setCustomerName(customerName);
        System.out.println("Enter your address:");
        String customerAddress = scanner.nextLine();
        customer.setCustomerAddress(customerAddress);
        System.out.println("Enter your phone number:");
        int customerPhone = scanner.nextInt();
        orderID += 1;
        customer.setCustomerPhone(customerPhone);
        System.out.println("Your order ID is: " + orderID);
        System.out.println(customer.getCustomerName() + ", Your order will be delivered to " +customer.getCustomerAddress() + " and you will be contacted at " + customer.getCustomerPhone() + " when it arrives.");
       // Order order = new Order(Cart, customer);
       // orders.add(order);
        orderPlaced = false;
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
        public void closedOrder(Payment payment){
            if (orderStatus) {
                if (payment.getFlag()) {
                    orderStatus = false;
                    System.out.println("Thank you for your order!");
                    Order order = new Order(Cart, customer);
                    orders.add(order);
                    Cart.emptyCart();
                }
                else{
                    System.out.println("Order can't be closed!");
                }
            }
            orderStatus = true;
        }
        public boolean getOrderStatus(){
            return orderPlaced;
        }

    public void viewOrders(){
        for (Order order : orders) {
            System.out.println("Order ID: " + orderID);
            System.out.println("Name: " + customer.getCustomerName());
            System.out.println("Address: " + customer.getCustomerAddress());
            System.out.println("Phone: " + customer.getCustomerPhone());
            Cart.displayCart();
        }
    }
 }