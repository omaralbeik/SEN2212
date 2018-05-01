/**
 * Generic linked list data structure.
 */
public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.getRight();
        }
        return count;
    }

    public void append(Word word) {
        if (isEmpty())
            head = tail = new Node(word);
        else {
            Node node = new Node(word, tail, null);
            tail.setRight(node);
            tail = node;
        }
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        String output = "[\n";

        Node current = head;

        while (current != null) {
            output += "  " + current.getWord().toString() + "\n";
            current = current.getRight();
        }

        return output + "]";
    }
}
