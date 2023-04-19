package MakeOrder.Menu;

public class SushiAndMaki extends Menu {

    public SushiAndMaki() {

    }

    public SushiAndMaki(String menu, int quantity) {
        super(menu, quantity);
    }

    @Override
    public void getMenu() {
        System.out.println("1.EXTRA TWIST ROLL(salmon rolled with scallop & eel)  395 Bath\n" +
                "2.SPIDER MAKI (soft shell crab rolls) 270 Bath\n" +
                "3.DOUBLE WAVE ROLL (salmon eel rolls) 360 Bath\n" +
                "4.FUTO MAKI (crab stick and japanese omelette rolls)    120 Bath\n" + "5.Back");
    }

    public double price(int num, int quantity) {
        totalPrice = 0;
        if (num == 1) {
            totalPrice = totalPrice + (395 * quantity);

        } else if (num == 2) {
            totalPrice = totalPrice + (270 * quantity);

        } else if (num == 3) {
            totalPrice = totalPrice + (360 * quantity);
        } else if (num == 4) {
            totalPrice = totalPrice + (120 * quantity);
        }
        return totalPrice;
    }
}
