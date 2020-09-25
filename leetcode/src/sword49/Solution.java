package sword49;
class Solution {
    public int nthUglyNumber(int n) {
        int indexto,indexth,indexf;
        indexf = indexth = indexto = 0;
        int[] record = new int[n];
        record[0] = 1;
        for(int i = 1; i < n; ++i){
            record[i] = Math.min(record[indexto] * 2,Math.min(record[indexf]* 5,record[indexth] * 3));
            if(record[i] == record[indexto] * 2)
                ++indexto;
            if(record[i] == record[indexf] * 5)
                ++indexf;
            if(record[i] == record[indexth] * 3)
                ++indexth;
        }
        return record[n-1];
    }
}