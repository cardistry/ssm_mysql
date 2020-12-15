package LC860;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int [2];
        for(int pay:bills){
            if(pay == 20){
                if(money[1] > 0 && money[0] > 0){
                    money[1]--;
                    money[0]--;
                }
                else if (money[0] > 2)
                    money[0] -= 3;
                else
                    return false;

            }
            else if(pay == 10){
                if(money[0] > 0){
                    money[1]++;
                    money[0]--;
                }
                else
                    return false;
            }
            else
                ++money[0];
        }
        return true;
    }

}