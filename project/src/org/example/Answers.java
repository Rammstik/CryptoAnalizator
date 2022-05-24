package org.example;

public enum Answers {
    CAESAR,
    BRUTEFORCE,
    DECODING,
    ENCRYPTION,
    OTHER;

    public static Answers checkingAnswers(String answer) {
        for (Answers rightAnswer:Answers.values()) {
            if (answer.equalsIgnoreCase(rightAnswer.name())) {
                return rightAnswer;
            }
        }
        return OTHER;
    }
}
