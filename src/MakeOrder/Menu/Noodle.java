package MakeOrder.Menu;

public class Noodle extends Menu {

    public Noodle() {
    }

    public Noodle(String menu, int quantity) {
        super(menu, quantity);
    }

    @Override
    public void getMenu() {
        System.out.println("1.HIYASHI SOBA 210 Bath\n" +
                "2.ZARU SOBA 110 Bath\n" +
                "3.TEMPURA SOBA 160 Bath\n" +
                "4.PORK UDON ฿ 150 Bath\n" +
                "5.TEMPURA UDON  160 Bath\n" + "6.Back");
    }

    public double price(int num, int quantity) {
        int menuPrice[] = { 210, 110, 160, 150, 160};
        return menuPrice[num] * quantity;
    }
}
