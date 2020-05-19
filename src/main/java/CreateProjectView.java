import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class CreateProjectView extends JFrame {

    private JFileChooser chooser;

    private String projectLocation;

    private final CardLayout cl = new CardLayout();
    private final JPanel cards = new JPanel(cl);

    public CreateProjectView() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Project Name");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        namePanel.add(nameLabel);
        JTextField nameInput = new JTextField(30);
        namePanel.add(nameInput);
        cards.add(namePanel, "Name Panel");

        JPanel locationPanel = new JPanel();
        JLabel locationLabel = new JLabel("Workspace Location");
        locationLabel.setHorizontalAlignment(JLabel.CENTER);
        locationPanel.add(locationLabel);
        JButton locationSelector = new JButton("Select Directory");

        locationSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userDir = System.getProperty("user.home");
                chooser = new JFileChooser(userDir);
                chooser.setDialogTitle("Select a directory to set as your workspace location");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(true);
                if (chooser.showOpenDialog(locationSelector) == JFileChooser.APPROVE_OPTION) {
                    projectLocation = chooser.getSelectedFile().toString();
                } else {
                    System.out.println("No Selection ");
                }
            }
        });

        locationPanel.add(locationSelector);
        cards.add(locationPanel, "Location Panel");

        JPanel createProjectPanel = new JPanel();
        JButton createProjectButton = new JButton("Create Project");
        createProjectPanel.add(createProjectButton);
        cards.add(createProjectPanel, "Create Project Panel");

        createProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectName = nameInput.getText();
                EditorLoading editorLoading = new EditorLoading(projectName, projectLocation);
                editorLoading.setVisible(true);
                dispose();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.previous(cards);
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.next(cards);
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.LIGHT_GRAY);
        controlPanel.add(backButton);
        controlPanel.add(nextButton);

        contentPane.add(cards);
        contentPane.add(controlPanel);

        cl.show(cards, "Name Panel");
    }

}