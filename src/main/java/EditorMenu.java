import javax.swing.*;

import java.awt.MenuBar;
import java.awt.event.*;
import java.io.IOException;

import org.fife.ui.rsyntaxtextarea.*;

public class EditorMenu extends Editor {
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem save, open, run;

    Editor editor;

    private JFileChooser chooser;

    public EditorMenu(String filePath, RSyntaxTextArea textArea) {
        super();
        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editorMenu = new JMenu("Editor");

        save = new JMenuItem("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOperations.writeToFile(filePath, textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        open = new JMenuItem("Open");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userDir = System.getProperty("user.home");
                chooser = new JFileChooser(userDir + "/Desktop");
                chooser.setDialogTitle("Select a file to open");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setAcceptAllFileFilterUsed(true);
                if (chooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                    String filePath = chooser.getSelectedFile().toString();
                    try {
                        changeEditor(filePath);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                } else {
                    System.out.println("No Selection ");
                }
            }
        });

        run = new JMenuItem("Run");
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputView ov;
                try {
                    ov = new OutputView(filePath);
                    ov.setVisible(true);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        fileMenu.add(save);
        fileMenu.add(open);

        editorMenu.add(run);

        menuBar.add(fileMenu);
        menuBar.add(editorMenu);
    }
}