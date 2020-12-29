package Interview17_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, String> map;
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> cnt = new HashMap<>();
        map = new HashMap<>();
        for(String name : names) {
            int i = 0;
            while(name.charAt(i) != '(')
                i++;
            map.put(name.substring(0, i), name.substring(0, i));
        }
        for(String name : synonyms) {
            String[] temp = name.split(",");
            String x = temp[0].substring(1, temp[0].length());
            String y = temp[1].substring(0, temp[1].length() - 1);
            if(!map.containsKey(x)) map.put(x, x);
            if(!map.containsKey(y)) map.put(y, y);
            // 获得两个集合的根
            String fx = find(x);
            String fy = find(y);
            // 合并两个并查集，将字典序小的根作为新的根
            if(!fx.equals(fy)){
                if(fx.compareTo(fy) > 0) map.put(fx, fy);
                else map.put(fy, fx);
            }
        }
        for(String name : names) {
            int i = 0;
            while(name.charAt(i) != '(') i++;
            // 将数值都累加到根的位置
            String root = find(name.substring(0, i));
            cnt.put(root, cnt.getOrDefault(root, 0) + Integer.parseInt(name.substring(i + 1, name.length() - 1)));
        }
        List<String> res = new ArrayList<>();
        for(String name : names) {
            int i = 0;
            while(name.charAt(i) != '(') i++;
            String root = find(name.substring(0, i));
            // 只输出根
            if(!root.equals(name.substring(0, i))) continue;
            res.add(root + "(" + String.valueOf(cnt.get(root)) + ")");
        }
        return res.toArray(new String[res.size()]);
    }
    // 查根
    public String find(String x) {
        if(!map.get(x).equals(x)) {
            map.put(x, find(map.get(x)));
        }
        return map.get(x);
    }
}

