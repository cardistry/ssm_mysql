package Interview16_16;

public class Solution {
    public static void main(String[] args) {
        new Solution().subSort(new int[]{1,3,9,7,5});
    }
    public int[] subSort(int[] array) {
       int index = 0;
       while (index < array.length - 1 && array[index] <= array[index + 1])
            ++index;
       int m  = index;
       if(m == array.length - 1 || array.length == 0)
           return new int[]{-1,-1};
       index  = array.length - 1;
       while (index > 0 && array[index] >= array[index - 1] && array[index] >= array[m])
           --index;
       int n = index;
       int min = array[n],max = array[n];
       for (int i = m + 1; i <= n; i++) {
            if(array[i] < min)
                min = array[i];
            else if(array[i] > max)
                max = array[i];
       }
       while (m >= 0){
           if(array[m] > min)
               m--;
           else
               break;
       }
       while (n < array.length){
           if(array[n] < max)
               ++n;
           else
               break;
       }
       return new int[]{m+1,n-1};
    }
}