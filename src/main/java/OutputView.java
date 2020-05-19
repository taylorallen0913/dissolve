import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 * This is the window the appears when you compile and run your project. It
 * shows the output of your code's execution.
 * 
 * @author Taylor Allen
 */
public class OutputView extends JFrame {

    static String displayContent;
    JFrame frame;
    JPanel panel;
    static JTextPane display;
    JScrollPane scroll;

    public OutputView(String filePath) throws InterruptedException, IOException {

        displayContent = "";

        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        display = new JTextPane();
        display.setEditable(false);
        scroll = new JScrollPane(display);

        panel.add(scroll);
        setContentPane(panel);
        setSize(800, 500);
        setTitle("Output");
        setLocationRelativeTo(null);
        compileAndRun(filePath);
    }

    private static void setDisplay(String content) {
        displayContent += content + "\n";
        display.setText(displayContent);
    }

    public static void compileAndRun(String filePath) throws IOException {
        String command = "javac " + filePath + " && java " + filePath;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", command);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            setDisplay(line);
        }
    }

}