package backup.graduated.P04_Backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:vic
 * @Date:21-4-29
 * @Content:
 */
public class P0429_934shortestBridge {
    /**
     *  -1,0 左
     *   0,1 下
     *   1,0 右
     *   0,-1上
     */
    int res=0;
    int[]direction=new int[]{-1,0,1,0,-1};


    public int shortestBridge(int[][] A) {
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 我第一反应是用dfs做，模板应该和前面的差不多
         *
         * 寻找岛 DFS   先 dfs 将找到的第一座桥的值全部赋值为2，并将第一座桥旁边的 0 全部插入队列中
         * 向外延伸BFS  再 while 循环判断队列是否为空，循环体里会判断是否发现了第二座桥；
         */
        if (A.length == 0 || A[0].length == 0)
            return 0;

        int length = A.length;
        int index_length = A[0].length;

        //寻找第一个 dfs，将第一座岛上所有值都该为 2
        boolean flag=false;//设置flag用于判断是否找到
        for (int i = 0; i < length; i++) {
            if(flag) break;
            for (int j = 0; j < index_length; j++) {
                if(A[i][j]==1){//说明找到了
                    dfs(A,queue,i,j);//将这个岛上所有的1都变为2, 周围的0全部插入队列
                    flag=true;
                    break;//这个时候已经找到了第一个岛，并且完成了所有的陆地周围的0都加入队列的工作
                }

            }
        }
        //广度遍历，找到另外一个岛
        while (!queue.isEmpty()){
            res++;//当不为空的时候++，说明在第一层外圈

            int queueSize=queue.size();
            while (queueSize>0){
                queueSize--;
                int[] node = queue.poll();//吐出第一个节点，尺寸减小，得到坐标
                for (int k = 0; k < direction.length-1; k++) {
                    int x1=node[0]+direction[k];
                    int y1=node[1]+direction[k+1];
                    if(x1>=0&&x1<A.length&&y1>=0&&y1 < A[0].length){
                        if(A[x1][y1]==1){
                            return res;//说明找到了
                        }else if(A[x1][y1]==2){
                            continue;//不需要关
                        }else {
                            //说明是0 的情况
                            A[x1][y1]=2;
                            queue.add(new int[]{x1,y1});
                        }
                    }
                }

            }
        }




        return res;
    }

    public void dfs(int[][] A,  Queue<int[]> queue,int i, int j) {
        /**
         * 将这个岛上所有的1都变为2
         * 周围的0全部插入队列
         * 如果是2说明处理过了，就不需要过问
         */
        int length = A.length;
        int index_length = A[0].length;
        if(i<0||i>=length||j<0||j>=index_length)
            return;//越界情况
        if(A[i][j]==2) return;//2说明处理过了，不需要关

        if(A[i][j]==0){
            queue.add(new int[]{i,j});
            return;

        }
        if(A[i][j]==1){
            A[i][j]=2;
            //遍历四周
            for (int k = 0; k < direction.length-1; k++) {
                dfs(A, queue,i+direction[k],j+direction[k+1]);
            }

        }
    }
}
