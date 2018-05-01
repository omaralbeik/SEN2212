import DataStructures.BinarySearchTree;
import DataStructures.LinkedList;
import DataStructures.Node;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringBinaryTree extends BinarySearchTree<Word> {

    public void insertStringFromFile(String fileName) throws Exception {
        String contents = readFile(fileName);
        insertString(contents);
    }

    public void insertString(String s) {
        StringBuilder sb = new StringBuilder();
        int currentStartIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isAllowedChar(c)) {
                if (sb.length() > 0) {
                    insert(new Word(sb.toString(), currentStartIndex));
                    sb.setLength(0);
                }
                continue;
            } else {
                if (sb.length() == 0) {
                    currentStartIndex = i;
                }
            }

            sb.append(c);
        }
    }

    public LinkedList<Word> search(String query) {
        Node<Word> current = getRoot();

        LinkedList<Word> results = new LinkedList<>();

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

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        return sb.toString();
    }

}
