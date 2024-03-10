import java.util.*;
class Node{
    int key;
    Node next,prev;

    public Node(int key){
        this.key = key;
        next = null;
    }
}

class Linked_List{
    Node head,tail;

    void insert(int n){
        Node newNode = new Node(n);
        if (head == null){
            head = newNode;
            tail = newNode;
        }

        else{
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static Linked_List merge(Linked_List a, Linked_List b){
        Linked_List Final = new Linked_List();
        Node temp_a = a.head;
        Node temp_b = b.head;

        while(temp_a!=null && temp_b!=null) {
            if (temp_a.key < temp_b.key) {
                Final.insert(temp_a.key);
                temp_a = temp_a.next;
            }else {
                Final.insert(temp_b.key);
                temp_b = temp_b.next;
            }
        }

        while(temp_a!=null){
            Final.insert(temp_a.key);
            temp_a = temp_a.next;
        }

        while(temp_b!=null){
            Final.insert(temp_b.key);
            temp_b = temp_b.next;
        }
        return Final;
    }

}

public class Merge_Linked_List {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Linked_List a = new Linked_List();
        Linked_List b = new Linked_List();

        int n1 = sc.nextInt();

        for(int i = 0; i<n1; i++){
            int x = sc.nextInt();
            a.insert(x);
        }

        int n2 = sc.nextInt();
        for(int j = 0; j<n2; j++){
            int y = sc.nextInt();
            b.insert(y);
        }
        Linked_List FinalList = Linked_List.merge(a,b);
        FinalList.display();
    }
}
