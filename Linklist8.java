//reverse a ll
public class Linklist8{
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
    // public int search(int key){
    //     Node temp = head;
    //     int index=0;
    //     while(temp != null){
    //         if(temp.data == key){
    //             return index;
    //         }
    //         temp = temp.next;
    //         index++;
    //     }
    //     return -1;
    // }
    // public int helper(Node head, int key){
    //     if(head == null){
    //         return -1;
    //     }
    //     if(head.data == key){
    //         return 0;
    //     }
    //     int index = helper(head.next, key);
    //     if(index == -1){
    //         return -1;
    //     }
    //     return index+1;
    // }
    // public int recsearch(int key){
    //     return helper(head,key);
    // }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev; //reverse step
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[]){
        Linklist8 ll = new Linklist8(); // obj to access addfirst method
        
        ll.addfirst(2);
        
        ll.addfirst(1);
        
        ll.addlast(3);
        ll.addlast(4);

        // System.out.println(ll.recsearch(4));
        // System.out.println(ll.recsearch(10));

        
        ll.print();
        ll.reverse();
        ll.print();
        
    }
    
}