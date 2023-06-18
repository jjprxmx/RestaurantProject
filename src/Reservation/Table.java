package Reservation;

import java.util.Scanner;
import java.util.Vector;

import static MakeOrder.MakeOrder.userVector;

public class Table extends Reservation{
    private int partySize;
    private int day;
    private int mount;
    private int year;
    private int course;
    private int round;
    private String chooseTable;
    public boolean checkchoose=true;
    public String roundTable[] = {"12.00 pm", "13.30 pm", "17.30 pm", "19.30 pm"};
    public String stRound;
    public static Vector<Table> tables = new Vector<>();


    public static String[][] table01 = {{"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
            {"VIP Course :", "01", "02", "03", "04"}};
    public static String[][] table02 = {{"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
            {"VIP Course :", "01", "02", "03", "04"}};
    public static String[][] table03 = {{"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
            {"VIP Course :", "01", "02", "03", "04"}};
    public static String[][] table04 = {{"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
            {"VIP Course :", "01", "02", "03", "04"}};
    public static String[][] error = {{"error"}, {"error"}};

    public boolean eiei = true;

    public Table() {
    }

    ;

    public Table(int day, int mount, int year, int course, int round, int partySize) {

        // set ค่า
        this.day = day;
        this.mount = mount;
        this.year = year;
        this.partySize = partySize;
        this.course = course;
        this.round = round;
        for (int i = 1; i <= 4; i++) {
            if (round == i) {
                stRound = roundTable[i - 1];
            }
        }

        Scanner scan = new Scanner(System.in);


            // พิมพ์หมายเลขโต๊ะ
            if (checkDateForReservationArray(day, mount, year, round) == -1) {
                if (round == 1) {
                    for (int i = 0; i < table01[course - 1].length; i++) {
                        System.out.print(table01[course - 1][i] + " ");
                    }
                } else if (round == 2) {
                    for (int i = 0; i < table02[course - 1].length; i++) {
                        System.out.print(table02[course - 1][i] + " ");
                    }
                } else if (round == 3) {
                    for (int i = 0; i < table03[course - 1].length; i++) {
                        System.out.print(table03[course - 1][i] + " ");
                    }
                } else if (round == 4) {
                    for (int i = 0; i < table04[course - 1].length; i++) {
                        System.out.print(table04[course - 1][i] + " ");
                    }
                }
            } else {
                index = checkDateForReservationArray(day, mount, year, round);
                String[][] tabletodisplay = ListTables.get(index);
                int c = 0;
                for (int i = 0; i < tabletodisplay[course - 1].length; i++) {
                    System.out.print(tabletodisplay[course - 1][i] + " ");
                    if (tabletodisplay[course - 1][i].equals("-")) {
                        c++;
                    }
                    if (c >= (tabletodisplay[course - 1].length - 1)) {
                        checkTable = false;
                        System.out.println(" \nTable not Available");
                        switch (round){
                            case 1: mR1 = "Full\n";
                                        break;
                            case 2: mR2 = "Full\n";
                                        break;
                            case 3: mR3 = "Full\n";
                                        break;
                            case 4: mR4 = "Full\n";
                                        break;
                        }
                    }
                }

            }

            do {
                System.out.println();
                // เลือกหมายเลขโต๊ะ
                System.out.println("Please select a table");
                chooseTable = scan.nextLine();
                if (course == 1) {
                    if (chooseTable.equals("01") || chooseTable.equals("02") || chooseTable.equals("03") || chooseTable.equals("04") || chooseTable.equals("05") || chooseTable.equals("06") || chooseTable.equals("07") || chooseTable.equals("08")) {
                        checkchoose = false;
                    } else {
                        System.out.println("error enter only 01 to 08");
                    }
                } else {
                    if (chooseTable.equals("01") || chooseTable.equals("02") || chooseTable.equals("03") || chooseTable.equals("04")) {
                        checkchoose = false;
                    } else {
                        System.out.println("error enter only 01 to 04");
                    }
                }

            } while (checkchoose);
            if (checkDateForReservationArray(day, mount, year, round) != -1) {
                //found same day fetch old table list
                index = checkDateForReservationArray(day, mount, year, round);
                temp = new String[][]{
                        {"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
                        {"VIP Course :", "01", "02", "03", "04"}
                };
                checkTable(course, round, chooseTable); // ตัดโต๊ะที่เลือกออก
            } else {
                AddDateForReservationArray(day, mount, year, round);
                ListTables.add(new String[][]{
                        {"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
                        {"VIP Course :", "01", "02", "03", "04"}
                });
                index = checkDateForReservationArray(day, mount, year, round);
                temp = new String[][]{
                        {"NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08"},
                        {"VIP Course :", "01", "02", "03", "04"}
                };
                checkTable(course, round, chooseTable); // ตัดโต๊ะที่เลือกออก
            }
        }


    // เมื่อโต๊ะถูกเลือกจะตัดเลชนั้นออกเเล้วเเทนด้วย ขีด( - )
    public  void checkTable(int course, int round, String chooseTable) {
            String[][] table = ListTables.get(index);
            for (int i = 0; i < table[course - 1].length; i++) {
                if (table[course - 1][i].equals(chooseTable)) {
                    table[course - 1][i] = "-";
                    ListTables.set(index, table);
                }
            }

    /*    if (round == 1) {
            for (int i = 0; i < table01[course - 1].length; i++) {
                if (table01[course - 1][i].equals(chooseTable)) {
                    table01[course - 1][i] = "-";
                }
            }

            return table01;
        } else if (round == 2) {
            for (int i = 0; i < table02[course - 1].length; i++) {
                if (table02[course - 1][i].equals(chooseTable)) {
                    table02[course - 1][i] = "-";
                }
            }

            return table02;
        } else if (round == 3) {
            for (int i = 0; i < table03[course - 1].length; i++) {
                if (table03[course - 1][i].equals(chooseTable)) {
                    table03[course - 1][i] = "-";
                }
            }

            return table03;
        } else if (round == 4) {
            for (int i = 0; i < table04[course - 1].length; i++) {
                if (table04[course - 1][i].equals(chooseTable)) {
                    table04[course - 1][i] = "-";
                }
            }

            return table04;
        }
        return error;*/
    }

//    public static String[][] reTable() {
//        ListTables = temp;
//    }
    public String toString() {
        return String.format(
                "Course:%s , Round: %s , Table: %s ,Party Size: %d , Date: %d / %d / %d ", course,
                stRound, chooseTable, partySize, day, mount, year);
    }

    public static void getTable() {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public String getchooseTable() {
        return chooseTable;
    }



    public void AddDateForReservationArray(int day, int mount, int year,int round) {
        String stringValue = String.valueOf(day) + String.valueOf(mount) + String.valueOf(year)+String.valueOf(round);
        keepDate.add(stringValue);
    }

    public int checkDateForReservationArray(int day, int mount, int year,int round) {
        String defaultValue = String.valueOf(day) + String.valueOf(mount) + String.valueOf(year)+String.valueOf(round);
        int defaultValueInt = Integer.parseInt(defaultValue);
        for (int i = 0; i < keepDate.size(); i++) {
            int keepInData = Integer.parseInt(keepDate.get(i));
            if (keepInData == defaultValueInt) {
                return i; //วันเดียวกัน
            }
        }
        return -1; //คนละวัน
    }
}