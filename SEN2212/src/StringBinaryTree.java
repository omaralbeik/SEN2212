import DataStructures.BinarySearchTree;
import DataStructures.LinkedList;
import DataStructures.Node;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringBinaryTree extends BinarySearchTree<Word> {

    public void insertStringFromFile(String fileName) throws Exception {
        String contents = readFile(fileName);
        if (contents != null) {
            insertString(contents);
        }
    }

    public void insertString(String s) {
        String currentWord = "";
        int currentStartIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if (!isAllowedChar(s.charAt(i))) {

                if (!currentWord.isEmpty()) {
                    Word word = new Word(currentWord, currentStartIndex, i - 1);
                    insert(word);
                    currentWord = "";
                }
                continue;
            } else {
                if (currentWord.isEmpty()) {
                    currentStartIndex = i;
                }
            }

            currentWord += s.charAt(i);
        }
    }

    public LinkedList<Word> search(String query) {
        Node<Word> current = getRoot();

        LinkedList<Word> results = new LinkedList();

        while (current != null) {
            Word currentObject = current.getObject();

            if (query.compareTo(currentObject.getValue()) < 0) {
                current = current.getLeft();
            } else if (query.compareTo(currentObject.getValue()) > 0) {
                current = current.getRight();
            } else {
                results.append(currentObject);
                current = current.getRight();
            }
        }

        return results;
    }


    private boolean isAllowedChar(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    /**
     * Read text file.
     * @param fileName file name.
     * @return string contents of provided file.
     */
    private static String readFile(String fileName) throws Exception {
        String contents = "";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            contents += line;
        }
        reader.close();

        return contents;
    }

}
