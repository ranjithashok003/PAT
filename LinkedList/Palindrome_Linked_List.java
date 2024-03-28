import java.util.*;

public class Palindrome_Linked_List {

    public static String isPalindrome(Linked_List a, int n){
        Node x = a.head;
        Node y = a.tail;
        for (int i =0; i<n/2;i++ ){
            Node temp = x;
            while(temp.next.next!=null){
                temp = temp.next;
            }
            if(x.key != temp.next.key){
                return "False";
            }
            else{
                x=x.next;
                y=temp;
                y.next = null;
            }
        }
        return "True";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linked_List P = new Linked_List();
        System.out.println("Len");
        int n = sc.nextInt();

        System.out.println("Input");
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            P.insert(x);
        }
        String bool = isPalindrome(P,n);
        System.out.println(bool);
    }
}
