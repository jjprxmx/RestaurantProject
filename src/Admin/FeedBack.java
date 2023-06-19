package Admin;

import java.util.Scanner;
import java.util.Vector;

import RegisLogin.Login;

public class FeedBack {
    public static Vector<String> feedbackVector = new Vector<>();

    public static void feedback(Login user) {
        Scanner scanner = new Scanner(System.in);

        String f = scanner.nextLine();
        feedbackVector.add(user.getName() + ": " + f);
    }

    public static void displayfeedback() {
        int i = 1;
        for (String feedBack : feedbackVector) {
            System.out.println(i + ". " + feedBack);
            i++;
        }
    }
}
