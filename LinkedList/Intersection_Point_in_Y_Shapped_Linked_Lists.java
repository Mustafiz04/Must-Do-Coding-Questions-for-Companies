// { Driver Code Starts
import java.util.*;


class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
    
    class LinkedList_Intersection
{
    Node head = null;  
    Node tail = null;

public void addToTheLast(Node node) 
{

    if (head == null) {
    head = node;
    tail = head;
    } else {
    //Node temp = head;
    //while (temp.next != null)
    //temp = temp.next;

    //temp.next = node;
    tail.next=node;
    tail = node;
    }
}

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }  
        System.out.println();
    }
    
        
    
        /* Driver program to test above functions */
    public static void main(String args[])
    {
        
            
        /* Constructed Linked List is 1->2->3->4->5->6->
            7->8->8->9->null */
            Scanner sc = new Scanner(System.in);
            int t=sc.nextInt();
            
            while(t>0)
            {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();
            
                int a1=sc.nextInt();
                Node head1= new Node(a1);
                Node tail1= head1;
                
                for (int i = 1; i < n1; i++) 
                {
                    int a = sc.nextInt(); 
                    tail1.next = (new Node(a));
                    tail1= tail1.next;
                }
            
            
                int b1=sc.nextInt();
                Node head2 = new Node(b1);
                Node tail2 = head2;
                for (int i = 1; i < n2; i++) 
                {
                    int b = sc.nextInt();  
                    tail2.next = (new Node(b));
                    tail2= tail2.next;
                }
                
                int c1=sc.nextInt();
                Node head3= new Node(c1);
                tail1.next = head3;
                tail2.next = head3;
                Node tail3=head3;
                for (int i = 1; i < n3; i++) 
                {
                    int c = sc.nextInt();   
                    tail3.next = (new Node(c));
                    tail3= tail3.next;
                }
                
                Intersect obj = new Intersect();
                System.out.println(obj.intersectPoint(head1, head2));
            t--;			
            }
    }
}


// This is method only submission.  You only need to complete the method. */
class Intersect{
    int intersectPoint(Node headA, Node headB){
        int len1 = length(headA);
        int len2 = length(headB);
        int intersection = -1;
        int d;
        if( len1 > len2 ){
            d = len1 - len2;
            intersection = intersectionLL(headA, headB, d);
        }else{
            d = len2 - len1;
            intersection = intersectionLL(headB, headA, d);
        }
        return intersection;
    }
    
    public int intersectionLL(Node headA, Node headB, int d){
            for(int i = 0; i<d; i++){
                if( headA == null){
                    return -1;
                }
                headA = headA.next;
            }
            while( headA != null && headB != null ){
                if( headA == headB ){
                    return headA.data;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return -1;
    }
    
    int length( Node head ){
        int count = 0;
        Node h = head;
        while( h != null ){
            count++;
            h = h.next;
        }
        return count;
    }
}