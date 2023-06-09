package RegisLogin;

import java.util.Scanner;

/*
 * This class will ask you to input email and password to login
 * if invalid or don't have ID
 * will ask user to press 1 if want to register
 * if not program ended
 */
public class Login {
    Scanner scanner = new Scanner(System.in);
   public static Member member;

    public boolean loginAt(String email, String password) {

        member = Member.getMember(email, password);

        // Don't have an account
        if (member == null) {
            System.out.println("Invalid email or password. Register enter '1' ");
            int y = scanner.nextInt();

            if (y == 1) {
                // User create new account
                Register newUser = new Register();
                newUser.register();
            }
            return false;
        } else {
            // Successful login
            // Redirect to regular user dashboard
            System.out.println("\nWelcome, " + member.getName() + "!");
            System.out.println("Your membership rank is: " + member.getRank());
            // code to redirect to regular user dashboard
            return true;
        }
    }

    /*public void setDefaultAddress(String address) {
        Member.setAddress(address);
    }*/

    public String getAddress() {
        return member.getAddress();
    }

    public void setAddress(String address) {
        member.setAddress(address);
    }

    public Member userInfo(){
        return member;
    }

    public String getName(){return member.getName();}

}
