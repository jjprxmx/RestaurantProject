package RegisLogin;

import java.util.ArrayList;

/*
 * This class need to be access only through login class
 * also this class will create new set of members in test case
 * registerAt will check if the account already exist
 * if not will create new account
 */
public class Register {

    // Create sample set of members
    static {
        ArrayList<Member> members = new ArrayList<>();
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

    public void registerAt(String name, String email, String password, String telNum, ArrayList<Member> members) {

        // Check if the member already exists
        for (Member member : members) {
            if (member.getEmail().equals(email)) {
                System.out.println("Member with email " + email + " already exists.");
                return;
            }
        }

        // Create new account
        members.add(new Member(name, email, password, telNum));
        System.out.println("Member with email " + email + " has been added.");

    }

}
