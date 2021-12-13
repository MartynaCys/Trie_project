package main_window.logic;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class FileOperation {
    private final File selectedFile;
    private List<String> words;

    public FileOperation(File file) {
        this.selectedFile = file;
    }

    public void saveText() {
        if(!this.selectedFile.getAbsolutePath().isEmpty()) {
           try(BufferedReader ignored = new BufferedReader(new FileReader(this.selectedFile))) {
               this.words = Files.readAllLines(this.selectedFile.toPath())
                            .stream()
                            .map(l -> l.split(" "))
                            .flatMap(Arrays::stream)
                            .collect(Collectors.toList());
               System.out.println(this.words);
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }

    public static List<Character> splitInCharacters(String word) {
        List<Character> characters = new ArrayList<>();
        for (char ch: word.toCharArray()) {
            characters.add(ch);
        }
        return characters;
    }
}
