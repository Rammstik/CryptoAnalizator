package org.example;

public class MessagesForUsers {
    private static final String START_MESSAGE = """
            Выберите необходимое действие с файлом.
            Для шифровки / расшифровки методом Цезаря наберите: CAESAR
            Для расшифровки методом brute force наберите: BRUTEFORCE
            Ожидание ввода (регистр не важен):\040""";

    private static final String CAESAR_MESSAGE = """
            Для расшифровки файла методом Цезаря наберите: DECODING
            Для зашифровки файла методом Цезаря наберите: ENCRYPTION
            Ожидание ввода (регистр не важен):\040""";

    private static final String STEP_FOR_CAESAR_MESSAGE = "Введите необходиый шаг шифровки/дешифровки (от 1 до 73): ";

    private static final String PATH_MESSAGE = "Введите путь к текстовому файлу в формате: \"C:\\Users\\...\\test.txt\" \n Путь: ";

    public static String getStartMessage() {
        return START_MESSAGE;
    }
    public static String getCaesarMessage() {
        return CAESAR_MESSAGE;
    }
    public static String getStepForCaesarMessage() {
        return STEP_FOR_CAESAR_MESSAGE;
    }
    public static String getPathMessage() {
        return PATH_MESSAGE;
    }
}
