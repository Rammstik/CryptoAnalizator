package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BruteForce {

    private BruteForce () {
    }

    public static void bruteForceDecoding() {

    }
    private static int stepSelection () {
        StringBuilder stringBuilder = new StringBuilder();
        int step = -(CryptoAlphabet.size() - 1);
        int correctWordCounter = 0;
        Path russianWords = Path.of("project/resourses/in/russian-words.txt");
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()))) {
            for (int i = 0; i < 100; i++) {
                if (bufferedReader.ready()) {
                    char letter = (char) bufferedReader.read();
                    if (CryptoAlphabet.contains(letter)) {
                        letter = CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) - step);
                        stringBuilder.append(letter);
                    }
                } else {
                    break;
                }
                String decodingText = stringBuilder.toString();

                List<String> words = Files.readAllLines(russianWords);

                String[] textArray = decodingText.split(" ");
                for (String word : textArray) {
                    if (words.contains(word)) {
                        correctWordCounter++;
                    }

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return step;
    }
}