package Interview17_11;

class Solution {
    //字典法
//    public int findClosest(String[] words, String word1, String word2) {
//        Map<String, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++){
//            map.putIfAbsent(words[i],new ArrayList<>());
//            map.get(words[i]).add(i);
//        }
//
//        List<Integer> list1 = map.get(word1);
//        List<Integer> list2 = map.get(word2);
//        int min = Integer.MAX_VALUE;
//        int i = 0,j = 0;
//        while (i < list1.size() && j < list2.size()){
//            int gap =  list1.get(i) - list2.get(j);
//            min = Math.min(min,Math.abs(gap));
//            if(gap > 0)
//                ++j;
//            else
//                ++i;
//        }
//        return min;
//    }
    //双指针法
    public int findClosest(String[] words, String word1, String word2) {
        int flag = 0;
        int index1 = 0,index2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)){
                index1 = i;
                if(flag == 2){
                    min = Math.min(min,i - index2);
                }
                flag = 1;
            }
            else if(words[i].equals(word2)){
                index2 = i;
                if(flag  == 1){
                    min = Math.min(min,i - index1);
                }
                flag = 2;
            }
        }
        return min;
    }
}
