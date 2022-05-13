package org.example;

import java.io.*;
import java.util.Scanner;

public class FileOperations {

    private static final String MESSAGE = "Введите путь к текстовому файлу в формате: \"C:\\Users\\...\\test.txt\" \n Путь: ";


    private FileOperations() {
    }
    public static String getMessage() {
        return MESSAGE;
    }

    public static void encryption () {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resourses/out-files/result.txt"));){

            while (bufferedReader.ready()) {
                char letter = (char) bufferedReader.read();
                if (CryptoAlphabet.alphabet.contains(letter)) {
                    letter = CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) + 3);
                    bufferedWriter.append(letter);
                } else {
                    bufferedWriter.append(letter);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decoding () {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resourses/out-files/result.txt"));){

            while (bufferedReader.ready()) {
                char letter = (char) bufferedReader.read();
                if (CryptoAlphabet.alphabet.contains(letter)) {
                    letter = CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) - 3);
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
