import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password {
    private JFrame frame;
    private JLabel Text1;
    private JLabel Text2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton okButton;

    public Password() {
        // Inicjalizacja komponentów
        frame = new JFrame("Swing JPasswordField Demo Program");
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Text1 = new JLabel("Enter password:");
        Text2 = new JLabel("Confirm password:");
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField1.getPassword();
                char[] confirmPassword = passwordField2.getPassword();

                if (!java.util.Arrays.equals(password, confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match!");
                } else if (java.util.Arrays.equals(password, "codejava".toCharArray())) {
                    JOptionPane.showMessageDialog(frame, "Congratulations! You entered correct password.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Wrong password!");
                }

                // Czyszczenie tablic haseł dla bezpieczeństwa
                java.util.Arrays.fill(password, '0');
                java.util.Arrays.fill(confirmPassword, '0');
            }
        });

        frame.add(Text1);
        frame.add(passwordField1);
        frame.add(Text2);
        frame.add(passwordField2);
        frame.add(okButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Password());
    }
}
