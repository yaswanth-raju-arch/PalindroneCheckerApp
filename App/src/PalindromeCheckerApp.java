import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        // Base condition: If left index crosses right, string is a palindrome
        if (left >= right) {
            return true;
        }
        // If characters at current positions don't match, not a palindrome
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        // Recursive call: move inward
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Recursive Palindrome Checker - UC9 ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine().replaceAll("\\s+", "").toLowerCase(); // ignore spaces and case

        boolean result = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("\nResult: The string \"" + input + "\" is " +
                (result ? "a palindrome." : "not a palindrome."));
    }
}