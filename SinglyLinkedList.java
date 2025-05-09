// Node class
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }
}

class SinglyLinkedList {
    Node head;
    Node tail;
    int size;

    SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size += 1;
    }

    void insertAt(int position, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
            return;
        }

        if (position >= size) {
            tail.next = newNode;
            tail = newNode;
            size += 1;
            return;
        }

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            size += 1;
            return;
        }

        int index;
        Node current;
        for (index = 0, current = head; index < position - 1; index++, current = current.next);
        newNode.next = current.next;
        current.next = newNode;
        size += 1;
    }

    void delete(int valueToDelete) {
        if (head == null)
            return;

        Node current = null;
        Node previous = null;

        for (current = head; current != null && current.value != valueToDelete; previous = current, current = current.next);

        if (current == null) {
            System.out.println("Value Not Found!!!!!!");
            return;
        }

        if (previous == null) {
            head = head.next;
            size -= 1;
            if (head == null)
                tail = null;
            return;
        }

        previous.next = current.next;

        if (current == tail)
            tail = previous;

        size -= 1;
    }

    void printList() {
        Node current;
        for (current = head; current != null; current = current.next) {
            System.out.printf("%d ", current.value);
        }
        System.out.println();
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }
}

class LinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(32);
        list.append(16);
        list.append(17);
        list.append(20);
        list.append(39);
        list.printList();

        list.insertAt(3, 33);
        list.printList();

        list.insertAt(0, 0);
        list.printList();

        list.insertAt(70, 70);
        list.printList();

        list.delete(20);
        list.printList();

        list.delete(0);
        list.printList();

        list.delete(70);
        list.printList();

        list.delete(20);
        list.printList();

        list.reverse();
        list.printList();
    }
}
