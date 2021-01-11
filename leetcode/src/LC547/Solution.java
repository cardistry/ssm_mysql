package LC547;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        new Solution().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}});
    }



    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        if(N == 0)
            return 0;
        int [] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(isConnected[i][j] == 1){
                    join(i,j,res);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            set.add(findParent(res,res[i]));
        }
        return set.size();
    }

    int findParent(int[] rec, int cur){
        return cur == rec[cur] ? cur : (rec[cur] = findParent(rec,rec[cur]));
    }

    void join(int u,int v,int []rec){
        u = findParent(rec,u);
        v = findParent(rec,v);
        if(u == v)
            return;
        rec[v] = u;
    }
}
