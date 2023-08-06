package BackUp.graduated.P02_TreeNode;


public class P36_treeToDoublyList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre,head;//定义先前节点和头节点
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);
        head.left=pre;//末尾
        pre.right=head;
        return head;
    }
    void dfs(Node cur){
        if(cur ==null) return;
        dfs(cur.left);

        if(pre ==null){
            head=cur;//仅仅是标记一下而已，此时说明位置是最左下方的节点
        }else {
            //pre 不为null
            pre.right=cur;//pre 与cur形成连接
            cur.left=pre;
        }

        pre=cur;

        dfs(cur.right);
    }

}
