import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {
    // Method to check palindrome using Stack and Queue
    public static boolean isPalindrome(String input) {
        // Normalize input: remove spaces and make lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue and push all characters
        for (char ch : input.toCharArray()) {
            queue.add(ch);  // FIFO
            stack.push(ch); // LIFO
        }

        // Compare dequeue and pop
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                return false; // Not a palindrome
            }
        }

        return true; // Palindrome
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC6: Queue + Stack Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string \"" + input + "\" is a palindrome!");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();


    }
}

