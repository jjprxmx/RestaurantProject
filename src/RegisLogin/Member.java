package RegisLogin;

import java.time.LocalDate;
import java.util.ArrayList;

/*
* This class storage info of member 
* and can getMember to see the the member you looking for
* but showMember similar to show all member list in readable form
*/
public class Member {
    private String name, email, password, telNum, address;

    LocalDate today = LocalDate.now();
    private int yearsOfMembership = today.getYear() - 2023; // assuming the program started in 2023

    private static ArrayList<Member> members = new ArrayList<>();
    // Create sample set of members
    static {
        members.add(new Member("John Doe", "john.doe@example.com", "password123", "123", null));
        members.add(new Member("Jane Smith", "jane.smith@example.com", "password456", "456", null));
        members.add(new Member("Bob Johnson", "bob.johnson@example.com", "password789", "789", null));
        members.add(new Member("Alice Brown", "alice.brown@example.com", "password111", "111", null));
        members.add(new Member("David Lee", "david.lee@example.com", "password222", "222", null));
        members.add(new Member("Sarah Williams", "sarah.williams@example.com", "password333", "333", null));
        members.add(new Member("Michael Davis", "michael.davis@example.com", "password444", "444", null));
        members.add(new Member("Karen Thompson", "karen.thompson@example.com", "password555", "555", null));
        members.add(new Member("Steven Miller", "steven.miller@example.com", "password666", "666", null));
        members.add(new Member("Amy Garcia", "amy.garcia@example.com", "password777", "777", null));
        members.add(new Member("p", "p", "p", "p", null));
        members.add(new Member("c", "c", "c", "c", null));
    }

    public Member(String name, String email, String password, String telNum, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telNum = telNum;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRank() {
        if (getYearsOfMembership() == 0) {
            return "Member";
        } else if (getYearsOfMembership() == 1) {
            return "A Special Member";
        } else if (getYearsOfMembership() > 1 && getYearsOfMembership() <= 3) {
            return "Our Premium Member";
        } else if (getYearsOfMembership() > 3) {
            return "VIP Customer";
        } else {
            return null;
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

    public static boolean checkMember(String email) {
        // Check if the member already exists
        for (Member member : members) {
            if (member.getEmail().equals(email)) {
                System.out.println("Member with email " + email + " already exists.");
                return true;
            }
        }
        return false;
    }

    public static void add(Member member) {
        members.add(member);
    }

    public static void showMember() {// Should be accessed only by Admin
        for (Member member : members) {
            System.out.println("Name: " + member.getName() + ", Email: " + member.getEmail() + ", TelNum: "
                    + member.getTelNum() +
                    ",Address: " + member.getAddress() + ", Years of Membership: "
                    + member.getYearsOfMembership());
        }
    }

}