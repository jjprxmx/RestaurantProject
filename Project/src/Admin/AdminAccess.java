package Admin;

public class AdminAccess {
    private static String PIN = "123456";

    public static boolean checkPIN(String isPIN){
        if(isPIN.equals(PIN)){
            return true;
        } else {
            return false;
        }
    }
}
