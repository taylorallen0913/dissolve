import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

/**
 * This is an editor window.
 * 
 * @author Taylor Allen
 */
public class Editor extends JFrame {

    String fileContents;
    String filePath;
    JFrame frame;
    JPanel panel;
    EditorMenu menu;

    static RSyntaxTextArea textArea;
    RTextScrollPane sp;

    public Editor() {
    }

    public Editor(String filePath) throws IOException {
        initializeEditor(filePath);
    }

    void initializeEditor(String filePath) throws IOException {
        this.filePath = filePath;
        fileContents = FileOperations.readFile(filePath);

        frame = new JFrame();
        panel = new JPanel(new BorderLayout());

        textArea = new RSyntaxTextArea(fileContents, 40, 120);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        sp = new RTextScrollPane(textArea);
        panel.add(sp, BorderLayout.CENTER);

        menu = new EditorMenu(this.filePath, textArea);
        panel.add(menu.menuBar, BorderLayout.NORTH);

        setContentPane(panel);
        setTitle("Dissolve Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    void changeEditor(String filePath) throws IOException {
        this.filePath = filePath;
        String content = FileOperations.readFile(filePath);
        textArea.setText(content);
    }
}
