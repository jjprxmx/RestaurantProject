package RegisLogin;

import java.util.Scanner;

/*
 * This class will ask user to fill all info
 * Then check if that email already exist
 * if so, will return 
 */
public class Register {
    Scanner scanner = new Scanner(System.in);

    public void register() {
        System.out.print("Register section.");
        System.out.println("\nPlease enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your email:");
        String email = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        System.out.println("Please enter your number:");
        String telNum = scanner.nextLine();

        registerAt(name, email, password, telNum);
    }

    public void registerAt(String name, String email, String password, String telNum) {

        if (!Member.checkMember(email)) {
            // Create new account
            Member.add(new Member(name, email, password, telNum, null));
            System.out.println("Member with email " + email + " has been added.");
            // Successful create new account
            System.out.println("\nSuccessfully create new account!");
        }

    }

}
