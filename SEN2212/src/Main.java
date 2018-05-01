import DataStructures.LinkedList;

public class Main {

    public static void main(String[] args) {

        StringBinaryTree tree = new StringBinaryTree();

        try {
            tree.insertStringFromFile("loremIpsum.txt");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        tree.inorder(tree.getRoot());

        System.out.println("---");

        LinkedList results = tree.search("ipsum");
        System.out.println(results);
    }

}

