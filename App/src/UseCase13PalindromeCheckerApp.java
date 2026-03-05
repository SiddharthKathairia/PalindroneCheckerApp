import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    // Method 1: Two Pointer Method
    public static boolean checkUsingTwoPointer(String word) {

        int start = 0;
        int end = word.length() - 1;

        while(start < end) {

            if(word.charAt(start) != word.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Method 2: Stack Method
    public static boolean checkUsingStack(String word) {

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

    // Method 3: Deque Method
    public static boolean checkUsingDeque(String word) {

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

    public static void main(String[] args) {

        String word = "madam";

        long startTime;
        long endTime;

        // Two Pointer Algorithm
        startTime = System.nanoTime();
        boolean result1 = checkUsingTwoPointer(word);
        endTime = System.nanoTime();
        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");

        // Stack Algorithm
        startTime = System.nanoTime();
        boolean result2 = checkUsingStack(word);
        endTime = System.nanoTime();
        System.out.println("Stack Result: " + result2);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");

        // Deque Algorithm
        startTime = System.nanoTime();
        boolean result3 = checkUsingDeque(word);
        endTime = System.nanoTime();
        System.out.println("Deque Result: " + result3);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}