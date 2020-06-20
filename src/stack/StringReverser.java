package stack;

import java.util.Stack;

public class StringReverser {

    private final Stack<Character> stack = new Stack<>();
    private final String input;

    public StringReverser(String input) {
        this.input = input;
    }

    public String reverse() {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        for (char character : input.toCharArray()) {
            stack.push(character);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
