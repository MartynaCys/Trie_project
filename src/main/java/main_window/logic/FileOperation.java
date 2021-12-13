package main_window.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        // System.out.println(splitInCharacters(this.words.get(0)).toString());
    }

    public List<Character> splitInCharacters(String word) {
        List<Character> characters = new ArrayList<>();
        for (char ch: word.toCharArray()) {
            characters.add(ch);
        }
        return characters;
    }
}
