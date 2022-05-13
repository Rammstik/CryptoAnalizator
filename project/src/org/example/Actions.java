package org.example;

import java.util.Scanner;

public class Actions {
    private static String message = """
            Выберите необходимое действие с файлом.
            Для расшифровки файла наберите: DECODING
            Для зашифровки файла наберите: ENCRYPTION
            Ожидание ввода (регистр не важен):\040""";

    private Actions() {
    }

    public static String getMessage() {
        return message;
    }

    public static void actionChoise() {
        Scanner scanner = new Scanner(System.in);
        String choise = scanner.nextLine();
        while (true) {
            if (choise.equalsIgnoreCase("DECODING")){
                System.out.println(FileOperations.getMessage());
                FileOperations.decoding();
                break;
            } else if (choise.equalsIgnoreCase("ENCRYPTION")) {
                System.out.println(FileOperations.getMessage());
                FileOperations.encryption();
                break;
            } else {
                System.out.println("Сделайте верный выбор:");
            }
        }
    }


}
