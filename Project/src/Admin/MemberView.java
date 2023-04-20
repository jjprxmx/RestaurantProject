package RegisLogin;

import static RegisLogin.Member.getMember;

public class MemberView extends Login{
    public static void main(String args[]) {
        Login login = new Login();
        Member member = getMember(login.email, login.password);
        System.out.println("Name: " + member.getName());
        System.out.println("Email: " + member.getEmail());
        System.out.println("Rank: " + member.getRank());

    }
}
