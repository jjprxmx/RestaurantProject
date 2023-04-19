package MakeOrder.Menu;

public class Sashimi extends Menu {

    public Sashimi() {

    }

    public Sashimi(String menu, int quantity) {
        super(menu, quantity);
    }

    @Override
    public void getMenu() {
        System.out.println("1.SASHIMI LOVER  1250 Bath\n" +
                "2.MINI SASHIMI 290 Bath\n" +
                "3.SASHIMI UME 360 Bath\n" +
                "4.HAMACHI SASHIMI 370 Bath\n" +
                "5.AMAEBI SASHIMI 350 Bath\n" + "6.Back");
    }

    public double price(int num, int quantity) {
        totalPrice = 0;
        if (num == 1) {
            totalPrice = totalPrice + (1250 * quantity);

        } else if (num == 2) {
            totalPrice = totalPrice + (290 * quantity);

        } else if (num == 3) {
            totalPrice = totalPrice + (360 * quantity);

        } else if (num == 4) {
            totalPrice = totalPrice + (370 * quantity);

        } else if (num == 5) {
            totalPrice = totalPrice + (350 * quantity);

        }
        return totalPrice;
    }
}
