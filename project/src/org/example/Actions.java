package org.example;

import java.util.Scanner;

public class Actions {

    public static void startAction(Scanner scanner) {
        String choise = scanner.nextLine();
        switch (Answers.checkingAnswers(choise)) {
            case CAESAR -> {
                System.out.println(MessagesForUsers.getCaesarMessage());
                actionCaesarChoise(scanner);
            }
            case BRUTEFORCE -> {
                System.out.println(MessagesForUsers.getPathMessage());
                BruteForce.bruteForceDecoding();
            }
            default -> {
                System.out.println("Сделайте верный выбор:");
                startAction(scanner);
            }
        }
    }

    public static void actionCaesarChoise(Scanner scanner) {
        String choise = scanner.nextLine();
        switch (Answers.checkingAnswers(choise)) {
            case ENCRYPTION -> {
                int step = stepForCaesar(scanner);
                System.out.println(MessagesForUsers.getPathMessage());
                CaesarCrypto.caesarEncryption(step);
            }
            case DECODING -> {
                int step = stepForCaesar(scanner);
                System.out.println(MessagesForUsers.getPathMessage());
                CaesarCrypto.caesarDecoding(step);
            }
            default -> {
                System.out.println("Сделайте верный выбор:");
                actionCaesarChoise(scanner);
            }
        }
    }

    static int stepForCaesar (Scanner scanner) {
        System.out.println(MessagesForUsers.getStepForCaesarMessage());
        return scanner.nextInt();
    }


}
