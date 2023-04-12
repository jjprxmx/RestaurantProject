package RegisLogin;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * import this class if you to use in Main class
 * Login class will check wheter that user have account or not
 * if not user will need to input 'y' to create new account
 */
public class Login {
    Scanner scanner = new Scanner(System.in);
    private static ArrayList<Member> members = new ArrayList<>();

    public void loginAt(String email, String password) {
        System.out.println("\nPlease enter your email:");
        email = scanner.nextLine();

        System.out.println("Please enter your password:");
        password = scanner.nextLine();

        Member member = Member.getMember(email, password, members);

        // Don't have an account
        if (member == null) {
            System.out.println("Invalid email or password. Register enter 'y' ");
            String y = scanner.nextLine();

            if (y.equals('y')) {
                // User create new acount
                Register newUser = new Register();

                System.out.println("\nPlease enter your name:");
                String name = scanner.nextLine();

                System.out.println("Please enter your email:");
                email = scanner.nextLine();

                System.out.println("Please enter your password:");
                password = scanner.nextLine();

                System.out.println("Please enter your password:");
                String telNum = scanner.nextLine();

                newUser.registerAt(name, email, password, telNum, members);
                // Successful create new account
                System.out.println("\nSuccessfully create new account!");
            }

        } else {
            // Successful login
            System.out.println("\nWelcome, " + member.getName() + "!");
            System.out.println("Your membership rank is: " + member);
        }
    }
}
