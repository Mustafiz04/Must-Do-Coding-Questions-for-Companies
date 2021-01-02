import java.util.*;

public class StackUsingLinkedList {
    class Node{
        int data;
        Node next;
    }
    Node top = null;

    void push(int val){
        Node temp = new Node();

        temp.data = val;
        temp.next = top;

        top = temp;
    }

    void pop(){
        if( top == null ){
            System.out.println("Stack empty");
        }
        top = top.next;
    }

    int peek(){
        if( top == null ){
            System.out.println("Stack empty");
        }
        int x = top.data;
        top = top.next;
        return x;
    }

    void display(){
        if( top == null ){
            System.out.println("adf");
        }else{
            Node temp = top;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList st = new StackUsingLinkedList();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        st.pop();
        st.display();
        System.out.println(st.peek());
    }
}
