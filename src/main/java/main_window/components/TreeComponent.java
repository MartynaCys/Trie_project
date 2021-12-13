package main_window.components;

import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

@Getter
public class TreeComponent {
    private JTree tree;

    public TreeComponent() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(" ");

        this.tree = new JTree(root);
    }

    public boolean checkIfTreeEmpty() {
        // 1 because of root
        return this.tree.getRowCount() == 1;
    }

    
}
