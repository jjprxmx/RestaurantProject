package MakeOrder.Menu;

public class Rice extends Menu{


    public Rice() {

    }
    public Rice(String menu,int quantity) {
        super(menu,quantity);
    }

    @Override
    public void getMenu() {
        System.out.println("1.Pork Pirikara don 220 Bath\n" +
                "2.Tonkatsu Kare rice 180 Bath\n" +
                "3.Gyu Yakiniku Don 240 Bath\n" +
                "4.Tori Karaage Kare Rice 140 Bath\n"+"5.Back");
    }


    public double price(int num,int quantity) {
        totalPrice=0;
        if(num==1) {
            totalPrice=totalPrice+(220*quantity);

        }
        else if(num==2) {
            totalPrice=totalPrice+(180*quantity);

        }
        else if(num==3) {
            totalPrice=totalPrice+(240*quantity);

        }
        else if(num==4) {
            totalPrice=totalPrice+(140*quantity);

        }
        return totalPrice;
    }
}
