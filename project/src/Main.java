
import org.example.Actions;
import org.example.MessagesForUsers;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MessagesForUsers.getStartMessage());
        Actions.startAction(scanner);



    }
}