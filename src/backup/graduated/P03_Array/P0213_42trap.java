package backup.graduated.P03_Array;

public class P0213_42trap {
    public int trap(int[] height) {
        int ans=0;
        int size= height.length;
        for (int i = 1; i < size-1; i++) {
            int max_left=0; int max_right=0;
            for (int j = i; j >=0 ; j--) {
                max_left=Math.max(max_left, height[j]);
            }
            for (int j = i; j <size ; j++) {
                max_right=Math.max(max_right, height[j]);
            }

            ans +=Math.min(max_left, max_right)-height[i];
        }

        return ans;
    }

}
