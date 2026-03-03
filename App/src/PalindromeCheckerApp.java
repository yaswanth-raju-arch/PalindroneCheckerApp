import java.util.*;

// 🔹 Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// 🔹 Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// 🔹 Deque-Based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// 🔹 Context Class
class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.checkPalindrome(input);
    }
}

// 🔹 Main Application Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome Checker ===");
        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.execute(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}