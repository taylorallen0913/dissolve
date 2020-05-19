import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import org.fife.ui.rsyntaxtextarea.*;

public class EditorMenu {
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;

    public EditorMenu(String filePath, RSyntaxTextArea textArea) {
        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOperations.writeToFile(filePath, textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        fileMenu.add(menuItem);

        menuBar.add(fileMenu);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}