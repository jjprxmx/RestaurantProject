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
        int menuPrice[] = { 395, 270, 360, 120 };
        return menuPrice[num] * quantity;
    }
}
