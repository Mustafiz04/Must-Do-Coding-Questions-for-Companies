import java.util.*;

public class threeTreeIteration {
  static class Node {
    int data;  
    Node left, right;
    Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }  

  static class Pair {
    Node node;
    int count;
    Pair(Node node, int count) {
      this.node = node;
      this.count = count;
    }
  }

  public static void threeIteration(Node root){
    if( root == null ) return;
    ArrayList<Integer> preorder = new ArrayList<Integer>();
    ArrayList<Integer> postorder = new ArrayList<Integer>();
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    Stack<Pair> s = new Stack<Pair>();
    s.push(new Pair(root, 1));
    while( !s.isEmpty() ){
      Pair curr = s.pop();
      if( curr.count == 1 ){
        preorder.add(curr.node.data);
        s.add(new Pair(curr.node, curr.count + 1));
        if( curr.node.left != null )
          s.add(new Pair(curr.node.left, 1));
      }else if(curr.count == 2){
        inorder.add(curr.node.data);
        s.add(new Pair(curr.node, curr.count + 1));
        if( curr.node.right != null )
          s.add(new Pair(curr.node.right, 1));
      }else if(curr.count == 3){
        postorder.add(curr.node.data);
      }
    }
    System.out.println();
    for(int i = 0; i < preorder.size(); i++){
      System.out.print(preorder.get(i) + " ");
    }

    System.out.println();
    for(int i = 0; i < inorder.size(); i++){
      System.out.print(inorder.get(i) + " ");
    }

    System.out.println();
    for(int i = 0; i < postorder.size(); i++){
      System.out.print(postorder.get(i) + " ");
    }
  }

  public static void preorder(Node root){
    if(root == null) return;
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void inorder(Node root){
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static void postorder(Node root){
    if(root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data + " ");
  }

  public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(5);
    root.left.right = new Node(6);
    root.left.right.right = new Node(7);
    root.left.right.left = new Node(8);
    root.left.right.right.right = new Node(9);

    preorder(root);
    System.out.println();
    inorder(root);
    System.out.println();
    postorder(root);
    System.out.println();
    threeIteration(root);
  }

}
