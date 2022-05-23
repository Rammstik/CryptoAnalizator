package org.example;

public class LettersShift {

    public static char newLetterEncrypt(int step, char letter) {
        if (CryptoAlphabet.contains(letter)) {
            return CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) + step);
        } else {
            return letter;
        }
    }
    public static char newLetterDecrypt(int step, char letter) {
        if (CryptoAlphabet.contains(letter)) {
            return CryptoAlphabet.getLetter(CryptoAlphabet.getIndex(letter) - step);
        } else {
            return letter;
        }
    }
}

