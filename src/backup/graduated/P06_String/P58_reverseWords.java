package BackUp.graduated.P06_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P58_reverseWords {
    public String reverseWords1(String s) {
        StringBuilder builder= new StringBuilder();
        String[] str = s.trim().split("\\s+");
        for (int i = str.length-1; i >=0 ; i--) {
            builder.append(str[i]+" ");

        }

        return builder.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
    public String reverseWords(String s) {
        s=s.trim();//去除首位空格
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);

    }
    public static void main(String[] args) {
        System.out.println(new P58_reverseWords().reverseWords("the sky is blue"));;
    }
}
