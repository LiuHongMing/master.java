package algorithm.demo;

public class ReverseSingle {

    private static class Node {
        int value;
        Node nextNode;

        Node(int value) {
            this.value = value;
        }

        static Node build(int value) {
            return new Node(value);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    // ตÝน้
    public static Node reverse(Node head) {
        if (head == null || head.getNextNode() == null) {
            return head;
        }
        Node next = reverse(head.getNextNode());
        head.getNextNode().setNextNode(head);
        head.setNextNode(null);

        return next;
    }

    public static void main(String[] args) {
        Node head = Node.build(97);
        Node curr = null;
        Node tmp;
        for (int i = 1; i < 4; i++) {
            tmp = Node.build(i + 97);
            if (1 == i) {
                head.setNextNode(tmp);
            } else {
                curr.setNextNode(tmp);
            }
            curr = tmp;
        }

        Node tail = head;
        do {
            System.out.print((char) tail.getValue());
            tail = tail.getNextNode();
        } while (tail != null);
        System.out.print(",");
        tail = ReverseSingle.reverse(head);
        do {
            System.out.print((char) tail.getValue());
            tail = tail.getNextNode();
        } while (tail != null);
    }

}
