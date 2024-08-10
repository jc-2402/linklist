//detect a cycle
public class Linklist11{public static class Node{ // to create single node
      int data;
      Node next;//obj of node class and reference of next node

      public Node(int data){// a constructor to assign properties(data & address) to the node
        this.data = data;
        this.next = null; //initially
      }
    }

    public static Node head;
    public static Node tail;

    
    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
            return true;//cycle exists
        }
        }
        return false; //cycle doesnt exist
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
         head.next.next.next = head;// cycle
        System.out.println(iscycle());
    }
}