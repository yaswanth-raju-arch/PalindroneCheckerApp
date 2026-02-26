public class PalindromeCheckerApp {


    public static void main(String[] args){

// Original String (Hardcoded)
        String word = "radar";

        // Step 1: Convert String to char array
        char[] charArray = word.toCharArray();

        // Step 2: Initialize two pointers
        int start = 0;
        int end = charArray.length - 1;

        boolean isPalindrome = true;

        // Step 3: Compare characters using two-pointer technique
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Step 4: Display Result
        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");


    }
}