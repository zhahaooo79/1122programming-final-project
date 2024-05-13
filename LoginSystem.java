import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginSystem() {
        setTitle("Login System");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check username and password
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("your_student_id") && password.equals("your_password")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    openNextScreen(); // Call method to open next screen
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Register new account
                String username = usernameField.getText();
                String password1 = new String(passwordField.getPassword());
                String password2 = JOptionPane.showInputDialog(null, "Confirm Password:");

                if (password1.equals(password2)) {
                    // Save username and password to database
                    JOptionPane.showMessageDialog(null, "Registration successful! Please login.");
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    private void openNextScreen() {
        JFrame nextScreen = new JFrame("Next Screen");
        nextScreen.setSize(300, 200);
        nextScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextScreen.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton buyerButton = new JButton("Buyer");
        JButton sellerButton = new JButton("Seller");

        buyerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions for buyer
                JOptionPane.showMessageDialog(null, "You selected Buyer action.");
            }
        });

        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions for seller
                JOptionPane.showMessageDialog(null, "You selected Seller action.");
            }
        });

        panel.add(buyerButton);
        panel.add(sellerButton);

        nextScreen.add(panel);
        nextScreen.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginSystem();
    }
}
