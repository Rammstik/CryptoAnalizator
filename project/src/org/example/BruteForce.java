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
        Path russianWords = Path.of("project/resourses/in/russian-words.txt");
        List<String> words = null;
        try {
            words = Files.readAllLines(russianWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int maxStep = CryptoAlphabet.size() - 1;
        int step = 1;
        for (int i = maxStep; i >= 1; i--, maxStep--) {
            String decodingText = getSymbolsFromFile(i, path);
            int correctWordCounter = 0;
            String[] textArray = decodingText.split(" ");
            for (String word : textArray) {
                if (words.contains(word)) {
                    correctWordCounter++;
                }
            }
            if (correctWordCounter > textArray.length/2) {
                break;
            }
        }
        return maxStep;
    }

    public static String getSymbolsFromFile(int stepDecoding, String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < 100; i++) {
                if (bufferedReader.ready()) {
                    char letter = (char) bufferedReader.read();
                    if (CryptoAlphabet.contains(letter)) {
                        letter = CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) + stepDecoding);
                        stringBuilder.append(letter);
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return stringBuilder.toString();
    }
    private static void decoding (int step, String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("project/resourses/out/result.txt"))){

            while (bufferedReader.ready()) {
                char letter = (char) bufferedReader.read();
                if (CryptoAlphabet.contains(letter)) {
                    letter = CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) + step);
                    bufferedWriter.append(letter);
                } else {
                    bufferedWriter.append(letter);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}