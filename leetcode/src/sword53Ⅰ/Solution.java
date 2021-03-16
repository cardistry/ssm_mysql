package sword53Ⅰ;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int s = 0;
        boolean flag = false;
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            flag = false;
            for (int j = 0; j < n; j++) {
                int cur = sc.nextInt();
                if(j == 0)
                    s = cur;
                if(cur >= k + s + j){
                    System.out.println(s + j);
                    flag = true;
                    break;
                }

            }
            if(!flag)
                System.out.println(s + n + k - 1);
        }

    }
}

