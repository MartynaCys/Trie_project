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

    public boolean checkIfTreeEmpty() {
        // 1 because of root
        return this.tree.getRowCount() == 1;
    }

    public void addText(List<String> words) {
        boolean empty = checkIfTreeEmpty();
        if(empty) {
            addWord(words.get(0), this.root);        // pamietac pozniej sprawdzic czy lista slow moze byc pusta
        }
        for(int i = 1; i < words.size(); i++) {
            searchWord(words.get(i), this.root);
            // addWord(words.get(i), );
        }

    }

    public void addWord(String word, DefaultMutableTreeNode node) {
        List<Character> characters = FileOperation.splitInCharacters(word);
        for(char ch: characters) {
            node = addNode(ch, false, node);
        }
    }

    public DefaultMutableTreeNode addNode(char letter, boolean check, DefaultMutableTreeNode node) {
        DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(letter);

        // update the tree dynamically
        model.insertNodeInto(newNode, node, node.getChildCount());
        this.tree.scrollPathToVisible(new TreePath(newNode.getPath()));

        return newNode;
    }

    public void searchWord(String word, DefaultMutableTreeNode node) {
        List<Character> characters = FileOperation.splitInCharacters(word);

        DefaultMutableTreeNode returnNode = searchNode(node, characters, 0);
    }

    public DefaultMutableTreeNode searchNode(DefaultMutableTreeNode node, List<Character> characters, int i) {
        Enumeration<TreeNode> enumeration = node.depthFirstEnumeration();
        boolean flag = false;
        while (enumeration.hasMoreElements()) {
                System.out.println("I'm in while loop");
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) enumeration.nextElement();
                System.out.println("Character = " + characters.get(i));
                System.out.println("Current node = " + currentNode.toString());
            if ((String.valueOf(characters.get(i))).equals(currentNode.toString())) {
                System.out.println("There is equality");
                flag = true;
                if (i + 1 < characters.size()) {
                    System.out.println("Size is ok");
                    if (currentNode.children() != null) {
                        //searchNode2(currentNode.)
                        System.out.println("Node has children");
                    } else {
                        StringBuilder word = new StringBuilder();
                        for (int j = i; j < characters.size(); j++) {
                            word.append(characters.get(j));
                        }
                        System.out.println("End of the word = " + word);
                        addWord(word.toString(), currentNode);
                    }
                }
                return currentNode.getNextNode();
            }
        }
        if(!flag) {
            StringBuilder word = new StringBuilder();
            for(char ch: characters) {
                word.append(ch);
            }
            System.out.println("Adding word = " + word);
            addWord(word.toString(), this.root);
        }
        return null;
    }
}
