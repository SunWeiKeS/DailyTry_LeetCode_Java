package backup.graduated.P03_Array;

public class P0301_88merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //创建新的数组
        int[]new_nums= new int[m+n];
        int p1=0;
        int p2=0;
        int cur=0;

        while (p1<m&&p2<n){
            if(nums1[p1]<nums2[p2]){
                cur=nums1[p1++];
            }else {
                cur=nums2[p2++];
            }
            new_nums[p1+p2-1]=cur;
        }

        while (p1<m){
            cur=nums1[p1++];
            new_nums[p1+p2-1]=cur;
        }
        while (p2<n){
            cur=nums2[p2++];
            new_nums[p1+p2-1]=cur;
        }

        for (int i = 0; i < new_nums.length; i++) {
            nums1[i]=new_nums[i];
        }
    }
}
