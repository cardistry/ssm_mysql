package sword59Ⅱ;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
}


class MaxQueue {
    public static void main(String[] args) {
        MaxQueue q = new MaxQueue();
        System.out.println(q.pop_front());
        System.out.println(q.pop_front());
        System.out.println(q.pop_front());
        System.out.println(q.pop_front());
        q.push_back(1);
        q.push_back(2);
        System.out.println(q.max_value());
        System.out.println(q.pop_front());
        System.out.println(q.max_value());
    }
    private Deque<Integer> queue;
    private Deque<Integer> pri;
    public MaxQueue() {
        queue = new LinkedList<>();
        pri = new LinkedList<>();
    }

    public int max_value() {
        if(queue.size() == 0)
            return -1;
        return pri.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while(!pri.isEmpty() && value > pri.getLast())
            pri.removeLast();
        pri.addLast(value);
    }

    public int pop_front() {
        if(queue.size() == 0)
            return -1;
        int res;
        if((res = queue.pollFirst())== pri.peekFirst())
            pri.removeFirst();
        return res;
    }
}