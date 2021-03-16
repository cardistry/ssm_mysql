package Interview17_20;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> small;
    Queue<Integer> big;
    public MedianFinder() {
        small = new PriorityQueue();
        big = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; }
        } );
    }

    public void addNum(int num) {
        if(small.size() > big.size()){
            if(num < small.peek())
                big.add(num);
            else{
                small.add(num);
                big.add(small.poll());
            }
        }

        else{
            if(big.size() == 0 || num < big.peek()){
                big.add(num);
                small.add(big.poll());
            }
            else
                small.add(num);


        }

    }

    public double findMedian() {
        if(small.size() > big.size())
            return (double)small.peek();
        else
            return (double)(small.peek() + big.peek()) / 2.0;



    }
}