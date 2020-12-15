package Interview52;

class Solution {
    public String printBin(double num) {
        StringBuilder s = new StringBuilder("0.");
        for (int i = 0; i < 32; i++) {
            num *= 2;
            if(num >= 1){
                s.append(1);
                num -= 1;
            }
            else
                s.append(0);
            if(num == 0)
                return s.toString();
        }
        return "ERROR";
    }
}