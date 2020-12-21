package Interview10_05;

class Solution {
    public int findString(String[] words, String s) {
        //左边界为第0项，右边界为最后一项
        int left = 0, right = words.length - 1;
        int mid;
        int temp;

        while(left <= right){  //二分查找循环终止条件
            mid = left + (right - left)/2;
            temp = mid;
            //处理空字符串
            //两个条件不能换位置，不然mid超过右边界时words[mid]会报越界错误
            while(mid <= right &&words[mid].equals("")){
                mid++;    //若words[mid]一直为空字符串则mid一直加一，直到mid超过右边界或words[mid]为非空
            }
            if(mid == right+1){  //若mid超出右边界(即为右边界+1), 说明mid至right处都为空字符串
                right = temp - 1; //压缩右边界
                continue;   //进行下一次循环
            }
            //确定mid位置后，普通二分查找思路判断
            if(words[mid].equals(s)){
                return mid;
            }else if(words[mid].compareTo(s) > 0){
                right = mid -1;
            }else if(words[mid].compareTo(s) < 0){
                left = mid + 1;
            }
        }
        return -1;
    }
}

