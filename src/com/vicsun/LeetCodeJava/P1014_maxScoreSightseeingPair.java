package com.vicsun.LeetCodeJava;

public class P1014_maxScoreSightseeingPair {
    /**
     * 题目是 有顺序限制的 i必须在j左边
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int mx = A[0] + 0;  // i
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, mx + A[j] - j);

            mx = Math.max(mx, A[j] + j);


        }
        return res;
    }


    public int maxScore2(int []A){
        int ans=0;
        int mx=A[0]+0;




        return ans;
    }


}
