package backup.graduated.P03_Array;

import java.util.HashMap;

public class P0313_LRUCache {

}

class LRUCache {
    //创建一个双线链表，涉及到key，value，前节点prev 后节点next
    //一个基于hashmap的缓存器、size和额定容量 ，头节点尾节点head end
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {
        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer,DLinkedNode> cache= new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;DLinkedNode end;

    public LRUCache(int capacity) {

        /**
         * 以正整数作为容量 capacity 初始化 LRU 缓存
         */
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        end=new DLinkedNode();

        head.next=end;
        end.prev=head;//两个指针指向头和尾
    }

    /**
     * 对于get，我们首先判断key是否存在，
     *  key不存在，返回-1
     *  key存在，则key对于的节点是最近被使用的节点，
     *  通过哈希表定位到该节点在双向链表中的位置
     *  并将其移动到双向链表的头部，最后返回该节点的值  moveToHead==removeTail+addToHead
     * @param key
     * @return
     *
     * removeTail和moveToHead里面有 removeNode
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);//找到这个节点
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    /**
     * 首先判断key是否存在，
     * 如果key不存在，则适应key和value创建一个新的节点，
     *      在双向链表的头部添加该节点，并且将key和该节点添加进哈希表中。
     *      然后判断双向链表的节点数是否超出容量，
     *      如果超出容量，则删除双向链表的尾部节点，
     *      并删除哈希表中对于的项
     *      removeTail
     *
     *
     * 如果key存在，则与get操作类似，通过哈希表定位，
     * 再将对应的节点的值更新为value，
     *      moveToHead
     * 并将该节点移动到双向链表的头部
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);//找到这个节点
        if(node==null){//如果不存在
            DLinkedNode tmp= new DLinkedNode(key, value);
            cache.put(key, tmp);
            addToHead(tmp);
            size++;
            if(size>capacity){
                DLinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
                size--;
            }

        }else {
            //表示节点存在的情况
            node.value=value;
            moveToHead(node);
        }

    }

    //moveToHead、removeTail、addToHead、removeNode 这些操作都是针对hashmap而言的

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node){
        //node是一个刚来的节点
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private void  removeNode(DLinkedNode node){
        //把这个节点从当前位置中删除
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }

    private DLinkedNode removeTail(){
        DLinkedNode target=end.prev;
        removeNode(target);
        return target;
    }
}





















