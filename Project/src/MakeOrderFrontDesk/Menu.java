package MakeOrderFrontDesk;

import java.util.Scanner;

import RegisLogin.Login;

public class Menu {
    public void startOrder(Login user) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;

        System.out.println("Please select your menu type:");
        System.out.println("1. Regular menu");
        System.out.println("2. Course menu");
        int menuType = scanner.nextInt();

        // Handle Regular Menu
        if (menuType == 1) {
            System.out.println("Please choose a dish:");
            System.out.println("1.Pork Pirikara don 220 baht");
            System.out.println("2.Tonkatsu Kare rice 180 baht");
            System.out.println("3.Gyu Yakiniku Don 240 baht");
            System.out.println("4.Tori karaage Kare Rice 140 baht");
            System.out.println("5.Hiyashi soba 210 baht");
            System.out.println("6.Zaru soba 160 baht");
            System.out.println("7.Tempura soba 160 baht");
            System.out.println("8.Pork udon 150 bath");
            System.out.println("9.Tempura udon 160 bath");
            System.out.println("10.Extra twist roll(salmon rolled with scallop & eel) 395 baht");
            System.out.println("11.Spider maki (soft shell crab rolls) 270 bath");
            System.out.println("12.Double wave roll(salmon eel rolls) 360 bath");
            System.out.println("13.Futo maki (crab stick and japanese omelette rolls) 120 baht");
            System.out.println("14.Sashimi Lover 1250 bath");
            System.out.println("15.Mini Sashimi 290 bath");
            System.out.println("16.Sashimi ume 360 bath");
            System.out.println("17.Hamachi Sashimi 370 bath");
            System.out.println("18.Amaebi Sashimi 350 bath");
            int dish = scanner.nextInt();

            switch (dish) {
                case 1:
                    total += 220;
                    System.out.println("You chose Pork Pirikara don 220 baht");
                    break;
                case 2:
                    total += 180;
                    System.out.println("You chose Tonkatsu Kare rice 180 baht");
                    break;
                case 3:
                    total += 70;
                    System.out.println("You chose Gyu Yakiniku Don 240 baht");
                    break;
                case 4:
                    total += 140;
                    System.out.println("You chose Tori karaage Kare Rice 140 baht");
                    break;
                case 5:
                    total += 210;
                    System.out.println("You chose Hiyashi soba 210 baht");
                    break;
                case 6:
                    total += 160;
                    System.out.println("You chose Zaru soba 160 baht");
                    break;
                case 7:
                    total += 160;
                    System.out.println("You chose Tempura soba 160 baht");
                    break;
                case 8:
                    total += 150;
                    System.out.println("You chose Pork udon 150 bath");
                    break;
                case 9:
                    total += 160;
                    System.out.println("You chose Tempura udon 160 bath");
                    break;
                case 10:
                    total += 395;
                    System.out.println("You chose Extra twist roll(salmon rolled with scallop & eel) 395 baht");
                    break;
                case 11:
                    total += 270;
                    System.out.println("You chose Spider maki (soft shell crab rolls) 270 bath");
                    break;
                case 12:
                    total += 360;
                    System.out.println("You chose Double wave roll(salmon eel rolls) 360 bath");
                    break;
                case 13:
                    total += 120;
                    System.out.println("You chose Futo maki (crab stick and japanese omelette rolls) 120 baht");
                    break;
                case 14:
                    total += 1250;
                    System.out.println("You chose Sashimi Lover 1250 bath");
                    break;
                case 15:
                    total += 290;
                    System.out.println("You chose Mini Sashimi 290 bath");
                    break;
                case 16:
                    total += 360;
                    System.out.println("You chose Sashimi ume 360 bath");
                    break;
                case 17:
                    total += 370;
                    System.out.println("You chose Hamachi Sashimi 370 bath");
                    break;
                case 18:
                    total += 350;
                    System.out.println("You chose Amaebi Sashimi 350 bath");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;

            }
        } else if (menuType == 2) {
            System.out.println("Please choose a course type:");
            System.out.println(
                    "1. Normal Course (appetizer 2,sushi 7,dish,2,special menu 1,soup 1, katsutera 1,desseert 2 ราคา 3500 baht)");
            System.out.println(
                    "2. VIP Course (zensai 1, appetizer 2,sushi 7, dish 3, special menu 1, soup 1, katsutera 1,dessert 2 ราคา 6900 baht)");

            int courseType = scanner.nextInt();

            switch (courseType) {
                case 1:
                    total += 3500;
                    System.out.println("You chose Normal Course (3500 Baht)");
                    break;
                case 2:
                    total += 6900;
                    System.out.println("You chose VIP Course (6900 Baht)");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } else {
            System.out.println("Invalid menu type selected. Please try again.");
        }

        System.out.println("Total: " + total + " Baht");
    }
}
