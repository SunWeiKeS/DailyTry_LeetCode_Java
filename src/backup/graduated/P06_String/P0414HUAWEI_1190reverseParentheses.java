package backup.graduated.P06_String;

import java.util.Stack;

public class P0414HUAWEI_1190reverseParentheses {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        String s= "a(bcdefghijkl(mno)p)q";
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='('){
                stack.push(i);
            }else if(chars[i]==')'){
                //doing something
                reverse(chars,stack.pop()+1,i-1);
            }
        }
        for (char demo : chars) {
            if(demo!='('&&demo!=')'){
                res.append(demo);
            }
        }
        System.out.println(res.toString().trim());;
    }
    public static void reverse(char[]arr,int start,int end){
        while (end>start){
            char tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            end--;
            start++;
        }
    }


}





















