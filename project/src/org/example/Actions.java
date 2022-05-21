package org.example;

import java.util.Scanner;

public class Actions {
    private static final String STARTMESSAGE = """
            Выберите необходимое действие с файлом.
            Для шифровки / расшифровки методом Цезаря наберите: CAESAR
            Для расшифровки методом brute force наберите: BRUTEFORCE
            Ожидание ввода (регистр не важен):\040""";

    private static final String CAESARMESSAGE = """
            Для расшифровки файла методом Цезаря наберите: DECODING
            Для зашифровки файла методом Цезаря наберите: ENCRYPTION
            Ожидание ввода (регистр не важен):\040""";

    private Actions() {
    }

    public static String getCaesarMessage() {
        return CAESARMESSAGE;
    }

    public static String getStartMessage() {
        return STARTMESSAGE;
    }

    public static void startAction() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choise = scanner.nextLine();
            if (choise.equalsIgnoreCase("CAESAR")) {
                System.out.println(getCaesarMessage());
                actionCaesarChoise();
                break;
            } else if (choise.equalsIgnoreCase("BRUTEFORCE")) {
                System.out.println(FileOperations.getMessage());
                BruteForce.bruteForceDecoding();
                break;
            } else {
                System.out.println("Сделайте верный выбор:");
            }
        }
    }

    public static void actionCaesarChoise() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choise = scanner.nextLine();
            if (choise.equalsIgnoreCase("DECODING")){
                System.out.println(FileOperations.getMessage());
                FileOperations.caesarDecoding(5);
                break;
            } else if (choise.equalsIgnoreCase("ENCRYPTION")) {
                System.out.println(FileOperations.getMessage());
                FileOperations.caesarEncryption(5);
                break;
            } else {
                System.out.println("Сделайте верный выбор:");
            }
        }
    }


}
