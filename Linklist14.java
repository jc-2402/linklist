//merge sort
public class Linklist14{
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

    public Node getmid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getmid(head);
        //left & right mergesort
        Node righthead = mid.next;
        mid.next = null; //break
        Node newleft = mergeSort(head); //recursive call
        Node newright = mergeSort(righthead); //recursive call

        return merge(newleft, newright);
    }

    private Node merge(Node head1, Node head2){
        Node mergell = new Node(-1);
        Node temp = mergell;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        //rest elements
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergell.next;
    }
    
    public static void main(String args[]){
        Linklist14 ll = new Linklist14(); // obj to access addfirst method
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(3);
        ll.addfirst(4);
        ll.addfirst(5);


        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
        
    }
    
} 