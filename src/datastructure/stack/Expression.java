package datastructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    private final Stack<Character> stack = new Stack<>();
    private final String input;

    public Expression(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        for (char character : input.toCharArray()) {
            if (isLeftBracket(character)) {
                stack.push(character);
            }

            if (isRightBracket(character)) {
                if (stack.empty()) {
                    return false;
                }

                char topCharacter = stack.pop();
                if (!bracketsMatch(topCharacter, character)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char character) {
        return leftBrackets.contains(character);
    }

    private boolean isRightBracket(char character) {
        return rightBrackets.contains(character);
    }

    private boolean bracketsMatch(char leftBracket, char rightBracket) {
        return leftBrackets.indexOf(leftBracket) == rightBrackets.indexOf(rightBracket);
    }
}
