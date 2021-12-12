package main_window.components;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

@Getter
@NoArgsConstructor
public class FileChooser {
    private JFileChooser fileChooser;
    private File selectedFile;

    public void actionListener() {
        this.fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        this.fileChooser.setFileFilter(filter);

        int read = this.fileChooser.showOpenDialog(null);

        if(read == JFileChooser.APPROVE_OPTION) {
            this.selectedFile = this.fileChooser.getSelectedFile();
        }
    }
}
