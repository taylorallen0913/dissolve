import javax.swing.*;

public class EditorMenu {
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;

    public EditorMenu() {
        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menuItem = fileMenu.add("Save");

        menuBar.add(fileMenu);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}