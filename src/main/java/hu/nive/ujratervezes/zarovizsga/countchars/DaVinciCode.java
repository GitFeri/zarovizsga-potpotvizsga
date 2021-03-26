package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {

    public int encode(String fileName, char ch) {

        if ("01x".indexOf(ch) < 0) {
            throw new IllegalArgumentException("Invalid character");
        }

        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            return countOfCharacterInFile(reader, ch);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int countOfCharacterInFile(BufferedReader reader, char ch) throws IOException {
        String line;
        int countOfCharacter = 0;
        while ((line = reader.readLine()) != null) {
            countOfCharacter += countOfCharacterInLine(line, ch);
        }
        return countOfCharacter;
    }

    private int countOfCharacterInLine(String line, Character ch) {
        int countOfCharacter = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ch) {
                countOfCharacter++;
            }

        }
        return countOfCharacter;
    }
}