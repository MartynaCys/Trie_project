import main_window.components.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Main Window");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainWindow window = new MainWindow();

        JButton fileDialogBtn = new JButton("Select File");
        fileDialogBtn.addActionListener(window);

        JTextArea addTextArea = new JTextArea("Add some text to the tree", 3, 10);
        JButton addTextBtn = new JButton("Add");

        JTextField searchWordText = new JTextField("Search the word");
        JButton searchWordBtn = new JButton("Search");

        // TreeComponent treeComponent = new TreeComponent();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(fileDialogBtn);
        panel.add(addTextArea);
        panel.add(addTextBtn);
        panel.add(searchWordText);
        panel.add(searchWordBtn);
        // panel.add(treeComponent.getTree());

        frame.add(panel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.actionListener();
    }
}
