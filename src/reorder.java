import java.util.*;

public class reorder {
    public static void reorder(Linked_List a, int n){
        Linked_List reordered = new Linked_List();
        Node s = a.head;
        Node e = a.tail;
        if (n%2!=0){
            n=n+1;
        }
        for(int i=0; i<n/2; i++){
            Node temp = s;
            if(e!=s) {
                reordered.insert(e.key);
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                reordered.insert(s.key);
                s = s.next;
                e = temp;
                e.next = null;
            }
            else{
                reordered.insert(e.key);
            }
        }
        reordered.display();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Linked_List a = new Linked_List();
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            a.insert(x);
        }

        reorder(a, n);
    }
}
