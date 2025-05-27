import javax.swing.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    JTextField tfUsername, tfPhone, tfDOB, tfEmail;
    JPasswordField pfPassword;
    JButton btnRegister;

    public RegistrationForm() {
        setTitle("User Registration");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbl1 = new JLabel("Username");
        JLabel lbl2 = new JLabel("Phone");
        JLabel lbl3 = new JLabel("DOB");
        JLabel lbl4 = new JLabel("Email");
        JLabel lbl5 = new JLabel("Password");

        tfUsername = new JTextField();
        tfPhone = new JTextField();
        tfDOB = new JTextField();
        tfEmail = new JTextField();
        pfPassword = new JPasswordField();
        btnRegister = new JButton("Register");

        lbl1.setBounds(10, 10, 80, 25);
        tfUsername.setBounds(100, 10, 150, 25);

        lbl2.setBounds(10, 40, 80, 25);
        tfPhone.setBounds(100, 40, 150, 25);

        lbl3.setBounds(10, 70, 80, 25);
        tfDOB.setBounds(100, 70, 150, 25);

        lbl4.setBounds(10, 100, 80, 25);
        tfEmail.setBounds(100, 100, 150, 25);

        lbl5.setBounds(10, 130, 80, 25);
        pfPassword.setBounds(100, 130, 150, 25);

        btnRegister.setBounds(100, 170, 100, 30);

        add(lbl1); add(tfUsername);
        add(lbl2); add(tfPhone);
        add(lbl3); add(tfDOB);
        add(lbl4); add(tfEmail);
        add(lbl5); add(pfPassword);
        add(btnRegister);

        setVisible(true);

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String phone = tfPhone.getText();
                String dob = tfDOB.getText();
                String email = tfEmail.getText();
                String password = new String(pfPassword.getPassword());

                if (username.isEmpty() || phone.isEmpty() || dob.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled.");
                    return;
                }

                // Create and save user
                User user = new User(username, phone, dob, email, password);
                Database.saveUser(user);
            }
        });
    }
}
