import java.util.Scanner;

public class PalindromeCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert string to linked list
    public static Node stringToLinkedList(String input) {
        Node head = null;
        Node tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    // Reverse a linked list
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // Check if linked list is palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // Empty or single node is palindrome
        }

        // Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseList(slow.next);

        // Compare first and second half
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Restore original list
        slow.next = reverseList(secondHalf);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Normalize input: remove spaces and lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        Node head = stringToLinkedList(input);

        if (isPalindrome(head)) {
            System.out.println("The string \"" + input + "\" is a palindrome!");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}