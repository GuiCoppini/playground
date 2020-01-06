package datastructs;


public class LinkedList<T> implements DataStructure {
    private Node first = null;
    int size;

    @Override
    public boolean insert(Object obj) {
        if(first == null) {
            first = new Node(obj);
            size++;
            return true;
        }

        Node actual = first;

        while(actual.next != null) {
            actual = actual.next;
        }

        actual.next = new Node(obj);
        size++;
        return true;
    }

    @Override
    public boolean delete(Object obj) {
        if(!exists(obj)) return false;
        Node actual = first;
        Node before = null;

        while(actual != null) {
            if(obj.equals(actual.value)) {
                if(before == null) { // is first
                    first = first.next;
                    size--;
                    return true;
                }
                before.next = actual.next;
                size--;
                return true;
            }
            actual = actual.next;
        }

        return  false;
    }

    @Override
    public boolean exists(Object obj) {
        Node actual = first;

        while(actual != null) {
            if(obj.equals(actual.value)) return true;
            actual = actual.next;
        }

        return false;
    }

    @Override
    public void fill(Object value) {
        first = new Node(value);
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}

class Node<T> {
    T value;
    Node next = null;

    public Node(T value) {
        this.value = value;
    }

    boolean hasNext() {
        return next != null;
    }
}