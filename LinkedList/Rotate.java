import java.util.*;

public class Rotate {
    public static void rotator(Linked_List a, int n,int size) {
        for (int i = 0; i < n; i++) {
            Linked_List rotated = new Linked_List();
            Node e = a.tail;
            Node h = a.head;
            Node t = h;
            Node t2 = t.next;
            for (int j = 0; j < size - 1; j++) {
                if (t != e) {
                    rotated.insert(t2.key);
                    t=t.next;
                    t2 = t2.next;
                }

                else{
                    break;
                }
            }
            rotated.insert(h.key);
            a = rotated;
        }
        System.out.println("Rotated Linked list:");
        a.display();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Linked_List ll = new Linked_List();
        int size=0;
        int i = 0;
        while(i!=-1){
            int x = sc.nextInt();
            if (x!=-1) {
                ll.insert(x);
                size+=1;
            }
            else{
                i=-1;
            }
        }
        int n = sc.nextInt();
        System.out.println("Given linked list:");
        ll.display();
        rotator(ll,n,size);
    }
}
