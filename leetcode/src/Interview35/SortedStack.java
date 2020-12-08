package Interview35;

import java.util.Stack;

//优化代码
class SortedStack {
    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.push(1);
        s.push(2);
        s.peek();
        s.pop();
        s.peek();
    }
    Stack<Integer> stack;
    Stack<Integer> helpStack;
    public SortedStack() {
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int val) {
        while (!helpStack.isEmpty() && helpStack.peek() > val)
            stack.push(helpStack.pop());
        while (!stack.isEmpty() && stack.peek() < val)
            helpStack.push(stack.pop());
        stack.push(val);
    }

    public void pop() {
        while (!helpStack.empty()) {
            stack.push(helpStack.pop());
        }
        if (!isEmpty())
            stack.pop();
    }

    public int peek() {
        while (!helpStack.empty()) {
            stack.push(helpStack.pop());
        }
        if (isEmpty())
            return -1;
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.empty();
    }
}
