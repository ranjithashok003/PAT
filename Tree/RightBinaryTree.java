import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class RightBinaryTree{
    Queue<Tree_Node> q = new LinkedList<>();
    Tree_Node root;

    void levelOrderInsert(String[] str) {
        root = new Tree_Node(Integer.parseInt(str[0]));
        q.offer(root);
        int i=1;
        while(i<str.length && !q.isEmpty()){
            Tree_Node cur= q.poll();
            if(!str[i].equals("N")){
                cur.left= new Tree_Node(Integer.parseInt(str[i]));
                q.offer(cur.left);
            }
            i++;

            if(i>=str.length) break;

            if(i<str.length && !str[i].equals("N")){
                cur.right= new Tree_Node(Integer.parseInt(str[i]));
                q.offer(cur.right);
            }
            i++;

        }
        rightView(root);
    }

    static void rightView(Tree_Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        rightViewUtil(root, 0, result);
        for (int value : result) {
            System.out.println(value + " ");
        }
    }
    static void rightViewUtil(Tree_Node node, int level, ArrayList<Integer> result){
            if (node == null) return;

            if(result.size() == level)
                result.add(node.key);

            rightViewUtil(node.right, level+1, result);
            rightViewUtil(node.left,level+1,result);
            }



    public static void main(String[] args) {
        RightBinaryTree t = new RightBinaryTree();
        Scanner sc = new Scanner(System.in);
        String Str = sc.nextLine();
        String[] str = Str.split(" ");
        t.levelOrderInsert(str);
    }
}