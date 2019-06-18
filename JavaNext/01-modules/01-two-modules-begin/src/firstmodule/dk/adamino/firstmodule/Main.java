package dk.adamino.module1;

import dk.adamino.module2.*;

public class Main {

    public static void main(String[] args) {
        Helper helper = new Helper();
        String text = helper.getHelperString();
        print(text);
    }

    private static void print(String textToPrint) {
        System.out.println(textToPrint);
    }
}