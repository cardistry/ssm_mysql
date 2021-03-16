package LC224;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" 2-1 + 2 "));
    }
    public int calculate(String s) {
        List<String> str =  transfer(s);
        Stack<Integer> stack = new Stack<>();
        for(String c : str){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calValue(c,a,b));
            }
            else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();

    }

    private  List<String> transfer(String s){
        Stack<String> cal = new Stack<>();
        List<String> num = new LinkedList<>();
        StringBuilder tmp = new StringBuilder();
        int index = 0;
        while (index < s.length()){
            Character c = s.charAt(index);
            if(Character.isDigit(c)){
                StringBuilder tmpnum = new StringBuilder();
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    tmpnum.append(s.charAt(index++));
                num.add(tmpnum.toString());
                continue;
            }
            else if(c == '(')
                cal.push("(");
            else if(c == ')'){
                while(!cal.peek().equals("("))
                    num.add(cal.pop());
                cal.pop();
            }
            else if(c == ' '){
                ++index;
                continue;
            }
            else{
                if(c == '-' && (index == 0 || s.charAt(index - 1) == '(' ))
                    num.add("0");
                while(!cal.isEmpty() && cal.peek()!= "(" && getPriority(c+"") <= getPriority(cal.peek()))
                    num.add(cal.pop());
                cal.push(c+"");
            }
            ++index;
        }
        while(!cal.isEmpty())
            num.add(cal.pop());
        return num;

    }

    private int getPriority(String c){
        switch(c){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 100;
        }
    }
    private int calValue(String c,int a, int b){
        switch(c){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return  0;
        }
    }


}