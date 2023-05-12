public class Payment {

    private double cash;
    private double amount;

    private double change;
    private ShoppingCart cart;
    private boolean flag = true;

    public Payment(double cash) {
        this.amount = cart.totalCost;
        this.cash = cash;
    }

    public double getAmount() {
        return amount;
    }

    public boolean deductAmount() {
        change = cash - getAmount();
        return (change >= 0);
    }
public boolean getFlag(){
        return flag;
}
    public boolean pay() {
        if (change >= 0) {
            System.out.println("You paid: " + cash + " and change: " + change);
            System.out.println("Successful Cash Payment");
            flag = true;
            return true;

        }else{
            System.out.println("You paid: " + cash + " but required amount is: " + getAmount());
            System.out.println( "Unsuccessful Cash Payment");
            flag = false;
            return false;
        }
    }
}
