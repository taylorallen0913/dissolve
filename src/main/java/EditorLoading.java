import javax.swing.*;

public class EditorLoading extends JFrame {

    JPanel panel;
    JFrame frame;
    CreateProject project;

    public EditorLoading(CreateProject project) {
        this.project = project;

        panel = new JPanel();
        frame = new JFrame();

        setUndecorated(true);
        frame.add(panel);
        frame.setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    private void loadingFinished() {

    }
}