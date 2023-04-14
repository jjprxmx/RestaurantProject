package MakeOrder.Menu;

public class Noodle extends Menu {

    public Noodle() {
    }

    public Noodle(String menu,int quantity) {
        super(menu,quantity);
    }

    @Override
    public void getMenu() {
        System.out.println("1.HIYASHI SOBA 210 Bath\n" +
                "2.ZARU SOBA 110 Bath\n" +
                "3.TEMPURA SOBA 160 Bath\n" +
                "4.PORK UDON ฿ 150 Bath\n" +
                "5.TEMPURA UDON  160 Bath\n"+"6.Back");
    }


    public double price(int num,int quantity) {
        totalPrice=0;

        if(num==1) {
            totalPrice=totalPrice+(210*quantity);

        }
        else if(num==2) {
            totalPrice=totalPrice+(110*quantity);

        }
        else if(num==3) {
            totalPrice=totalPrice+(160*quantity);

        }
        else if(num==4) {
            totalPrice=totalPrice+(150*quantity);

        }
        else if(num==5) {
            totalPrice=totalPrice+(160*quantity);

        }
        return totalPrice;
    }
}
