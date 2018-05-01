import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String [] args) {

        String loremIpsum = readFile("loremIpsum.txt");

        BinarySearchTree tree = new BinarySearchTree();
        tree.insertString(loremIpsum);

        tree.inorder(tree.getRoot());

        System.out.println("---");

        LinkedList results = tree.search("ipsum");
        System.out.println(results);
    }

    /**
     * Read text file.
     * @param fileName file name.
     * @return string contents of provided file.
     */
    private static String readFile(String fileName) {
        String contents = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = reader.readLine()) != null) {
                contents += line;
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Unable to read text file");
        }

        return contents;
    }

}
