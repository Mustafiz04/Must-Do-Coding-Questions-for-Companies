// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Rotate g = new Rotate();
            head = g.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}

class Rotate{
    public Node rotate(Node head, int k) {
        Node curr = head;
        int count = 1;
        
        while( curr != null && count < k ){
            curr = curr.next;
            count++;
        }
        
        if(curr == null ){
            return head;
        }
        Node kthnode = curr;
        while( curr.next != null ){
            curr = curr.next;
        }
        curr.next = head;
        head = kthnode.next;
        kthnode.next = null;
        
        return head;
    }
}