import java.util.Scanner;
import java.util.Random;

class Node {
    Node previous;
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        previous = null;
        next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    void add(int value) {
        Node newNode = new Node(value);
        size += 1;

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        Node current;
        for (current = head; current != null && newNode.value > current.value; current = current.next);

        // Insert at start
        if (current == head) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        // Insert in the middle
        else if (current != null) {
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        // Insert at end
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    void delete(int valueToDelete) {
        if (head == null) return;

        Node current;
        for (current = head; current != null && current.value < valueToDelete; current = current.next);

        if (current == null || current.value > valueToDelete) {
            System.out.println("Value Not Found!!!!!!");
            return;
        }

        // Delete from start
        if (current == head) {
            head = head.next;
            if (head != null) head.previous = null;
            else tail = null; // list became empty
        }
        // Delete from end
        else if (current == tail) {
            tail = tail.previous;
            if (tail != null) tail.next = null;
            else head = null; // list became empty
        }
        // Delete from middle
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size -= 1;
    }

    void printForward() {
        Node current;
        for (current = head; current != null; current = current.next) {
            System.out.printf("%d ", current.value);
        }
        System.out.println();
    }

    void printBackward() {
        Node current;
        for (current = tail; current != null; current = current.previous) {
            System.out.printf("%d ", current.value);
        }
        System.out.println();
    }
}

public class DoublyLinkedListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        int numberOfElements = scanner.nextInt();

        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(random.nextInt(100));
        }

        list.printForward();
        list.printBackward();

        int deleteValue;

        deleteValue = scanner.nextInt();
        list.delete(deleteValue);
        list.printForward();

        deleteValue = scanner.nextInt();
        list.delete(deleteValue);
        list.printForward();

        deleteValue = scanner.nextInt();
        list.delete(deleteValue);
        list.printForward();

        DoublyLinkedList newList = list;
        System.out.println("after\n\n\n\n");
        newList.printForward();
    }
}
