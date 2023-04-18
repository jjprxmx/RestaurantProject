package RegisLoginJframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel telNumLabel;
    private JTextField telNumTextField;
    private JButton registerButton;

    public Register() {
        setTitle("Register");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        nameLabel = new JLabel("Name:");
        add(nameLabel);

        nameTextField = new JTextField();
        add(nameTextField);

        emailLabel = new JLabel("Email:");
        add(emailLabel);

        emailTextField = new JTextField();
        add(emailTextField);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        telNumLabel = new JLabel("Tel Number:");
        add(telNumLabel);

        telNumTextField = new JTextField();
        add(telNumTextField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String password = new String(passwordField.getPassword());
            String telNum = telNumTextField.getText();
    
            if (Member.checkMember(email)) {
                JOptionPane.showMessageDialog(this, "Email already exists.");
            } else {
                Member.add(new Member(name, email, password, telNum));
                JOptionPane.showMessageDialog(this, "Successfully created new account!");
                
                // Create a new instance of the LoginFrame class
                Login login = new Login();
                login.setVisible(true);
                
                // Dispose of the current RegisterFrame instance
                dispose();
            }
        }
    }
    
}
