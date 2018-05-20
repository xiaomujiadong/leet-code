package com.saint.mid.string;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。

 示例 1:

 输入: "3+2*2"
 输出: 7
 示例 2:

 输入: " 3/2 "
 输出: 1
 示例 3:

 输入: " 3+5 / 2 "
 输出: 5
 */
public class Calculate {
    public static int calculate(String s) {
        Stack<Integer> number = new Stack<Integer>();
        Stack<String> operator = new Stack<String>();

        if(!s.contains("+") && !s.contains("-") && !s.contains("*") && !s.contains("/") ){
            return Integer.valueOf(s.trim());
        }

        boolean lastNumber = false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if('0'<=c && c<='9'){
                int newNumber = (int)c - 48;
                if(lastNumber){
                    newNumber = number.pop()*10+newNumber;
                }
                number.push(newNumber);
                lastNumber = true;
                continue;
            }else if(c == '-' || c == '+'){
                operator.push(c+"");
            }else if(c == '*'){
                int nextNumber= 0;
                int j = i+1;
                while(true){
                    char ct = s.charAt(j);
                    if('0'<=ct && ct<='9'){
                        nextNumber = nextNumber*10 + (int)s.charAt(j)- 48;
                        if(j+1<s.length() ){
                            char cnt = s.charAt(j+1);
                            if( '0'<=cnt && cnt<='9'){
                                j = j+1;
                                continue;
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                    ++j;
                }
                int temp = number.pop() * nextNumber;
                number.push(temp);
                i = j;
            }else if(c == '/' ){
                int nextNumber = 0 ;
                int j = i+1;
                while(true){
                    char ct = s.charAt(j);
                    if('0'<=ct && ct<='9'){
                        nextNumber = nextNumber*10 + (int)s.charAt(j)- 48;
                        if(j+1<s.length() ){
                            char cnt = s.charAt(j+1);
                            if( '0'<=cnt && cnt<='9'){
                                j = j+1;
                                continue;
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                    ++j;
                }
                int temp = number.pop() / nextNumber;
                number.push(temp);
                i = j;
            }
            lastNumber = false;
        }

        while (!operator.isEmpty()){
            String operat = operator.pop();
            if(!operator.isEmpty()){
                String nextOp = operator.pop();
                if(nextOp.equals("-")){
                    if(operat.equals("+")){
                        operat =  "-";
                    }else{
                        operat = "+";
                    }
                }
                operator.push(nextOp);
            }

            if(operat.equals("+")){
                int result = number.pop() + number.pop();
                number.push(result);
            }else {
                int temp = number.pop();
                int result = number.pop() - temp;
                number.push(result);
            }
        }
        return number.pop();
    }

    public static int best(String s){
        int[] operationPool = new int[s.length() / 2 + 2];
        int index = -1;
        int sum = 0;

        for(int i = 0, num = 0, len = s.length(); i < len; i++){

            char ch = s.charAt(i);
            if(i == len - 1){
                if(ch >= '0' && ch <= '9'){
                    num = num * 10 + ch - '0';
                }
                if(num <= 0){
                    break;
                }
            } else if(ch == ' '){
                continue;
            } else if(ch >= '0' && ch <= '9'){
                num = num * 10 + ch - '0';
                continue;
            }

            if(index > 0){
                if(operationPool[index] == -'*'){
                    operationPool[--index] *= num;
                } else if(operationPool[index] == -'/'){
                    operationPool[--index] /= num;
                } else if(operationPool[index] == -'+'){
                    operationPool[index] = num;
                } else {
                    operationPool[index] = -num;
                }
            } else {
                operationPool[++index] = num;
            }

            operationPool[++index] = -ch;
            num = 0;
        }

        for(int i = 0; i < index; i++){
            sum += operationPool[i];
        }

        return sum;
    }

    public static void main(String[] args){
        String str = "1*2-3/4+5*6-7*8+9/10";
        System.out.println("result: "+calculate(str));
    }
}
