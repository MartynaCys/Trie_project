package main_window.components;

import lombok.Getter;
import main_window.logic.FileOperation;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.List;

@Getter
public class TreeComponent {
    private JTree tree;
    private DefaultMutableTreeNode root;

    public TreeComponent() {
        this.root = new DefaultMutableTreeNode(" ");
        this.tree = new JTree(root);
    }

    public void addText(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            addWord(words.get(i), this.root);
        }
    }

    public DefaultMutableTreeNode createNode(char letter, DefaultMutableTreeNode node) {
        DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(letter);

        // update the tree dynamically
        model.insertNodeInto(newNode, node, node.getChildCount());
        this.tree.scrollPathToVisible(new TreePath(newNode.getPath()));

        return newNode;
    }

    public void addWord(String word, DefaultMutableTreeNode node) {
        List<Character> characters = FileOperation.splitInCharacters(word);
        addNode(node, characters, 0);
    }

    public void addNode(DefaultMutableTreeNode node, List<Character> characters, int letterIndex) {
        final char letter = characters.get(letterIndex);
        Enumeration<TreeNode> enumeration = node.children();
        boolean foundChild = false;
        while (enumeration.hasMoreElements()) {
                DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) enumeration.nextElement();
            if ((String.valueOf(letter)).equals(currentNode.toString())) {
                foundChild = true;

                if (letterIndex < characters.size() - 1) {
                    addNode(currentNode, characters, letterIndex + 1);
                }
            }
        }

        if(!foundChild){
              DefaultMutableTreeNode newNode = createNode(letter, node);

            if (letterIndex < characters.size() - 1) {
                addNode(newNode, characters, letterIndex + 1);
            }
        }
    }

    public boolean searchWord(String word) {
        List<Character> characters = FileOperation.splitInCharacters(word);
        return searchNode(this.root, characters, 0);
    }

    public boolean searchNode(DefaultMutableTreeNode node, List<Character> characters, int letterIndex) {
        final char letter = characters.get(letterIndex);
        Enumeration<TreeNode> enumeration = node.children();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) enumeration.nextElement();
            if ((String.valueOf(letter)).equals(currentNode.toString())) {
                if (letterIndex < characters.size() - 1) {
                    return searchNode(currentNode, characters, letterIndex + 1);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
