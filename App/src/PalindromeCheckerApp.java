import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class PalindromeCheckerApp {
    public static boolean isPalindrome(String input) {
        // Normalize input: remove spaces and make lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        // Add all characters to the deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);  // Insert at rear
        }

        // Compare front and rear characters until deque is empty or mismatch
        while (deque.size() > 1) {
            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear

            if (front != rear) {
                return false; // Not a palindrome
            }
        }

        return true; // Palindrome
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC7: Deque-Based Optimized Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome!");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();

    }
}

