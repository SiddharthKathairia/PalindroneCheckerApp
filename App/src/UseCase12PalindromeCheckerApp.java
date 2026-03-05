import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String word);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String word) {

        Stack<Character> stack = new Stack<>();

        for(char ch : word.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";

        while(!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return word.equals(reversed);
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String word) {

        Deque<Character> deque = new LinkedList<>();

        for(char ch : word.toCharArray()) {
            deque.addLast(ch);
        }

        while(deque.size() > 1) {

            if(deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        // Choose strategy (Stack or Deque)
        PalindromeStrategy strategy = new StackStrategy();
        // PalindromeStrategy strategy = new DequeStrategy();

        boolean result = strategy.isPalindrome(word);

        if(result) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}