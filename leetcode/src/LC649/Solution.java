package LC649;

class Solution {
    public String predictPartyVictory(String senate) {
        int length = senate.length();
        char[] str = senate.toCharArray();
        int countR = 0, countD = 0;             //R D 剩余席位
        int loseR = 0, loseD = 0;               //R D 待ban席位

        for(int i = 0; i < length; i++){
            if(str[i] == 'R'){
                countR++;
            }
        }
        countD = length - countR;

        int ind = 0;
        while(ind < length){
            if(str[ind] == 'R'){                //R议员
                if(loseR > 0){                  //  R待ban不为零
                    str[ind] = ' ';             //    ban掉R
                    loseR--;                    //    R待ban减一
                }else{                          //  R待ban为零
                    countD--;                   //    D剩余席位减一
                    loseD++;                    //    D待ban加一
                    if(countD < 1){             //    D剩余小于1宣布R胜
                        return "Radiant";
                    }
                }

            }else if(str[ind] == 'D'){
                if(loseD > 0){
                    str[ind] = ' ';
                    loseD--;
                }else{
                    countR--;
                    loseR++;
                    if(countR < 1){
                        return "Dire";
                    }
                }
            }
            ind++;
            if(ind == length){
                ind = 0;
            }
        }

        return null;
    }
}
