package BackUp.graduated.P06_String;

/**
 * @Author:vic
 * @Date:21-4-13
 * @Content: 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class P0413_151reverseWords {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int right = s.length() - 1;
        int left = right;

        while (left >= 0) {
            while (right >= 0 && s.charAt(right) == ' ')
                right--;//right最后指向的位置是非空的最后一个
            left = right;
            while (left >= 0 && s.charAt(left) != ' ')
                left--;//left最后指向的位置是一个空格

            builder.append(s.substring(left + 1, right + 1) + " ");//包左不包右

            right = left;//继续下一轮
        }
        return builder.toString().trim();
    }
}
