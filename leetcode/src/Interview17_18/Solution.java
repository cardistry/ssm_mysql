package Interview17_18;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        int n = big.length, m = small.length;
        if (n < m) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int x : small) {
            map.put(x, 1);
        }
        // 双指针左端点
        int l = 0;
        // 已经找出多少个数
        int cnt = 0;
        // 记录答案
        int ans = n + 1, x = -1, y = -1;
        // 枚举双指针右端点
        for (int r = 0; r < n; r++) {
            Integer num = map.get(big[r]);
            if (num == null) {
                continue;
            }
            num--;
            map.put(big[r], num);
            if (num == 0) {
                cnt++;
            }
            if (cnt == m) {
                while (l < r) {
                    num = map.get(big[l]);
                    if (num != null) {
                        num++;
                        if (num > 0) {
                            break;
                        }
                        map.put(big[l], num);
                    }
                    l++;
                }
                if (ans > r - l + 1) {
                    ans = r - l + 1;
                    x = l;
                    y = r;
                }
            }
        }
        if (ans == n + 1) {
            return new int[0];
        }
        return new int[]{x, y};
    }
}

