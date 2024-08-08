//add at middle
//add node at 1st
public class Linklist2{
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
    public void addmiddle(int index, int data){
        if(index == 0){
            addfirst(data);
            return;
        }
        Node newnode = new Node(data);
        Node temp = head;
        int i=0;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }
        // i = index -1 and temp -> prev
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public static void main(String args[]){
        Linklist2 ll = new Linklist2(); // obj to access addfirst method
        ll.addfirst(2);
        ll.addfirst(1);
        ll.addlast(3);
        ll.addlast(4);

        ll.addmiddle(2,9);
        ll.print();
    }
    
}