package RegisLogin;

import java.time.LocalDate;
import java.util.ArrayList;

/*
* This class storage info of member 
* and can getMember to see the the member you looking for
*/
class Member {
    private String name, email, password, telNum;

    LocalDate today = LocalDate.now();
    private int yearsOfMembership = today.getYear() - 2023; // assuming the program started in 2023

    public Member(String name, String email, String password, String telNum) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telNum = telNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String getPassword() {// Can't accessed outside this class
        return password;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public String getTelNum() {
        return telNum;
    }

    public void getRank() {
        if (getYearsOfMembership() == 0) {
            System.out.print("You are a Member");
        } else if (getYearsOfMembership() == 1) {
            System.out.print("You are a Special Member");
        } else if (getYearsOfMembership() > 1 && getYearsOfMembership() <= 3) {
            System.out.print("You are our Premium Member");
        } else if (getYearsOfMembership() > 3) {
            System.out.print("You are a VIP");
        } else {
            System.out.print("invaild year");
        }
    }

    public static Member getMember(String email, String password, ArrayList<Member> members) {
        for (Member member : members) {
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                System.out.println(member);
                return member;
            }
        }
        return null;
    }
}