package Interview16_10;

class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] alive = new int[102];
        for (int i = 0; i < birth.length; i++) {
            int from = birth[i];
            int to = death[i];
            alive[from - 1900]+=1;
            alive[to - 1900 + 1]-=1;

        }
        int max = 0,maxyear = 1900,cur = 0;
        for (int i = 0; i < 101; i++) {
            cur += alive[i];
            if(cur > max){
                max = cur;
                maxyear = i + 1900;
            }
        }
        return maxyear;
    }
}