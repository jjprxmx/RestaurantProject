package MakeOrder.Menu;

public abstract class Menu {
    private String menu;
    private int quantity;
    public double totalPrice;

    public Menu() {
    }

    public Menu(String menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public abstract void getMenu();

    public double price(int num, int quantity) {
        return totalPrice;
    }

    public String toString() {
        return String.format("\n%s     %d piece  ", menu, quantity);
    }

}