import java.util.*;

public class DiameterBST {
    Tree_Node root;
    void insertBST(Tree_Node root,int x){

        if(x> root.key) {
            if (root.right != null) {
                insertBST(root.right, x);
            } else {
                root.right = new Tree_Node(x);
            }
        }
        else{
                if(root.left!=null) {
                    insertBST(root.left, x);
                }
                else{
                    root.left = new Tree_Node(x);
                }
            }

        }
    public static int height(Tree_Node root){
        if(root==null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left,right);
    }

    public static int diameter(Tree_Node root){
        if (root==null){
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int incPath = 1 + rightHeight + leftHeight;
        int excPath = Math.max(left,right);
        return Math.max(incPath,excPath);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DiameterBST t = new DiameterBST();
        int i = 0;
        while(true) {
            int x = sc.nextInt();
            if (x==-1)
                break;
            if (i == 0) {
                t.root = new Tree_Node(x);
            } else {
                t.insertBST(t.root,x);
            }
            i++;
        }
        System.out.println(diameter(t.root));
    }
}

