package backup.graduated.P02_TreeNode;


/**
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode(int x) {
 *         val = x;
 *     }
 * }
 */

public class P54_kthLargest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res,count;//形参k不能随着dfs的迭代而不断变化，为了记录迭代进程和结果，引入类变量count和res。
    public int kthLargest(TreeNode root, int k) {
        this.count=k;//利用形参值k对类变量count进行初始化
        dfs(root);//这里不要引入形参k，dfs中直接使用的是初始值为k的类变量count
        return res;

    }

    void dfs(TreeNode root){
        //当root为空或者已经找到了res时，直接返回
        if (root==null||count==0)
            return;//退出程序，不进行任何操作

        dfs(root.right);//遍历右边
        if(--count ==0){
            //说明count原本是1已经找到目标了
            res=root.val;
            return; //避免无效的迭代
        }
        dfs(root.left);

    }
}
