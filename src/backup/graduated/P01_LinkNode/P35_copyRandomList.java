package backup.graduated.P01_LinkNode;

import java.util.HashMap;


// 1 hashmap 拷贝
// 2 原地拷贝   1->1'->2->2'->3->3'
public class P35_copyRandomList {

    //1 hashmap方法
    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        HashMap<Node, Node> hashMap = new HashMap<>();//1为原节点，2为复制节点，hashMap.get(cur)获得该节点
        Node cur = head;
        while (cur != null) {
            hashMap.put(cur, new Node(cur.val));//用map存储各个独立节点
            cur = cur.next;
        }
        // 一轮结束之后，cur的用途就是用来产生新的链表
        cur = head;
        //首先遍历map
        while (cur != null) {
            hashMap.get(cur).next = hashMap.get(cur.next);          //当前复制节点的下一个为原节点的下个节点的复制节点
            hashMap.get(cur).random = hashMap.get(cur.random);      //当前复制节点的随机节点为原本节点的随机节点的复制节点
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    // 2 原地拷贝   1->1'->2->2'->3->3'
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head, copy = null;
        while (cur != null) {
            copy = new Node(cur.val);//复制传递新值
            copy.next = cur.next;//copy的下一个串接cur的下一个
            cur.next = copy;//cur的下一个串接copy
            cur = cur.next.next;//next变成了复制节点，next.next才是原来的节点
        }//这里处理了next节点
        cur = head;

        //处理随机节点
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;//当前节点的复制节点的随机节点为 当前节点的随机节点的复制值

            }
            cur = cur.next.next;
        }

        //分裂节点
        Node copyHead = head.next;//永远指向复制节点的第一个不变化
        cur = head;//指向第一个复制节点
        copy = head.next;
        while (cur!=null){
            cur.next=cur.next.next;//当前节点的拼接
            cur=cur.next;
            if(copy.next!=null){//即非复制节点还存在
                copy.next=copy.next.next;
                copy=copy.next;
            }


        }

        return copyHead;

    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}