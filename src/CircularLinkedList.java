public class CircularLinkedList {
    private class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
            next = this;
            previous = this;
        }
    }

    // beginning/end node
    private final Node dummy = new Node(0);

    public void addItem(int value) {
        Node newNode = new Node(value);
        Node last = dummy.previous;

        newNode.next = dummy;
        newNode.previous = last;
        last.next = newNode;
        dummy.previous = newNode;
    }

    // return string
    public String showList() {
        StringBuilder result = new StringBuilder();
        Node current = dummy.next;

        while (current != dummy) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(current.data);
            current = current.next;
        }
        return result.toString();
    }

    // reverse list
    public String showReverseList() {
        StringBuilder result = new StringBuilder();
        showReverse(dummy.next, result);
        return result.toString();
    }

    private void showReverse(Node current, StringBuilder result) {
        if (current == dummy) {
            return;
        }

        showReverse(current.next, result);
        if (result.length() > 0) {
            result.append(" ");
        }
        result.append(current.data);
    }

    public boolean find(int value) {
        Node current = dummy.next;
        while (current != dummy) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(int value) {
        Node current = dummy.next;
        while (current != dummy) {
            if (current.data == value) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                return true;
            }

            current = current.next;

        }
        return false;
    }
}
