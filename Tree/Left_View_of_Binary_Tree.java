// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
    
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                Tree g = new Tree();
                ArrayList<Integer> result = g.leftView(root);
                for(int value : result){
                    System.out.print(value + " ");
                }
                System.out.println();
                t--;
        }
    }
}

class Tree{
    ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        if( root == null ){
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        BFS(result, q);
        return result;
    }
    
    public static void BFS(ArrayList<Integer> result, Queue<Node> q){
        while( !q.isEmpty() ){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node curr = q.poll();
                if( i == 0 ){
                    result.add(curr.data);
                }
                if( curr.left != null ){
                    q.add(curr.left);
                }
                if( curr.right != null ){
                    q.add(curr.right);
                }
            }
        }
    }


    // Recursive
    
    // int maxLevel = 0;
    // ArrayList<Integer> leftView(Node root){
    //     ArrayList<Integer> ans = new ArrayList<Integer>();
    //     leftView(root, 1, ans);
    //     return ans;
    // }
    
    // void leftView(Node root, int level, ArrayList<Integer> ans){
    //     if( root == null ) return;
    //     if( maxLevel < level ){
    //         ans.add(root.data);
    //         maxLevel = level;
    //     }
    //     leftView(root.left, level + 1, ans);
    //     leftView(root.right, level + 1, ans);
    // }
}