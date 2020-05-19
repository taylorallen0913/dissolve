import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class LaunchMenu extends JFrame {

    private JPanel panel;
    private JFrame frame;

    private JFileChooser chooser;
    private String filePath;

    private int WIDTH = 800;
    private int HEIGHT = 700;

    public LaunchMenu() {

        panel = new JPanel();
        frame = new JFrame();

        addTitle(panel);
        addCreateProjectButton(panel);
        addOpenProjectButton(panel, frame);

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
        JButton createProjectButton = new JButton("Create Project");
        createProjectButton.setBounds(330, 400, 150, 50);
        createProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateProjectView createProject = new CreateProjectView();
                createProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                createProject.setSize(400, 400);
                createProject.setLocationRelativeTo(null);
                createProject.setVisible(true);
                frame.dispose();
            }
        });

        panel.add(createProjectButton);
    }

    private void addOpenProjectButton(JPanel panel, JFrame frame) {
        JButton openProjectButton = new JButton("Open Project");
        openProjectButton.setBounds(330, 500, 150, 50);
        openProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userDir = System.getProperty("user.home");
                chooser = new JFileChooser(userDir + "/Desktop");
                chooser.setDialogTitle("Select a file to open");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setAcceptAllFileFilterUsed(true);
                if (chooser.showOpenDialog(openProjectButton) == JFileChooser.APPROVE_OPTION) {
                    filePath = chooser.getSelectedFile().toString();
                    try {
                        openProject(frame, filePath);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    System.out.println("No Selection ");
                }
            }
        });

        panel.add(openProjectButton);
    }

    private static void openProject(JFrame frame, String filePath) throws IOException {
        String fileContents = FileOperations.readFile(filePath);
        Editor editor = new Editor(filePath, fileContents);
        editor.setVisible(true);
        frame.dispose();
    }

}