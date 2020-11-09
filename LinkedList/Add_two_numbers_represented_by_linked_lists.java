// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}

class Solution{
    static Node addLists(Node first, Node second){
        if( first.data == 0 ){
            return second;
        }
        if( second.data == 0 ){
            return first;
        }
        
        Node n1 = reverse(first);
        Node n2 = reverse(second);
        
        Node temp = new Node(0);
        Node curr = temp;
        
        int carry = 0;
        
        while( n1 != null && n2 != null ){
            int sum = n1.data + n2.data + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        
        while( n1 != null ){
            int sum = n1.data + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            n1 = n1.next;
        }
        while( n2 != null ){
            int sum = n2.data + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            n2 = n2.next;
        }
        if( carry != 0 ){
            curr.next = new Node(carry);
        }
        
        return reverse(temp.next);
    }
    
    public static Node reverse(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;
        
        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}