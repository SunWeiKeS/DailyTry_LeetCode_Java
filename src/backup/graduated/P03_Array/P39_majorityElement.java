package backup.graduated.P03_Array;

import java.util.HashMap;

public class P39_majorityElement {
    /**
     * 本体常见解法如下：
     *      1. 哈希表统计法： 遍历数组，用hashMap统计各数组的数量，最终超过数组长度一半的数组则为众数，
     *      2. 数组排序法：将数组排序，由于众数的数量超过数组长度的一半，因此数组中间点的元素一定为众数，
     *      3. 摩尔投票法：核心理念为正负抵消，
     *
     *
     */
    public int majorityElement(int[] nums) {
        int x=0,votes=0;
        for (int num : nums) {
            if (votes==0)
                x=num;
            votes +=num==x?1:-1;//如果num和x相等，则+1，如果num和x不相等，则-1
        }

        return x;
    }

    public int majorityElement2(int[] nums) {
        //hashmap解法
        HashMap<Integer,Integer>map= new HashMap<>();

        for (int num : nums) {
            //这是源码，意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue

            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>(nums.length/2)){
                return num;
            }

        }

        return -1;
    }

    public int majorityElement3(int[] nums) {//比较全面的hashmap解法
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = nums.length/2;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) {
                //这里不能直接map.get(nums[i])++;
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            //注意：这里if不能放在第一个if中，否则会在数组长度为1时出错，无法返回正确的nums[i]的值
            //这里i>=length，之所以带等号，也是为了满足长度为1的情况，因为i从0开始
            //按照题目要求，必须众数次数超过长度的一半，则有第一个判断条件，相当于剪枝，当然下面的第一个判断条件也可以不加
            if(i>=length&&map.get(nums[i])>length) return nums[i];
        }
        return 0;//当不存在满足要求的数字或者数组长度为0时
    }

}

