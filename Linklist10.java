//check if a ll is palindrome or not
//remove nth  node from end
//reverse a ll
public class Linklist10{
    public static class Node{ // to create single node
      int data;
      Node next;//obj of node class and reference of next node

      public Node(int data){// a constructor to assign properties(data & address) to the node
        this.data = data;
        this.next = null; //initially
      }
    }

    public static Node head;
    public static Node tail;

    //method to add node to 1st
    public void addfirst(int data){
        //step1 - create new node
        Node newnode = new Node(data);
        //if linklist is empty
        if(head == null){
            head = tail = newnode;
            return;
        }
        //step 2 - link by taking head data which has address to next node
        newnode.next = head;
        //step 3 - update head to address of newnode
        head = newnode;
    }
    public void addlast(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->"); //print
            temp = temp.next; //update
        }
        System.out.println("null");
    }

    public Node findmid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkpalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step 1
        Node midNode = findmid(head);
        //step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev; //reverse
            prev = curr;
            curr = next;
        }
        Node right = prev; //right ka head
        Node left = head;
        //step 3 - check left n right
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    
    public static void main(String args[]){
        Linklist10 ll = new Linklist10(); // obj to access addfirst method
        
        
        // ll.addlast(1);
        // ll.addlast(2);
        // ll.addlast(1);

        
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(1);

        ll.print();
       System.out.println( ll.checkpalindrome());
        
    }
    
} 