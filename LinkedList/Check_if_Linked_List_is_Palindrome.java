// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int d)
    {
        data = d;
        next = null;
    }
}

class Is_LinkedList_Palindrom
{
        Node head;  
        Node tail;
    
    /* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }  
        System.out.println();
    }
    
    
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
    {

        if (head == null) 
        {
            head = node;
            tail = node;
        } else 
        {
            tail.next = node;
            tail = node;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
            
        while(t>0)
        {
            int n = sc.nextInt();
            //int k = sc.nextInt();
            Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
            {
                int a = sc.nextInt(); 
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            Palindrome g = new Palindrome();
            if(g.isPalindrome(head) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
        
    }
}


class Palindrome{
    // boolean isPalindrome(Node head) {
    //     Node n = head;
    //     Stack<Integer> st = new Stack<Integer>();
    //     while(n != null){
    //         st.push(n.data);
    //         n = n.next;
    //     }
    //     while( head != null ){
    //         int curr = st.pop();
    //         if( head.data != curr ){
    //             return false;
    //         }
    //         head = head.next;
    //     }
    //     return true;
    // } 
    
    boolean isPalindrome(Node head) {
        if( head == null || head.next == null ) return true;
        Node slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node nextToSlow = slow.next;
        slow.next = null;
        Node end = reverse(nextToSlow);
        
        while(end != null){
            if( head.data != end.data ){
                return false;
            }
            head = head.next;
            end = end.next;
        }
        return true;
    }    
    
    Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}