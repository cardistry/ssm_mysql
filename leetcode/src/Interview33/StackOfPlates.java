package Interview33;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackOfPlates {
    private int cap;
    List <Stack<Integer>> stackList;

    public StackOfPlates(int cap) {
        this.cap = cap;
        stackList = new ArrayList<>();
    }

    public void push(int val) {
        if(cap <= 0)
            return;
        if (stackList.isEmpty() || stackList.get(stackList.size()-1).size() == cap){
            Stack<Integer> stack = new Stack<>();
            stackList.add(stack);
        }
        stackList.get(stackList.size()-1).push(val);

    }

    public int pop() {
        return popAt(stackList.size() -1);


    }

    public int popAt(int index) {
        if(index < 0 || stackList.size() <= index)
            return -1;
        Stack<Integer> stack = stackList.get(index);
        if(stack.isEmpty())
            return -1;
        int res = stack.pop();
        if(stack.isEmpty())
            stackList.remove(index);
        return res;
    }


}

