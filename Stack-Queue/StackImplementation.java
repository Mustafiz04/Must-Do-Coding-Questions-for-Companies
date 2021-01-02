import java.util.*;

public class StackImplementation {
    int top;
    int size = 1000;
    int[] arr = new int[size];

    StackImplementation(){
        this.top = -1;
    }

    public boolean push(int val){
        if( top >= size - 1 ){
            System.out.println("Stack is full");
            return false;
        }else{
            arr[++top] = val;
            System.out.println(val + " pushed into stack");
            return true;
        }
    }

    public int pop(){
        if( top < 0 ){
            System.out.println("Stack is empty");
            return 0;
        }else{
            int x = arr[top--];
            System.out.println(x + " is the value");
            return x;
        }
    }

    public int peek(){
        if( top < 0 ){
            System.out.println("Stack is empty");
            return 0;
        }else{
            int x = arr[top];
            System.out.println(x + " is the value");
            return x;
        }
    }
    
    void print(){
        if( top < 0 ){
            System.out.println("Stack is Empty");
        }else{
            for(int i = 0; i<=top; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackImplementation st = new StackImplementation();
        st.push(1);
        st.print();
        // st.pop();
        st.peek();
        st.print();
    }
}
