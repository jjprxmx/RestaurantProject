package RegisLogin;

import java.time.LocalDate;
import java.util.ArrayList;

/*
* This class storage info of member 
* and can getMember to see the the member you looking for
* but showMember similar to show all member list in readable form
*/
class Member {
    private String name, email, password, telNum;

    LocalDate today = LocalDate.now();
    private int yearsOfMembership = today.getYear() - 2023; // assuming the program started in 2023

    private static ArrayList<Member> members = new ArrayList<>();
    // Create sample set of members
    static {
        members.add(new Member("John Doe", "john.doe@example.com", "password123", "123"));
        members.add(new Member("Jane Smith", "jane.smith@example.com", "password456", "456"));
        members.add(new Member("Bob Johnson", "bob.johnson@example.com", "password789", "789"));
        members.add(new Member("Alice Brown", "alice.brown@example.com", "password111", "111"));
        members.add(new Member("David Lee", "david.lee@example.com", "password222", "222"));
        members.add(new Member("Sarah Williams", "sarah.williams@example.com", "password333", "333"));
        members.add(new Member("Michael Davis", "michael.davis@example.com", "password444", "444"));
        members.add(new Member("Karen Thompson", "karen.thompson@example.com", "password555", "555"));
        members.add(new Member("Steven Miller", "steven.miller@example.com", "password666", "666"));
        members.add(new Member("Amy Garcia", "amy.garcia@example.com", "password777", "777"));
    }

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
            System.out.println("Member");
        } else if (getYearsOfMembership() == 1) {
            System.out.println("A Special Member");
        } else if (getYearsOfMembership() > 1 && getYearsOfMembership() <= 3) {
            System.out.println("Our Premium Member");
        } else if (getYearsOfMembership() > 3) {
            System.out.println("VIP Customer");
        } else {
            System.out.println("invaild year");
        }
    }

    public static Member getMember(String email, String password) {
        for (Member member : members) {
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                return member;
            }
        }
        return null;
    }

    public static void checkMember(String email) {
        // Check if the member already exists
        for (Member member : members) {
            if (member.getEmail().equals(email)) {
                System.out.println("Member with email " + email + " already exists.");
            } else {
                System.out.println("Member with email " + email + " already exists.");
            }
        }
    }

    public static void add(Member member) {
        members.add(member);
    }

    public static void showMember() {//Should be access only by Admin
        for (Member member : members) {
            System.out.println("Name: " + member.getName() + ", Email: " + member.getEmail() + ", TelNum: " + member.getTelNum() + ", Years of Membership: " + member.getYearsOfMembership());
        }
    }
    
}