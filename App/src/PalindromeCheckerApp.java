import java.util.Scanner;

public class PalindromeCheckerApp {

    // Approach 1: Iterative comparison
    public static boolean isPalindromeIterative(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Using StringBuilder reverse
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Approach 3: Recursive method
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - Performance Comparison ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine().replaceAll("\\s+", "").toLowerCase();

        // Iterative
        long startIterative = System.nanoTime();
        boolean resultIterative = isPalindromeIterative(input);
        long endIterative = System.nanoTime();

        // Reverse
        long startReverse = System.nanoTime();
        boolean resultReverse = isPalindromeReverse(input);
        long endReverse = System.nanoTime();

        // Recursive
        long startRecursive = System.nanoTime();
        boolean resultRecursive = isPalindromeRecursive(input, 0, input.length() - 1);
        long endRecursive = System.nanoTime();

        System.out.println("\n--- Results ---");
        System.out.println("Iterative method: " + resultIterative + " | Time: " + (endIterative - startIterative) + " ns");
        System.out.println("Reverse method: " + resultReverse + " | Time: " + (endReverse - startReverse) + " ns");
        System.out.println("Recursive method: " + resultRecursive + " | Time: " + (endRecursive - startRecursive) + " ns");
    }
}