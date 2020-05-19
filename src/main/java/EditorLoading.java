import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;

import javax.swing.*;

public class EditorLoading extends JFrame {

    static JPanel panel;
    static JFrame frame;
    static JTextArea display;
    JScrollPane scroll;
    static Editor editor;

    static String displayContent;

    public EditorLoading(String projectName, String projectLocation) {

        displayContent = "";
        panel = new JPanel();
        frame = new JFrame();
        display = new JTextArea();
        scroll = new JScrollPane(display);
        display.setEditable(false);

        panel.add(display);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        createProject(projectName, projectLocation, display);
    }

    private static void createProject(String projectName, String projectLocation, JTextArea display) {
        File rootDir = new File(projectLocation + "/" + projectName);

        if (rootDir.mkdir()) {
            addToDisplay("Project directory created");
        } else {
            addToDisplay("Error when creating root directory");
        }

        File srcDir = new File(projectLocation + "/" + projectName + "/src");

        if (srcDir.mkdir()) {
            addToDisplay("Source directory created");
        } else {
            addToDisplay("Error when creating source directory");
        }

        try {
            FileWriter main = new FileWriter(projectLocation + "/" + projectName + "/src/Main.java");
            main.write(
                    "public class Main {\n\tpublic static void main(String[] args) {\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}");
            main.close();
            addToDisplay("Finished writing to main file");
        } catch (IOException e) {
            addToDisplay("Error when writing to main file");
        }

        JButton continueButton = new JButton("Continue to project");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editor = new Editor(projectLocation + "/" + projectName + "/src/Main.java");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                editor.setVisible(true);
                frame.dispose();
            }
        });
        panel.add(continueButton);

    }

    private static void addToDisplay(String message) {
        displayContent += message + "\n";
        display.setText(displayContent);
    }
}