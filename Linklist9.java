//remove nth  node from end
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
    
    public void removenfromend(int n){
        //calculate size
        int sz =0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        //aagar head he n ho toh
        if(n == sz){// piche se n he end head hai
           head = head.next;
           return;
        }

        //sz- n 
        int i=1;
        int iTofind =sz-n;
        Node prev = head;
        while(i < iTofind){
            prev = prev.next;
            i++;
        }

        //now we are at one node prev to the node which is to be delete
        prev.next = prev.next.next;
        return;
    }
    public static void main(String args[]){
        Linklist8 ll = new Linklist8(); // obj to access addfirst method
        
        ll.addfirst(2);
        
        ll.addfirst(1);
        
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);


        
        ll.print();
        ll.removenfromend(3);
        ll.print();
        
    }
    
} 