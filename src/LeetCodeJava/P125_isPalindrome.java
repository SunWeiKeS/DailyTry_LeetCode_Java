package LeetCodeJava;



/**
 * 首先要去除非法字符
 * 然后开始判断回文子
 *
 * while循环从左右两边遍历即可
 */
public class P125_isPalindrome {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;

        while (left<right){
            while (left<right&& !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left<right&& !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";

    }

}
