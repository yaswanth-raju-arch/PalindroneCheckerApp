import java.util.Scanner;

// 🔹 Palindrome Service Class (Encapsulated Logic)
class PalindromeChecker {

    // Public method exposed to outside world
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize string (ignore spaces and case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Internal Data Structure: Character Array
        char[] characters = normalized.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            if (characters[left] != characters[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

// 🔹 Main Application Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Create object of PalindromeChecker
        PalindromeChecker palindromeChecker = new PalindromeChecker();

        boolean result = palindromeChecker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}