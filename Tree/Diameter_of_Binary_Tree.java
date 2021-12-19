// { Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

class Tree {
    // O(n^2)
    int diameter(Node root) {
        if( root == null ){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        
        return Math.max(lh + rh + 1 , Math.max( ld, rd ) );
    }
    
    int height(Node root){
        if( root == null ){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }


    // Iterative O(n)
    // int diameter(Node root) {
    //     Height height = new Height();
    //     return diameterUtil(root, height);
    // }
    
    // int diameterUtil(Node root, Height height){
    //     Height lh = new Height(), rh = new Height();
        
    //     if( root == null ){
    //         height.h = 0;
    //         return 0;
    //     }
    //     int lDiameter = diameterUtil(root.left, lh);
    //     int rDiameter = diameterUtil(root.right, rh);
        
    //     height.h = 1 + Math.max(lh.h, rh.h);
        
    //     return Math.max(lh.h + rh.h + 1, Math.max(lDiameter, rDiameter) );
    // }
}