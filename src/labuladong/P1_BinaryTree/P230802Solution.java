package labuladong.P1_BinaryTree;

public class P230802Solution {
    public int numTrees(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {// 迭代开始
            // 总的个数 =  x的左子树个数 * x的右子树个数
            for (int j = 1; j <= i; j++) { // 以j开始的，左子树个数j - 1 、右子树个数i-j
                array[i] += array[j - 1] * array[i - j];
            }
        }
        return array[n];
    }
}
