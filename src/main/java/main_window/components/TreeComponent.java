package main_window.components;

import lombok.Getter;
import main_window.logic.FileOperation;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.List;

@Getter
public class TreeComponent {
    private JTree tree;
    private DefaultMutableTreeNode root;
    private TreePath path;

    public TreeComponent() {
        this.root = new DefaultMutableTreeNode(" ");

        this.tree = new JTree(root);
    }

    public boolean checkIfTreeEmpty() {
        // 1 because of root
        return this.tree.getRowCount() == 1;
    }

    public void addText(List<String> words) {
        boolean empty = checkIfTreeEmpty();
        if(empty) {
            addWord(words.get(0));              // pamietac pozniej sprawdzic czy lista slow moze byc pusta
        }
        System.out.println("I'm here");
    }

    public void addWord(String word) {
        List<Character> characters = FileOperation.splitInCharacters(word);
        DefaultMutableTreeNode node = this.root;
        for(char ch: characters) {
            node = addNode(ch, false, node);
        }
    }

    public DefaultMutableTreeNode addNode(char letter, boolean check, DefaultMutableTreeNode node) {
        DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(letter);

        // update the tree dynamically
        model.insertNodeInto(newNode, this.root, this.root.getChildCount());
        this.tree.scrollPathToVisible(new TreePath(newNode.getPath()));

        return newNode;
    }

    public void searchWord(String word) {
        
    }

    public void searchNode(char letter) {

    }

}
