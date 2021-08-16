package mianshi.bd0812;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-08-12 7:03 下午
 */
public class T1 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
        node4.next = node6;
        Node node = mergeLists(node1, node2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static Node mergeLists(Node l1, Node l2){
        Node dummyHead = new Node(-1);
        Node p = dummyHead;
        while (l1 != null &&  l2 != null){
            if (l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
    }


    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
