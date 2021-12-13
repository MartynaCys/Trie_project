import main_window.components.FileChooser;
import main_window.components.TreeComponent;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Main Window");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TreeComponent treeComponent = new TreeComponent();
        System.out.println(treeComponent.checkIfTreeEmpty());

        JButton fileDialogBtn = new JButton("Select File");
        fileDialogBtn.addActionListener(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.actionListener();
            treeComponent.addText(fileChooser.getFileOperation().getWords());
        });

        JTextArea addTextArea = new JTextArea("Add some text to the tree", 3, 10);
        JButton addTextBtn = new JButton("Add");
        addTextBtn.addActionListener(e -> {
            System.out.println("adding");
        });

        JTextField searchWordText = new JTextField("Search the word");
        JButton searchWordBtn = new JButton("Search");
        searchWordBtn.addActionListener(e -> {
            System.out.println("searching");
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(fileDialogBtn);
        panel.add(addTextArea);
        panel.add(addTextBtn);
        panel.add(searchWordText);
        panel.add(searchWordBtn);
        panel.add(treeComponent.getTree());

        frame.add(panel);

        frame.setVisible(true);
    }
}
