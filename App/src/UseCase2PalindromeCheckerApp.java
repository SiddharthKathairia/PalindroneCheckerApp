public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";
        String reverse = "";

        for(int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        if(word.equals(reverse)) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }

    }
}