package main_window.components;

import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

@Getter
public class TreeComponent {
    private JTree tree;

    public TreeComponent() {
        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");

        style.add(color);
        this.tree = new JTree(style);
    }
}
