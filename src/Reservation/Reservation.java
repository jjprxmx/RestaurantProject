package Reservation;

import MakeOrder.Menu.Menu;
import RegisLogin.Login;

import java.util.Scanner;
import java.util.Vector;

import static MakeOrder.MakeOrder.userVector;


public class Reservation {
    public static String mR1 = "Round 1  12.00 \n";
    public static String mR2 = "Round 2  13.30 \n";
    public static String mR3 = "Round 3  17.30 \n";
    public static String mR4 = "Round 4  19.30 \n";

    public static Vector<DataReservation> dataReservations=new Vector<>();
    public static Vector<String> keepDate = new Vector<>();
    public static Vector<String[][]> ListTables = new Vector<>();
    public int index; //ตำแหน่ง add listTables

    public static String[][] temp;
    private boolean checkfirstcoure = false;
    private int number;
    private int countPeople;
    public  static boolean checkTable = true;


    public void makeReservation(Login user) {
        Time time = new Time();
        Vector<Table> tables = new Vector<>();

        int round;
        boolean chBook = true;
        boolean checkNumpeople = false;
        double bill = 0; // บิลที่ต้องจ่าย
        int day;
        int mount;
        int year;
        Scanner scanner = new Scanner(System.in);


            do {
                System.out.println(
                        "1.Normal Course\n- appetizer 2 piece\n- sushi 7\n- dish 2 piece\n- special menu 1 piece\n- soup 1 piece\n- katsutera 1 piece\n- dessert 2 piece\n price  3500/Head/course ");
                System.out.println(
                        "\n2.VIP Course\n- zensai 1 piece\n- appetizer 2 piece\n- sushi 7\n- dish 3 piece\n- special menu 1 piece\n- soup 1 piece\n- katsutera 1 piece\n- dessert 2 piece\n price  6900/Head/course ");
                System.out.print("Please select course :");
                number = scanner.nextInt(); // ประเภทคอร์สที่เลือก
                do {
                    System.out.println("For how many people?");
                    countPeople = scanner.nextInt(); // จำนวนคนที่ต้องการจอง
                    if(countPeople<=0){
                        checkNumpeople=true;
                    }
                    else { checkNumpeople=false;}
                }while (checkNumpeople);
                if (number == 1) {
                    bill = bill + (3500 * countPeople);
                    checkfirstcoure = false;
                } else if (number == 2) {
                    bill = bill + (6900 * countPeople);
                    checkfirstcoure = false;
                } else {
                    System.out.println("Please choose course 1 || 2 only !!!");
                    checkfirstcoure = true;
                }
            }while(checkfirstcoure);

            do {
                System.out.println("Please enter the date you want to reserve.");
                day = scanner.nextInt();
                System.out.println("Please enter the month you want to reserve.");
                mount = scanner.nextInt();
                System.out.println("Please enter the year you want to reserve.");
                year = scanner.nextInt();
                // ดึง method checkTime มาใช้เช็ควัน
                time.checkDate(day, mount, year);
            } while (time.checkDa);

            do {
                System.out.println("Choose the round you want to reserve.");
                System.out.println(mR1 + mR2 + mR3 + mR4);
                round = scanner.nextInt();
                time.checkTime(round);
                checkTable = true;
            } while (time.check);

                Table test = new Table(day, mount, year, number, round, countPeople);
                tables.add(test);  //**


            System.out.println("Complete Reservation.");
            System.out.println("your reservation :");

            for (Table table : tables) {
                System.out.println(table);
            }

             dataReservations.add(new DataReservation(user.getName(),number,round,test.getchooseTable(),countPeople,day, mount, year )); //String course,String round,int table,int partySize,int day,int mount,int year



    }

    /*public static void displayDataReservation() {
        System.out.println("Data Reservation");
        int i = 0;
        System.out.println("============================================");
       for (Vector<Table> tables : ) {
            System.out.println("User: " + userVector.get(i));

            i++;
            System.out.println("============================================");

        }*/

    }

