
import com.sun.net.httpserver.Headers;

//remove first from ll
public class Linklist4{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
           this.data = data;
           this.next = null; 
        } 
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
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
    public void addmiddle(int index, int data){
        Node newnode = new Node(data);
        Node temp = head;
        int i=0;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        //temp -> prev
        newnode = temp.next;
        temp.next = newnode; 
    }
    public void print(){
        
    }
    public static void main(String[] args) {
        Linklist4 ll = new Linklist4();

    }
}