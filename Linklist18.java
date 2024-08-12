// Question 1 :Intersection of Two Linked Lists In a system there are two singly linked list.
// By some programming error,the end node of one of the linked lists got linked to the second
// list,forming an inverted Y-shaped list.
// Write a program to get the point where two linked lists merge.
public class Linklist18{
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null; 
        }
    }
    
    public static Node head1, head2;

    public Node getintersectionnode(Node head1, Node head2){
        while(head2 != null){
            Node temp = head1;
            while(temp != null){
                if(temp == head2){
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }
    public static void main(String[] args) {
        Linklist18 ll = new Linklist18();
        
        ll.head1 = new Node(10);
        ll.head2 = new Node(3);

        Node newnode = new Node(6);
        head2.next = newnode;

        
        newnode = new Node(9);
        head2.next.next = newnode;
    
        newnode = new Node(15);
        head1.next = newnode;
        head2.next.next.next = newnode;

        
        newnode = new Node(30);
        head1.next.next = newnode;

        head1.next.next.next = null;
        
        Node intersetionnode = ll.getintersectionnode(head1,head2);

        if(intersetionnode == null){
            System.out.println("no intersection point");
        }
        else{
            
            System.out.println("intersection point "+intersetionnode.data);
        }

    }
}

// TC = O(m*n)
//sc = O(1)