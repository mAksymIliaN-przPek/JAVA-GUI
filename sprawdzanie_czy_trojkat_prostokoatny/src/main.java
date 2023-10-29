import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class main {
    private JFrame frame;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JButton sprawdzButton;
    private JTextArea textAreaWynik;

    public main() {
        frame = new JFrame("Sprawdzanie trójkąta prostokątnego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        textFieldA = new JTextField(10);
        textFieldB = new JTextField(10);
        textFieldC = new JTextField(10);
        sprawdzButton = new JButton("Sprawdź");
        textAreaWynik = new JTextArea(3, 30);
        textAreaWynik.setEditable(false);

        frame.add(new JLabel("Bok A:"));
        frame.add(textFieldA);
        frame.add(new JLabel("Bok B:"));
        frame.add(textFieldB);
        frame.add(new JLabel("Bok C:"));
        frame.add(textFieldC);
        frame.add(sprawdzButton);
        frame.add(textAreaWynik);

        sprawdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textFieldA.getText());
                    double b = Double.parseDouble(textFieldB.getText());
                    double c = Double.parseDouble(textFieldC.getText());

                    double[] sides = {a, b, c};
                    Arrays.sort(sides);

                    if (Math.pow(sides[0], 2) + Math.pow(sides[1], 2) == Math.pow(sides[2], 2)) {
                        textAreaWynik.setText("Trójkąt o podanych bokach jest prostokątny.");
                    } else {
                        textAreaWynik.setText("Trójkąt o podanych bokach nie jest prostokątny.");
                    }
                } catch (NumberFormatException ex) {
                    textAreaWynik.setText("Proszę wprowadzić prawidłowe wartości liczbowe.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
}
