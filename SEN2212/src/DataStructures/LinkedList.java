package DataStructures;

import java.text.MessageFormat;

/**
 * Generic linked list data structure.
 */
public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

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

    public int getSize() {
        return size;
    }

    public void append(T o) {
        if (isEmpty())
            head = tail = new Node<>(o);
        else {
            Node<T> node = new Node<>(o, tail, null);
            tail.setRight(node);
            tail = node;
        }
        size++;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        Node<T> current = head;

        while (current != null) {
            sb.append(MessageFormat.format("    {0}\n", current.getObject()));
            current = current.getRight();
        }

        sb.append("]");

        return sb.toString();
    }
}
