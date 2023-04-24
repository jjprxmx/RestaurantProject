import Reservation.*;
import MakeOrder.*;
import RegisLogin.Login;

import java.text.ParseException;

public class App {
    public static void main(String args[]) throws ParseException {

        Login user = new Login();

        if (user != null) {
            MakeOrder.order(user);
        }

        user.getAddress();

    }
}
