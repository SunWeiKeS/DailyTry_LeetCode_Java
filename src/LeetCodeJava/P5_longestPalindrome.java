package LeetCodeJava;

/**
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */

public class P5_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] str = s.toCharArray();
        int[] range = new int[2];
        for (int i = 0; i < str.length; i++) {
            i = findelongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);

    }

    public static int findelongest(char[] str, int low, int[] range) {

        int high = low;
        while (high < str.length - 1 && str[low] == str[high + 1]) {
            high++;
        }//找中间
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }//找到了当前最大回文串

        //更新range
        if (high - low > range[1] - range[0]) {
            range[1] = high;
            range[0] = low;
        }
        return ans;//返回下一次更新的位置
    }

}
