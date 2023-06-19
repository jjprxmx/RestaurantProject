package Reservation;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time {

    public static boolean check = true;
    public static boolean checkDa = true;
    public static boolean checkH = true;

    public static boolean sameday = false;

    public static void error() {
        System.out.println("error!!");
        System.out.println("please try again");
    }

    // *******เช็คว่าวันที่จองน้อยกว่าเวลาปัจจุบันของเครื่องไหม****
    public static boolean checkDate(int day, int month, int year) {
        GregorianCalendar gcalendar = new GregorianCalendar();
        int presentDay = gcalendar.get(Calendar.DATE);
        int presentMonth = gcalendar.get(Calendar.MONTH) + 1;
        int presentYear = gcalendar.get(Calendar.YEAR);

        int numMount[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0) {
            numMount[1] = 29;
        }

        if (year < presentYear || year < 0) {
            System.out.println("Invalid year. Please enter a valid year.");
            return true;
        }

        if (month > 12 || month < 0) {
            System.out.println("Invalid month. Please enter a valid month.");
            return true;
        }

        if (year == presentYear && month < presentMonth) {
            System.out.println("Invalid month. Please enter a valid month and year.");
            return true;
        }

        if (year == presentYear && month == presentMonth && day < presentDay) {
            System.out.println("Invalid day. Please enter a valid day.");
            return true;
        }

        if (day > numMount[month - 1]) {
            System.out.println("Invalid day. Please enter a valid day.");
            return true;
        }

        if (year <= presentYear && month <= presentMonth && day <= presentDay
                && gcalendar.get(Calendar.HOUR_OF_DAY) >= 19) {
            System.out.println(
                    "Your DD/MM/YY: " + day + "/" + month + "/" + year + " cannot be reserved (No available round).");
            System.out.println("Please try another date.");

            // Check if it's the same day or not
            sameday = day == presentDay;

            return true;
        }

        return false;
    }

    public static int roundTableTime[] = { (int) 12.00, (int) 13.30, (int) 17.30, (int) 19.30 };
    public static int roundTime;

    public static boolean checkTime(int round) {
        // แปลงค่า round เป็นรอบเวลา
        for (int j = 1; j <= 4; j++) {
            if (round == j) {
                roundTime = roundTableTime[j - 1];
            }
        }
        // เช็คเวลากับเครื่อง
        GregorianCalendar gcalendar = new GregorianCalendar();
        int presentHour = gcalendar.get(Calendar.HOUR_OF_DAY);

        if (roundTime <= presentHour && checkDa == true) {
            error();
            System.out.println("Please reserve 1 hour in advance.");
            return check = true;
        }
        return check = false;
    }

    public static boolean checkTimeMenu(int hour, int minute) {
        // เช็คเวลากับเครื่อง
        GregorianCalendar gcalendar = new GregorianCalendar();
        int presentHour = gcalendar.get(Calendar.HOUR_OF_DAY);
        int presentMin = gcalendar.get(Calendar.MINUTE);

        // Check same day
        if (sameday) {
            if (hour > 23 || hour < presentHour) {
                error();
                return checkH = true;
            }
            if (minute > 59 || (presentHour == hour && minute < presentMin)) {
                error();
                return checkH = true;
            }
        } else {
            // not same day
            if (hour > 24) {
                error();
                return checkH = true;
            }
            if (minute > 60) {
                error();
                return checkH = true;
            }
        }

        return checkH = false;
    }

    // For MakeOrder Only
    public static boolean checkMenuDate(int day, int mount, int year) {
        GregorianCalendar gcalendar = new GregorianCalendar();
        int presentDay = gcalendar.get(Calendar.DATE);
        int presentMount = gcalendar.get(Calendar.MONTH) + 1;
        int presentYear = gcalendar.get(Calendar.YEAR);

        int numMount[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0) {
            numMount[1] = 29;
        }

        // check
        if (year < presentYear || year < 0) {
            error();
            return checkDa = true;
        }
        if (mount > 12 || mount < 0) {
            error();
            return checkDa = true;
        }
        if (year == presentYear) {
            if (mount < presentMount) {
                error();
                return checkDa = true;
            }
            if (mount == presentMount) {
                if (day < presentDay) {
                    error();
                    return checkDa = true;
                }
            }
        }
        if (day > numMount[mount - 1]) {
            error();
            return checkDa = true;
        }

        sameday = day == presentDay;

        return checkDa = false;

    }

}
