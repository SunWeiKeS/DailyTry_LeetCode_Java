package BackUp.graduated.P07_Math;

import java.util.ArrayList;

public class P62_lastRemaining {
    /**
     * 核心思想：最终剩下一个人时的安全位置肯定为0，反推安全位置在人数为n时的编号
     * 从 f(n,m) 场景下删除的第一个数的序号是 (m - 1) % n，
     *      那么 f(n - 1, m) 场景将使用被删除数字的下一个数，
     *      即序号 m % n 作为它的 0 序号。
     * 设 f(n - 1, m) 的结果为 x，x 是从 f(n, m) 场景下序号为 m % n 的数字出发所获得的结果，
     *      因此，我们可以得出：m % n + x 是该数字在 f (n, m) 场景下的结果序号。
     *      即：f(n, m) = m % n + x
     *
     * 假设我们已经知道11个人时，胜利者的下标位置为6。那下一轮10个人时，胜利者的下标位置为多少？
     *      其实吧，第一轮删掉编号为3的人后，之后的人都往前面移动了3位，胜利这也往前移动了3位，
     *      所以他的下标位置由6变成3。
     * 假设我们已经知道10个人时，胜利者的下标位置为3。那下一轮11个人时，胜利者的下标位置为多少？
     *      这可以看做是上一个问题的逆过程
     *
     * 本文从0开始，则下标即最后的值答案
     */
    //递归法
    public int lastRemaining1(int n, int m) {//返回的是胜利者下标，而不是删除的对象！！
        //一共n个人，每次删除第m个

        return find(n, m);
    }
    public int find(int n, int m) {
        if (n == 1)
            return 0;

        int x=find(n-1,m);//n-1到n,每个人的下标往后移动m个

        return (x+m)%n;
    }

    //迭代公式法--逆推
    public int lastRemaining2(int n, int m) {//返回的是胜利者下标，而不是删除的对象！！

        int index=0;
        for (int i = 2; i <=n ; i++) {
            index=(index+m)%i;//左index是胜利者在上轮的位置
        }
        return index;
    }

    //模拟法--正推
    public int lastRemaining(int n, int m) {//返回的是胜利者下标，而不是删除的对象！！
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx=0;//被删除目标的下标
        while (n>1){
            idx=(idx+m-1)%n;
            list.remove(idx);
            n--;
        }


        return list.get(0);
    }

}



















