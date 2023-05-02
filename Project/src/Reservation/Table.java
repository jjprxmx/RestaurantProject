package Reservation;

import java.util.Scanner;

public class Table {
    private int partySize;
    private int day;
    private int mount;
    private int year;
    private int course;
    private int round;
    private String chooseTable;

    public String roundTable[] = { "12.00 pm", "13.30 pm", "17.30 pm", "19.30 pm" };
    public String stRound;

    public Table() {
    };

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
        if (round == 1) {
            for (int i = 0; i < table01[course - 1].length; i++) {
                System.out.print(table01[course - 1][i] + " ");
            }
        }

        else if (round == 2) {
            for (int i = 0; i < table02[course - 1].length; i++) {
                System.out.print(table02[course - 1][i] + " ");
            }
        }

        else if (round == 3) {
            for (int i = 0; i < table03[course - 1].length; i++) {
                System.out.print(table03[course - 1][i] + " ");
            }
        }

        else if (round == 4) {
            for (int i = 0; i < table04[course - 1].length; i++) {
                System.out.print(table04[course - 1][i] + " ");
            }
        }
        System.out.println();
        // เลือกหมายเลขโต๊ะ
        System.out.println("Please select a table");
        chooseTable = scan.nextLine();
        checkTable(course, round, chooseTable); // ตัดโต๊ะที่เลือกออก
    }

    public static String[][] table01 = { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
            { "VIP Course :", "01", "02", "03", "04" } };
    public static String[][] table02 = { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
            { "VIP Course :", "01", "02", "03", "04" } };
    public static String[][] table03 = { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
            { "VIP Course :", "01", "02", "03", "04" } };
    public static String[][] table04 = { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
            { "VIP Course :", "01", "02", "03", "04" } };
    public static String[][] error = { { "error" }, { "error" } };

    // เมื่อโต๊ะถูกเลือกจะตัดเลชนั้นออกเเล้วเเทนด้วย ขีด( - )
    public static String[][] checkTable(int course, int round, String chooseTable) {
        if (round == 1) {
            for (int i = 0; i < table01[course - 1].length; i++) {
                if (table01[course - 1][i].equals(chooseTable)) {
                    table01[course - 1][i] = "-";
                }
            }

            return table01;
        }

        else if (round == 2) {
            for (int i = 0; i < table02[course - 1].length; i++) {
                if (table02[course - 1][i].equals(chooseTable)) {
                    table02[course - 1][i] = "-";
                }
            }

            return table02;
        }

        else if (round == 3) {
            for (int i = 0; i < table03[course - 1].length; i++) {
                if (table03[course - 1][i].equals(chooseTable)) {
                    table03[course - 1][i] = "-";
                }
            }

            return table03;
        }

        else if (round == 4) {
            for (int i = 0; i < table04[course - 1].length; i++) {
                if (table04[course - 1][i].equals(chooseTable)) {
                    table04[course - 1][i] = "-";
                }
            }

            return table04;
        }
        return error;
    }

    public static String[][] reTable(int round) {
        if (round == 1) {
            return table01 = new String[][] { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
                    { "VIP Course :", "01", "02", "03", "04" } };
        } else if (round == 2) {
            return table02 = new String[][] { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
                    { "VIP Course :", "01", "02", "03", "04" } };
        } else if (round == 3) {
            return table03 = new String[][] { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
                    { "VIP Course :", "01", "02", "03", "04" } };
        } else if (round == 4) {
            return table04 = new String[][] { { "NormalCourse :", "01", "02", "03", "04", "05", "06", "07", "08" },
                    { "VIP Course :", "01", "02", "03", "04" } };
        }

        return error;
    }

    public String toString() {
        return String.format(
                "username: preemSoCute Course:%s , Round: %s , Table: %s ,Party Size: %d , Date: %d / %d / %d ", course,
                stRound, chooseTable, partySize, day, mount, year);
    }

}