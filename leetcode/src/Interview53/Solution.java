package Interview53;


class Solution {
    public int reverseBits(int num) {
        char[] arr=Integer.toBinaryString(num).toCharArray();
        int[] ints=new int[arr.length+2];
        ints[0]=-1;
        int k=1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='0'){
                ints[k++]=i;
            }
        }
        ints[k]=arr.length;
        int max=0;
        if(k==1){
            return ints[1]-ints[0];
        }
        for(int i=1;i<k;i++){
            if((ints[i+1]-ints[i-1]-1)>max){
                max=ints[i+1]-ints[i-1]-1;
            }
        }
        return max;
    }
}

