package LC321;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxNumber(new int[]{6,7},new int[]{6,0,4}, 5);
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start = Math.max(k - nums2.length,0);
        int end = Math.min(k,nums1.length);
        int []maxSequence = new int[k];
        for (int i = start; i <= end; i++) {
            int []a = maxSubQuence(nums1,i);
            int []b = maxSubQuence(nums2,k-i);
            int []result = merge(a,b);
            if(compare(result,0,maxSequence,0) > 0){
                System.arraycopy(result,0,maxSequence,0,k);
            }
        }
        return maxSequence;
    }

    private int compare(int[] s1, int k1,int[] s2,int k2) {
        int length1 = s1.length;
        int length2 = s2.length;
        while (k1 < length1 && k2 < length2){
            int difference = s1[k1] -s2[k2];
            if(difference != 0)
                return difference;
            k1++;
            k2++;
        }
        return (length1 - k1)-(length2 - k2);
    }

    private int[] merge(int[] a, int[] b) {
        if(a.length == 0)
            return b;
        if(b.length == 0)
            return a;
        int length = a.length + b.length;
        int indexa = 0,indexb = 0,index = 0;
        int []res = new int[length];
        while (indexa < a.length && indexb < b.length){
            if(compare(a,indexa,b,indexb) > 0)
                res[index++] = a[indexa++];
            else
                res[index++] = b[indexb++];
        }
        while (indexb < b.length)
            res[index++] = b[indexb++];
        while (indexa < a.length)
            res[index++] = a[indexa++];
        return res;
    }

    private int[] maxSubQuence(int[] nums1, int k) {
         int remain = nums1.length - k;
         int top = 0;
         int[] stack = new int[k];
        for (int i = 0; i < nums1.length; i++) {
            while (top > 0 && stack[top-1] < nums1[i] && remain > 0){
                top--;
                remain--;
            }
            if(top < k)
                stack[top++] = nums1[i];
            else
                remain--;
        }
        return stack;
    }
}