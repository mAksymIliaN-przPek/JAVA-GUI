import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Konwerter_temperatury {
    private JPanel main_panel;
    private JLabel tytul;
    private JLabel wprowadz_temperature_info;
    private JTextField wprowadzanie_temperatury;
    private JLabel wynik;
    private JTextArea textArea2;
    private JButton licz;

    public Konwerter_temperatury() {
        licz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Pobieranie wartości z pola wprowadzania
                    double celsjusz = Double.parseDouble(wprowadzanie_temperatury.getText());

                    // Przeliczanie Celsjusza na Fahrenheita
                    double fahrenheit = celsjusz * 9/5 + 32;

                    // Wyświetlanie wyniku w textArea2
                    textArea2.setText("Temperatura w Fahrenheitach: " + fahrenheit);
                } catch (NumberFormatException ex) {
                    // Wyświetlanie komunikatu o błędzie, jeśli wprowadzona wartość nie jest liczbą
                    JOptionPane.showMessageDialog(null, "Proszę wpisać prawidłową wartość.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Konwerter Temperatury");
        frame.setContentPane(new Konwerter_temperatury().main_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setVisible(true);
    }
}
