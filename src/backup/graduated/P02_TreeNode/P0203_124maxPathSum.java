package backup.graduated.P02_TreeNode;

public class P0203_124maxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxVal;
    }

    int maxGain(TreeNode node) {//通过maxGain更新整个树上的节点
        if (node == null) return 0;
        int localVal = node.val;
        int nodeLeftVal = Math.max(maxGain(node.left), 0);
        int nodeRightVal = Math.max(maxGain(node.right), 0);
        int MaxNode = localVal + nodeLeftVal + nodeRightVal;//经过此节点的最大值
        // 更新答案
        maxVal=Math.max(maxVal, MaxNode);

        return localVal+Math.max(nodeLeftVal, nodeRightVal);//此节点的最大贡献程度
    }
}
