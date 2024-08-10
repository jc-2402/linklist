//remove a cycle
public class Linklist12{public static class Node{ // to create single node
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

    public static void removecycle(){
        //detect cycle
        
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
              cycle = true;//cycle exists
              break;
            }
          }
          if (cycle == false){
              return ; //cycle doesnt exist
          }
       
       //step 2 - find meeting point
       slow = head;
       Node prev = null;
       while(slow != fast){
        prev = fast;
        slow = slow.next; //+1
        fast = fast.next; //+1
       }
       //remove cycle -> lasr.node = null
       prev.next = null;
        
    }
    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
       head.next.next.next = temp;// cycle
        System.out.println(iscycle());
        removecycle();
        System.out.println(iscycle());

    }
}