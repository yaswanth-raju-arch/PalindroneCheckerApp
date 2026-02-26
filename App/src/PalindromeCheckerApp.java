public class PalindromeCheckerApp {


    public static void main(String[] args){

// Original String
        String original = "racecar";

        // Variable to store reversed string
        String reversed = "";

        // Reverse string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed using equals()
        if (original.equals(reversed)) {
            System.out.println("The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }

        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + reversed);
        System.out.println("Program executed successfully.");

    }
}