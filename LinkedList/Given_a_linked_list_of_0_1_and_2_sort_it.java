// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}


class LinkedList{
    static Node segregate(Node head){
        int[] count = {0, 0, 0};
        Node ptr = head;
        while(ptr != null){
            count[ptr.data]++;
            ptr = ptr.next;
        }
        int i = 0;
        Node curr = head;
        while(curr != null){
            if( count[i] == 0 ){
                i++;
            }else{
                curr.data = i;
                count[i]--;
                curr = curr.next;
            }
        }
        return head;
    }
}