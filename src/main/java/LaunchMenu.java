import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class LaunchMenu extends JFrame implements ActionListener {

    private JFileChooser chooser;
    private String choosertitle;

    private int WIDTH = 800;
    private int HEIGHT = 700;

    public LaunchMenu() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        addTitle(panel);
        addCreateProjectButton(panel);

        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(new Color(28, 68, 142));
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private static void addTitle(JPanel panel) {
        JLabel name = new JLabel("Dissolve");
        name.setBounds(300, 50, 500, 60);
        name.setFont(new Font("Verdana", Font.PLAIN, 50));
        name.setForeground(Color.WHITE);
        panel.add(name);
    }

    private void addCreateProjectButton(JPanel panel) {
        JButton button = new JButton("+ Create Project");
        button.setBounds(330, 300, 150, 50);
        button.addActionListener(this);
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
    }

    public static void main(String[] args) {
        new LaunchMenu();
    }
}