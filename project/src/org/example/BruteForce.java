package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BruteForce {

    private BruteForce() {
    }

    public static void bruteForceDecoding() {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        int step = stepSelection(path);
        decoding(step, path);
    }

    private static int stepSelection(String path) {
        List<String> words = vocabulary();
        int step = CryptoAlphabet.size() - 1;
        for (int i = step; i >= 1; i--, step--) {
            String decodingText = getSymbolsFromFile(i, path);
            int correctWordCounter = correctWordsCounter(words, decodingText);
            if (correctWordCounter > decodingText.split(" ").length/2) {
                break;
            }
        }
        return step;
    }

    public static String getSymbolsFromFile(int stepDecoding, String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < 100; i++) {
                if (bufferedReader.ready()) {
                    char letter = (char) bufferedReader.read();
                    stringBuilder.append(LettersShift.newLetterDecrypt(stepDecoding, letter));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    private static void decoding (int step, String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("project/resourses/out/result.txt"))){

            while (bufferedReader.ready()) {
                char letter = (char) bufferedReader.read();
                bufferedWriter.append(LettersShift.newLetterDecrypt(step, letter));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> vocabulary() {
        Path russianWords = Path.of("project/resourses/in/russian-words.txt");
        List<String> words = null;
        try {
            words = Files.readAllLines(russianWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    private static int correctWordsCounter(List<String> list, String decodingText) {
        String[] textArray = decodingText.split(" ");
        int correctWordCounter = 0;
        for (String word : textArray) {
            if (list.contains(word)) {
                correctWordCounter++;
            }
        }
        return correctWordCounter;
    }
}