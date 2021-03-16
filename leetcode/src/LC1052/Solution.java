package LC1052;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0,res = 0;
        for (int i = 0; i < X; i++)
            res += customers[i];
        sum = res;
        for (int i = 0; i < customers.length; i++)
            sum += customers[i] * grumpy[i];
        return  res;

    }
}