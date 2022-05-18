package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CryptoAlphabet {
    private static List<Character> alphabet = new ArrayList<>(Arrays.asList('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н',
                                                                'О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я',
                                                                'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р',
                                                                'с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','.',',','"',
                                                                ':','-','!','?',' '));
    private CryptoAlphabet() {

    }
    public static char getLetter(int index) {
        if (index > alphabet.size() - 1) {
            index = (index - alphabet.size());
        }
        if (index < 0) {
            index = (index + alphabet.size());
        }
        return alphabet.get(index);
    }

    public static boolean contains (char letter) {
        return alphabet.contains(letter);
    }

    public static int getIndex(char letter) {
        return alphabet.indexOf(letter);
    }

}
