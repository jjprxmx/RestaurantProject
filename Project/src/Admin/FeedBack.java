package Admin;

import java.util.Scanner;
import java.util.Vector;


public class FeedBack {
    public static Vector<String> feedbackVector = new Vector<>();

    public static void feedback(){
        Scanner myObj = new Scanner(System.in);


        String f = myObj.nextLine();
        feedbackVector.add(f);
    }

    public static void displayfeedback(){
        int i = 1;
        for (String feedBack : feedbackVector) {
            System.out.println(i+". "+feedBack);
            i++;
        }
    }
}
