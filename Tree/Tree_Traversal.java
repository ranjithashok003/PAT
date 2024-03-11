import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tree_Node{
    int key;
    Tree_Node left,right;

    Tree_Node(int key){
        this.key = key;

    }
}

class Tree{
    Tree_Node root;

    void inOrderPrint(Tree_Node root){
        if (root==null){
            return;
        }

        inOrderPrint(root.left);
        System.out.print(root.key + " ");
        inOrderPrint(root.right);
    }

    void postOrderPrint(Tree_Node root){
        if(root==null) {
            return;
        }

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.key + " ");
    }

    void preOrderPrint(Tree_Node root){
        if(root == null){
            return;
        }

        System.out.print(root.key + " ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    void levelOrder(Tree_Node root) {
        Queue<Tree_Node> Q = new LinkedList<>();

        if (root == null) {
            return;
        }

        Q.offer(root);
        while (!Q.isEmpty()) {
            Tree_Node curr = Q.poll();
            System.out.print(curr.key + " ");
            if (curr.left != null) {
                Q.offer(curr.left);
            }
            if (curr.right != null){
                Q.offer(curr.right);
            }
        }

    }
}

public class Tree_Traversal{
    public static void main(String[] args){
        Tree t = new Tree();
        t.root = new Tree_Node(10);
        t.root.left = new Tree_Node(15);
        t.root.left.right = new Tree_Node(18);
        t.root.left.left = new Tree_Node(16);
        t.root.right = new Tree_Node(20);
        t.root.right.right = new Tree_Node(30);

        System.out.print("In-Order: ");
        t.inOrderPrint(t.root);
        System.out.println("");

        System.out.print("Post-Order: ");
        t.postOrderPrint(t.root);
        System.out.println("");

        System.out.print("Pre-Order: ");
        t.preOrderPrint(t.root);
        System.out.println("");

        System.out.print("Level-Order: ");
        t.levelOrder(t.root);
    }
}