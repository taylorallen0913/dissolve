import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class LaunchMenu extends JFrame implements ActionListener {

    private JPanel panel;
    private JFrame frame;

    private int WIDTH = 800;
    private int HEIGHT = 700;

    public LaunchMenu() {

        panel = new JPanel();
        frame = new JFrame();

        addTitle(panel);
        addCreateProjectButton(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setContentPane(panel);
        panel.setBackground(new Color(28, 68, 142));
        frame.setLocationRelativeTo(null);
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
        CreateProjectView createProject = new CreateProjectView();
        createProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createProject.setSize(400, 400);
        createProject.setLocationRelativeTo(null);
        createProject.setVisible(true);
        frame.dispose();
    }
}