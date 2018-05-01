package DataStructures;

/**
 * Generic linked list data structure.
 */
public class LinkedList<T extends Comparable<T>> {

    Node<T> head;
    Node<T> tail;

    public LinkedList() {
        head = tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
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

    public void append(T o) {
        if (isEmpty())
            head = tail = new Node<T>(o);
        else {
            Node node = new Node<T>(o, tail, null);
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
            output += "  " + current.getObject() + "\n";
            current = current.getRight();
        }

        return output + "]";
    }
}
