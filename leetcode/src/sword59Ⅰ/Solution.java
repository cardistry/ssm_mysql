package sword59Ⅰ;

import java.util.Deque;
import java.util.LinkedList;

class MonotonousQueue{

    Deque<Integer> deque = new LinkedList<>();
    void pop(Integer num){
        if(deque.peekFirst() == num)
            deque.removeFirst();
    }
    void push(Integer num){
        while(!deque.isEmpty() && deque.peekLast() < num)
            deque.removeLast();
        deque.addLast(num);

    }
    int front(){
        return deque.peekFirst();
    }
}



class Solution {
    public static void main(String[] args) {
        new Solution().maxSlidingWindow(new int[]{4,2,1,3},3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k==0)
            return new int[0];
        MonotonousQueue myQueue = new MonotonousQueue();
        int [] res  = new int[nums.length - k + 1];
        for(int i = 0 ; i < k; ++i)
            myQueue.push(nums[i]);
        res[0] = myQueue.front();
        for(int i = k;i < nums.length; ++i){
            myQueue.pop(nums[i-k]);
            myQueue.push(nums[i]);
            res[i - k + 1] = myQueue.front();
        }
        return res;

    }
}




class Solution2{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k==0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int [] res  = new int[nums.length - k + 1];
        for(int i = 0 ; i < k; ++i){
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k;i < nums.length; ++i){
            if(!deque.isEmpty() && deque.peekFirst() == nums[i-k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;

    }
}