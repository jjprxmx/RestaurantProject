import Admin.AdminAccess;
import MakeOrder.MakeOrder;
import MakeOrderFrontDesk.Menu;
import Reservation.Reservation;
import Reservation.Table;
import RegisLogin.Login;
import RegisLogin.Member;
import RegisLogin.Register;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Vector;

import static Admin.FeedBack.displayfeedback;
import static MakeOrder.MakeOrder.displayMenuAndTotal;
import static MakeOrder.MakeOrder.userVector;

public class App extends Table {
    public static void main(String args[]) throws ParseException {
        boolean isUserLoggedIn = false;
        boolean isAdminLoggedIn = false;
        boolean isUserLoggedOut = false;
        Login user = new Login();
        Scanner scan = new Scanner(System.in);

        while (true) {

            do {
                isUserLoggedOut = false;
                System.out.println("Welcome to our restaurant!");
                System.out.println("1. Login");
                System.out.println("2. Register");
                int choice = scan.nextInt();

                if (choice == 2) {
                    Register newUser = new Register();
                    newUser.register();
                }

                System.out.println("Welcome to the login section.");
                System.out.println("Please enter your email:");
                String email = scan.next();

                System.out.println("Please enter your password:");
                String password = scan.next();

                isUserLoggedIn = user.loginAt(email, password);

            } while (!isUserLoggedIn);

            do {
                if (user != null) {
                    System.out.println("What would you like to do: ");
                    System.out.println("1. Order");
                    System.out.println("2. Order Online");
                    System.out.println("3. Make Reservation");
                    System.out.println("4. Admin Access");
                    System.out.println("5. Logout");
                    System.out.println("6. Exit");

                    int choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            Menu menu = new Menu();
                            menu.startOrder(user);
                            break;
                        case 2:
                            MakeOrder.order(user);
                            break;
                        case 3:
                            Reservation table = new Reservation();
                            table.makeReservation(user);
                            break;
                        case 4:
                            System.out.println("Please enter the PIN: ");
                            String PIN = scan.next();
                            if (AdminAccess.checkPIN(PIN)) {
                                isAdminLoggedIn = true;
                                System.out.println("\u001B[34mWelcome Admin\u001B[0m");
                            } else {
                                System.out.println("\u001B[31mYou Do Not Have Permission\u001B[0m");
                            }
                            break;
                        case 5:
                            isUserLoggedOut = true;
                            System.out.println("Logged out successfully.");
                            break;
                        case 6:
                            System.out.println("Exiting the program...");
                            return; // Exit the program
                        default:
                            System.out.println("Please choose a valid option.");
                    }

                    if (isAdminLoggedIn) {
                        do {
                            System.out.println("\n1. Show Member");
                            System.out.println("2. Show Reservation Table");
                            System.out.println("3. Order View");
                            System.out.println("4. Feedback");
                            System.out.println("5. Exit Admin Access");
                            int adminChoice = scan.nextInt();

                            switch (adminChoice) {
                                case 1:
                                    Member.showMember();
                                    break;
                                case 2:
                                    for (int i = 0; i < Reservation.dataReservations.size(); i++) {
                                        System.out.println(Reservation.dataReservations.get(i));
                                    }
                                    break;
                                case 3:
                                    displayMenuAndTotal();
                                    break;
                                case 4:
                                    displayfeedback();
                                    break;
                                case 5:
                                    isAdminLoggedIn = false;
                                    break;
                                default:
                                    System.out.println("Please choose a valid option.");
                            }
                        } while (isAdminLoggedIn);
                    }

                    if (isUserLoggedOut) {
                        isUserLoggedIn = false;
                        scan.nextLine();
                    }
                }

            } while (isUserLoggedIn);

        }

    }
}
