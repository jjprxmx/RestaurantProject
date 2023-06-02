import Reservation.*;
import MakeOrder.*;
import RegisLogin.*;

import java.text.ParseException;
import java.util.Scanner;

import Admin.AdminAccess;

public class App {
    public static void main(String args[]) throws ParseException {

        Login user = new Login();
        Scanner scan = new Scanner(System.in);

        System.out.println("\nPlease enter your email:");
        String email = scan.nextLine();

        System.out.println("Please enter your password:");
        String password = scan.nextLine();

        user.loginAt(email, password);

        do {
            if (user != null) {
                System.out.println(
                        "What you would like to do: \n1.Order \n2.Make Reservation \n3.Admin Activate \n4.Exit");
                int c = scan.nextInt();
                switch (c) {
                    case 1:
                        MakeOrder.order(user);
                        break;
                    case 2:
                        Reservation table = new Reservation();
                        table.makeReservation();
                        break;
                    case 3:
                        System.out.println("Please entere PIN: ");
                        String PIN = scan.next();
                        if (AdminAccess.checkPIN(PIN)) {// if true
                            System.out.println("\u001B[34m Welcome Admin \u001B[0m");
                            do {
                                System.out.println("1.Show Member \n2.Show Table \n3.Show Reservation \n4.Exit");
                                int admin = scan.nextInt();
                                if (admin == 1) {
                                    Member.showMember();
                                } else if (admin == 2) {

                                } else if (admin == 3) {

                                } else if (admin == 4) {
                                    break;
                                } else {
                                    System.out.println("Please choose something we have for you.");
                                }
                            } while (true);
                        } else {
                            System.out.println("\u001B[31m You Do Not Have Permition \u001B[0m");
                        }
                        break;
                    case 4:
                        System.out.print("Bye Bye");
                        System.exit(0);// Terminate the program Super Exit!! Get Me Out Of Here
                }
            }

        } while (true);
    }
}
