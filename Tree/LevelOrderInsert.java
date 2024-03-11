import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderInsert {
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
    }

    void levelOrderPrint() {

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

    public static void main(String[] args) {
        LevelOrderInsert t = new LevelOrderInsert();
        String[] str = { "10", "15", "20", "16", "18", "N", "30" };
        t.levelOrderInsert(str);
        System.out.println("Level Order Traversal");
        t.levelOrderPrint();
    }
}