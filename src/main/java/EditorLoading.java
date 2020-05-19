import javax.swing.*;

public class EditorLoading extends JFrame {

    JPanel panel;
    JFrame frame;

    public EditorLoading(String projectName, String projectLocation) {

        panel = new JPanel();
        frame = new JFrame();

        setUndecorated(true);
        frame.add(panel);
        frame.setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    private void createProject(String projectName, String projectLocation) {

    }

    private void loadingFinished() {

    }
}