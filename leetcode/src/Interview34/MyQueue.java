package Interview34;

import java.util.Stack;

class MyQueue {
    Stack<Integer> In;
    Stack<Integer> Out;

    /** Initialize your data structure here. */
    public MyQueue() {
        In = new Stack<>();
        Out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        In.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty())
            return  -1;
        if(Out.isEmpty()){
            while (!In.isEmpty()){
                Out.push(In.pop());
            }
        }
        return Out.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(empty())
            return  -1;
        if(Out.isEmpty()){
            while (!In.isEmpty()){
                Out.push(In.pop());
            }
        }
        return Out.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return In.isEmpty() && Out.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */