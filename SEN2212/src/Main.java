import DataStructures.LinkedList;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    private static StringBinaryTree tree = new StringBinaryTree();

    public static void main(String[] args) {

        printWelcome();
        askForTextFile();

    }

    // Helpers
    private static void printWelcome() {
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println();
        System.out.println(
                        "  /$$$$$$  /$$$$$$$$ /$$   /$$        /$$$$$$   /$$$$$$    /$$    /$$$$$$ \n" +
                        " /$$__  $$| $$_____/| $$$ | $$       /$$__  $$ /$$__  $$ /$$$$   /$$__  $$\n" +
                        "| $$  \\__/| $$      | $$$$| $$      |__/  \\ $$|__/  \\ $$|_  $$  |__/  \\ $$\n" +
                        "|  $$$$$$ | $$$$$   | $$ $$ $$        /$$$$$$/  /$$$$$$/  | $$    /$$$$$$/\n" +
                        " \\____  $$| $$__/   | $$  $$$$       /$$____/  /$$____/   | $$   /$$____/ \n" +
                        " /$$  \\ $$| $$      | $$\\  $$$      | $$      | $$        | $$  | $$      \n" +
                        "|  $$$$$$/| $$$$$$$$| $$ \\  $$      | $$$$$$$$| $$$$$$$$ /$$$$$$| $$$$$$$$\n" +
                        " \\______/ |________/|__/  \\__/      |________/|________/|______/|________/\n"
        );

        System.out.println("==========================================================================");
        System.out.println();
        System.out.println("Welcome to SEN2212 Lab Project!");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Utilize binary search trees and linked-lists to search efficiently\n" +
                           "for strings in large text files\n\n" +
                           "Enter \"q\" to quit anytime.");
        System.out.println("==========================================================================\n");
        System.out.println();
    }
    private static void askForTextFile() {
        System.out.println();
        System.out.println("Enter a text file name: ");
        showFileNames();

        Scanner scanInput = new Scanner(System.in);
        String input = scanInput.nextLine();
        validateInput(input);

        if (input.isEmpty()) {
            askForTextFile();
        }

        try {
            tree.insertStringFromFile(input);
            System.out.println(MessageFormat.format("Inserted {0} nodes in a binary search tree successfully!", tree.getSize()));
            askForSearchQuery();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            askForTextFile();
        }
    }
    private static void askForSearchQuery() {
        System.out.println();
        System.out.print("Enter a search query: ");

        Scanner scanInput = new Scanner(System.in);
        String input = scanInput.nextLine();
        validateInput(input);

        if (input.isEmpty()) {
            askForSearchQuery();
            return;
        }

        LinkedList results = tree.search(input);

        System.out.println(MessageFormat.format("Found {0} results for \"{1}\"", results.size(), input));
        askToShowResults(results);
    }
    private static void askToShowResults(LinkedList results) {
        System.out.println();

        if (results.isEmpty()) {
            askForSearchAgain();
            return;
        }

        System.out.print("Show results [yN]? ");

        Scanner scanInput = new Scanner(System.in);
        String input = scanInput.nextLine();
        validateInput(input);

        switch (input) {
            case "y": case "yes":
                System.out.println(results);
            case "n": case "no":
                askForSearchAgain();
            default:
                askToShowResults(results);
        }

        if (input.isEmpty()) {
            askForSearchQuery();
        }
    }
    private static void askForSearchAgain() {
        System.out.println();
        System.out.print("Search for another word [yN]? ");

        Scanner scanInput = new Scanner(System.in);
        String input = scanInput.nextLine().toLowerCase();
        validateInput(input);

        switch (input) {
            case "y": case "yes":
                askForSearchQuery();
            case "n": case "no":
                System.exit(0);
            default:
                askForSearchAgain();
        }

    }
    private static void showFileNames() {
        System.out.println("==========================================================================");
        System.out.println("| File Name                             | Size      | Number of lines    |");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| book0.txt (Lorem Ipsum)               | Small     | 35 lines           |");
        System.out.println("| book1.txt (Heart of Darkness)         | Avg       | 13,000 lines       |");
        System.out.println("| book2.txt (Pride and Prejudice)       | Large     | 37,000 lines       |");
        System.out.println("| book3.txt (Les Misérables)            | V.Large   | 68,000 lines       |");
        System.out.println("==========================================================================");
    }
    private static void validateInput(String input) {
        if (input.toLowerCase().equals("q"))
            System.exit(0);
    }

}