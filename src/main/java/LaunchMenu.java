import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class LaunchMenu extends JFrame {

    private int WIDTH = 800;
    private int HEIGHT = 700;

    public LaunchMenu() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        JLabel name = new JLabel("Dissolve");
        name.setBounds(300, 50, 500, 60);
        name.setFont(new Font("Verdana", Font.PLAIN, 50));
        name.setForeground(Color.WHITE);
        panel.add(name);

        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setContentPane(panel);
        // frame.setTitle("Dissolve");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(new Color(28, 68, 142));
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LaunchMenu();
    }
}