package BackUp.graduated.P07_Math;

/**
 * @Author:vic
 * @Date:21-5-4
 * @Content:
 */
public class P0504_670maximumSwap {
    public int maximumSwap(int num) {//98368
        if (num < 10) return num;
        char[] chars = String.valueOf(num).toCharArray();//把数字转化为数组
        int[] maxIndexArr = new int[chars.length];//用来记录右边最大数字的下标
        int maxIndex = chars.length - 1;

        for (int i = chars.length - 1; i >= 0; i--) {
            //这是一个更新过程，目的是寻找到每一个数字对应的右边的最大值
            if (chars[i] > chars[maxIndex]) {
                //当前索引位置的值比maxIndex上的要大，则更新坐标
                maxIndex = i;
                maxIndexArr[i] = -1;//说明当前的右边没有值比他大
            } else {
                //这个时候说明右边的存在比他大的，则更新maxIndexArr为最大值的下标
                maxIndexArr[i] = maxIndex;
            }
        }
        //从左向右找，更新
        for (int i = 0; i < maxIndexArr.length; i++) {
            if(maxIndexArr[i]!=-1&&chars[i]!=chars[maxIndexArr[i]]){
                //这个位置右边存在比他大的，且这个位置上的值 不等于 这个位置上右边最大值的索引上的值，
                //简单理解为就是，这个位置上的值不能够与最大值相等

                char temp= chars[i];
                chars[i]=chars[maxIndexArr[i]];
                chars[maxIndexArr[i]]=temp;
                break;
            }
        }
        int res=Integer.parseInt(new String(chars));
        return res;
    }

}
