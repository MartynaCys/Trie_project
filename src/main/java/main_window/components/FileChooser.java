package main_window.components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import main_window.logic.FileOperation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

@Getter
@NoArgsConstructor
public class FileChooser {
    private JFileChooser fileChooser;
    private FileOperation fileOperation;

    public void actionListener() {
        this.fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        this.fileChooser.setFileFilter(filter);

        int read = this.fileChooser.showOpenDialog(null);

        if(read == JFileChooser.APPROVE_OPTION) {
            fileOperation = new FileOperation(this.fileChooser.getSelectedFile());
            fileOperation.saveText();
        }
    }
}
