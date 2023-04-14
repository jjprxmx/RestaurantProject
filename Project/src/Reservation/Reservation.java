package Reservation;

import java.util.Scanner;
import java.util.Vector;


public class Reservation{


    public static void main() {
        Time time = new Time();
        Table tablee = new Table();
        Vector<Table> tables = new Vector<>();

        int round;
        boolean chBook=true;
        double bill = 0; // บิลที่ต้องจ่าย
        int day;
        int mount;
        int year;
        Scanner scanner = new Scanner(System.in);

        do{
        System.out.println("1.Normal Course\n- appetizer 2 piece\n- sushi 7\n- dish 2 piece\n- special menu 1 piece\n- soup 1 piece\n- katsutera 1 piece\n- dessert 2 piece\n price  3500/Head/course ");
        System.out.println("\n2.VIP Course\n- zensai 1 piece\n- appetizer 2 piece\n- sushi 7\n- dish 3 piece\n- special menu 1 piece\n- soup 1 piece\n- katsutera 1 piece\n- dessert 2 piece\n price  6900/Head/course ");
        System.out.print("Please select course :");
        int number = scanner.nextInt(); //ประเภทคอร์สที่เลือก
        System.out.println("For how many people?");
        int countPeople = scanner.nextInt(); //จำนวนคนที่ต้องการจอง

        if (number == 1) {
            bill = bill + (3500 * countPeople);
        } else if (number == 2) {
            bill = bill + (6900 * countPeople);
        } else {
            time.error();

        }

        do {
            System.out.println("Please enter the date you wish to reserve.");
            day = scanner.nextInt();
            System.out.println("Please enter the month you want to reserve.");
            mount = scanner.nextInt();
            System.out.println("Please enter the year you want to reserve.");
            year = scanner.nextInt();
            //ดึง method checkTime มาใช้เช็ควัน
            time.checkDate(day, mount, year);
        } while (time.check);

        do {
            System.out.println("Choose the round you want to reserve.");
            System.out.println("Round 1  12.00 pm\n" + "Round 2 13.30 pm\n" + "Round 3 17.30 pm\n" + "Round 4 19.30 pm");
            round = scanner.nextInt();
            time.checkTime(round);
        }while (time.check);

        tables.add(new Table(day, mount, year, number, round, countPeople));

        System.out.println("Please check your reservation");

        for (Table table : tables) {
            System.out.println(table);
        }

        System.out.print("Ok press 1 ,Rebook press 2 :");
        int checkBook = scanner.nextInt();
        if (checkBook==1){
            chBook=false;
        }
        else if (checkBook==2)
        { tablee.reTable(round);
            tables.remove(0);
        }
    }while(chBook);

       System.out.println("Complete Reservation.");






    }
}
