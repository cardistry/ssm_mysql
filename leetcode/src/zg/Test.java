package zg;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = 0;

        int[][] relation = new int[10001][2];
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            relation[i][0] = sc.nextInt();
            relation[i][1] = sc.nextInt();
        }
        q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.println(new Test().isReached(relation, sc.nextInt(), sc.nextInt(), m, n, visited));

        }

    }
    public boolean isReached(int[][] realation,int from,int to,int m,int n,Set<Integer> visited){
        for (int i = 0; i <= m; i++) {
            if(realation[i][0] == from ){
                int next = realation[i][1];
                if(next == to)
                    return true;
                if(!visited.contains(next)){
                    visited.add(next);
                    return isReached(realation,next,to,m,n,visited);
                }
                visited.remove(next);
            }
        }
        return false;
    }
}
