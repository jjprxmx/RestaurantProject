package MakeOrder;

import Admin.FeedBack;
import MakeOrder.Menu.*;
import RegisLogin.Login;
import RegisLogin.Member;
import Reservation.Time;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class MakeOrder {
    public static Vector<Vector<Menu>> mainVector = new Vector<>();
    public static Vector<Double> totalAll = new Vector<>();
    public static Vector<String> addressVector = new Vector<>();
    public static Vector<Integer> dayVector = new Vector<Integer>();
    public static Vector<Integer> mountVector = new Vector<Integer>();
    public static Vector<Integer> yearVector = new Vector<Integer>();
    public static Vector<Integer> hourVector = new Vector<Integer>();
    public static Vector<Integer> minuteVector = new Vector<Integer>();




    public static void order(Login user) {
        Calendar calendar = Calendar.getInstance();
        Vector<Menu> menus = new Vector<>();
        Vector<Integer> dayV = new Vector<>();
        Vector<Integer> mountV = new Vector<>();
        Vector<Integer> yearV = new Vector<>();



        Noodle noodle = new Noodle();
        Rice rice = new Rice();
        Sashimi sashimi = new Sashimi();
        SushiAndMaki sushisuhi = new SushiAndMaki();
        Time time = new Time();
        double totalPrice = 0;

        boolean checkMemu = true;
        boolean check = true;
        boolean typee = true;
        int item;
        int quantity = 1;
        //double totalPrice = 0;
        int day;
        int mount;
        int year;
        int sentHour;
        int sentMinute;

        String[] noodles = { "- HIYASHI SOBA 210 Bath", "- ZARU SOBA 110 Bath", "- TEMPURA SOBA 160 Bath",
                "- PORK UDON 150 Bath", "- TEMPURA UDON  160 Bath", "  " };
        String[] rices = { "- Pork Pirikara don 220 Bath", "- Tonkatsu Kare rice 180 Bath",
                "- Gyu Yakiniku Don 240 Bath", "- Tori Karaage Kare Rice 140 Bath" };
        String[] sashimii = { "- SASHIMI LOVER  1250 Bath", "- MINI SASHIMI 290 Bath", "- SASHIMI UME 360 Bath",
                "- HAMACHI SASHIMI 370 Bath", "- AMAEBI SASHIMI 350 Bath" };
        String[] sushi = { "- EXTRA TWIST ROLL(salmon rolled with scallop & eel)  395 Bath",
                "- SPIDER MAKI (soft shell crab rolls) 270 Bath\n", "- DOUBLE WAVE ROLL (salmon eel rolls) 360 Bath\n",
                "- FUTO MAKI (crab stick and japanese omelette rolls) " };

        Scanner scanner = new Scanner(System.in);
        do {
            do {
                System.out.println("Please select type of menu");
                System.out.println("1.Noodle\n2.Rice\n3.Sashimi\n4.Sushi and Maki\n5.Promotion\n6.exit ");
                System.out.print("type: ");
                int type = scanner.nextInt();
                if (type == 1) {
                    do {
                        check = true;
                        noodle.getMenu();
                        System.out.println("Please select the item you want.");
                        item = scanner.nextInt();

                        if (item >= 1 && item <= 5) {
                            System.out.println("Quantity: ");
                            quantity = scanner.nextInt();

                            menus.add(new Noodle(noodles[item - 1], quantity));
                            totalPrice = totalPrice + noodle.price(item - 1, quantity);

                        } else if (item == 6) {
                            check = false;
                        }

                    } while (check);

                } else if (type == 2) {
                    do {
                        check = true;
                        rice.getMenu();
                        System.out.println("Please select the item you want.");
                        item = scanner.nextInt();

                        if (item >= 1 && item <= 4) {
                            System.out.println("Quantity: ");
                            quantity = scanner.nextInt();

                            menus.add(new Rice(rices[item - 1], quantity));
                            totalPrice = totalPrice + rice.price(item - 1, quantity);

                        } else if (item == 5) {
                            check = false;
                        }
                    } while (check);

                } else if (type == 3) {
                    do {
                        check = true;
                        sashimi.getMenu();
                        System.out.println("Please select the item you want.");
                        item = scanner.nextInt();
                        if (item >= 1 && item <= 5) {
                            System.out.println("Quantity: ");
                            quantity = scanner.nextInt();

                            menus.add(new Sashimi(sashimii[item - 1], quantity));
                            totalPrice = totalPrice + sashimi.price(item - 1, quantity);

                        } else if (item == 6) {
                            check = false;
                        }

                    } while (check);

                } else if (type == 4) {
                    do {
                        check = true;
                        sushisuhi.getMenu();
                        System.out.println("Please select the item you want.");
                        item = scanner.nextInt();
                        if (item >= 1 && item <= 4) {
                            System.out.println("Quantity: ");
                            quantity = scanner.nextInt();

                            menus.add(new SushiAndMaki(sushi[item - 1], quantity));
                            totalPrice = totalPrice + sushisuhi.price(item - 1, quantity);

                        } else if (item == 5) {
                            check = false;
                        }

                    } while (check);
                }
                if (type == 6) {
                    typee = false;
                }

            } while (typee);

            System.out.println("Please check your menu.");
            System.out.print("menu :");
            for (Menu menu : menus) {
                System.out.print(menu);
            }
            System.out.println();
            System.out.print("Total :" + totalPrice + " Bath");
            System.out.println();

            System.out.print("Ok press 1 ,Clear list press 2 :");
            int checklist = scanner.nextInt();
            if (checklist == 1) {
                checkMemu = false;
            } else if (checklist == 2) {
                menus.clear();
                totalPrice = 0;
                checkMemu = true;
            }

        } while (checkMemu);
        scanner.nextLine();
        // กรอกที่อยู่ที่จะส่ง
        System.out.println("Please fill in the address you want to ship to.");
        String address = scanner.nextLine();
        System.out.println("Want to set it as a default sending address? if Yes press 1,No press 2 ");
        int defaultAddress = scanner.nextInt();
        if (defaultAddress == 1) {
            // ดึงไปเก็บข้อมูลในอัลเรย์
            user.setDefaultAddress(address);
        }

        // ใส่เวลาส่ง
        System.out.println("Want to send it today? if Yes press 1,No press 2 ");
        int sentToday = scanner.nextInt();
        if (sentToday == 2) {
            do {
                System.out.println("Please enter the date you wish to send.");
                day = scanner.nextInt();
                System.out.println("Please enter the month you want to send.");
                mount = scanner.nextInt();
                System.out.println("Please enter the year you want to send.");
                year = scanner.nextInt();
                // ดึง method checkTime มาใช้เช็ควัน
                time.checkDate(day, mount, year);
                dayV.add(day);mountV.add(mount);yearV.add(year);
                dayVector.add(day);
                mountVector.add(mount);
                yearVector.add(year);




            } while (time.checkDa);
        }
        int x = calendar.get(Calendar.DAY_OF_MONTH);
        int y = calendar.get(Calendar.MONTH) + 1;
        int z = calendar.get(Calendar.YEAR);
        dayVector.add(x);
        mountVector.add(y);
        yearVector.add(z);




        System.out.println("Want it sent immediately?? if Yes press 1,No press 2 ");
        int sentTime = scanner.nextInt();
        if (sentTime == 2) {
            do {
                System.out.println("Please enter the time you wish to send. (hour)");
                sentHour = scanner.nextInt();

                System.out.println("Please enter the time you wish to send.(minute)");
                sentMinute = scanner.nextInt();
                time.checkTimeMenu(sentHour, sentMinute);
                hourVector.add(sentHour);
                minuteVector.add(sentMinute);
            } while (time.checkH);
        }
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        hourVector.add(hour);
        minuteVector.add(minute);



        // เลือกการชำระ
        System.out.println("Please select payment method");
        System.out.println("1.Cash");
        System.out.println("2.Bank Account");
        int payment = scanner.nextInt();
        if (payment == 1) {
            System.out.println("Thank you for using the service.  The shop will deliver food as quickly as possible.");
        } else {
            System.out.println("Please transfer money to this account number.");
            System.out.println("Bank: Thai Thai \naccount number :1235478xxx");
            System.out.println();
            System.out.println();
            System.out.println("The shop has received the money.\n The shop will deliver food as quickly as possible.");
        }
        System.out.println("Would you like to give us to feedback");
        System.out.println("1.Yes");
        System.out.println("2.No");
        int feed = scanner.nextInt();
        if (feed == 1){
            System.out.print("feedback : ");
            FeedBack.feedback();
        }
        totalAll.add(totalPrice);
        mainVector.add(menus);
        addressVector.add(address);



    }
    public static void displayMenuAndTotal() {
        System.out.println("All menus");
        int i = 0;
        System.out.println("============================================");
        for (Vector<Menu> menu : mainVector) {
            System.out.println("User: ");
            System.out.println("Address : "+addressVector.get(i));
            System.out.println("Date : "+dayVector.get(i)+"-"+mountVector.get(i)+"-"+yearVector.get(i));
            System.out.println("Time : "+hourVector.get(i)+":"+minuteVector.get(i));
            System.out.println("Bill");
            for (Menu item : menu){
                System.out.print(item);
            }
            System.out.println("\nTotal: "+totalAll.get(i) +" Bath");
            i++;
            System.out.println("============================================");

        }
    }





}
