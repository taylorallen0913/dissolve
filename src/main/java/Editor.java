import javax.swing.*;
import java.awt.BorderLayout;

import org.fife.ui.rtextarea.*;

import org.fife.ui.rsyntaxtextarea.*;

public class Editor extends JFrame {

    JFrame frame;
    JPanel panel;
    EditorMenu menu;

    public Editor(String filePath, String fileContents) {
        frame = new JFrame();
        panel = new JPanel(new BorderLayout());

        menu = new EditorMenu();

        panel.add(menu.getMenuBar(), BorderLayout.NORTH);

        RSyntaxTextArea textArea = new RSyntaxTextArea(fileContents, 40, 120);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        panel.add(sp, BorderLayout.CENTER);

        setContentPane(panel);
        setTitle("Dissolve Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }
}
