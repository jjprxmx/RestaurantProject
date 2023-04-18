package RegisLoginJframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public Login() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        emailLabel = new JLabel("Email:");
        add(emailLabel);

        emailTextField = new JTextField();
        add(emailTextField);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailTextField.getText();
            String password = new String(passwordField.getPassword());

            Member member = Member.getMember(email, password);

            if (member == null) {
                JOptionPane.showMessageDialog(this, "Invalid email or password");
            } else {
                JOptionPane.showMessageDialog(this, "Welcome, " + member.getName() + "!");
                // redirect to dashboard
            }
        } else if (e.getSource() == registerButton) {
            Register register = new Register();
            dispose();
        }
    }
}
