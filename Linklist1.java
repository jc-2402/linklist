//add node at 1st
public class Linklist1{
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
        }
        //step 2 - link by taking head data which has address to next node
        newnode.next = head;
        //step 3 - update head to address of newnode
        head = newnode;
    }
    public static void main(String args[]){
        Linklist1 ll = new Linklist1(); // obj to access addfirst method
        ll.addfirst(1);
        ll.addfirst(2);
    }
    
}