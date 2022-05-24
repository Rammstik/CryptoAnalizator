package org.example;

import java.io.*;
import java.util.Scanner;

public class CaesarCrypto {

    private CaesarCrypto() {
    }

    public static void caesarEncryption (int step) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("project/resourses/out/result.txt"))){

            while (bufferedReader.ready()) {
                char letter = (char) bufferedReader.read();
                bufferedWriter.append(LettersShift.newLetterEncrypt(step, letter));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void caesarDecoding (int step) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("project/resourses/out/result.txt"))){

            while (bufferedReader.ready()) {
                char letter = (char) bufferedReader.read();
                bufferedWriter.append(LettersShift.newLetterDecrypt(step, letter));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
