package stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        StringReverser stringReverser = new StringReverser("Hello World");
        System.out.println(stringReverser.reverse());

        Expression expression = new Expression("[(1 + 2)] + {3 + 4}");
        System.out.println(expression.isBalanced());
    }
}
