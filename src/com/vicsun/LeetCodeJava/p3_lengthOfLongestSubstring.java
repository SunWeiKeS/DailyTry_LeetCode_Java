package com.vicsun.LeetCodeJava;

import java.util.HashSet;
import java.util.Set;

public class p3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //利用滑动窗口求解
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;// i j 是滑动窗口指针 一前一后

        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));

                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));

            }
        }

        return res;
    }

    public static void main(String[] args) {
        p3_lengthOfLongestSubstring substring = new p3_lengthOfLongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring("1234456789"));
    }
}
