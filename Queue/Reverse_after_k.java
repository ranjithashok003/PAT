import java.util.*;

public class Reverse_after_k {
    public static void reversal(LinkedList<Integer> a, int n){
        int size = a.size();
        int lower_bound = 0;
        int upper_bound = n-1;

        LinkedList<Integer> reversed = new LinkedList<Integer>();

        while(upper_bound<size){
            for(int i=0; i<n; i++){
                reversed.add(a.get(upper_bound-i));
            }
            upper_bound+=n;
            lower_bound+=n;
        }
        for(int i = lower_bound; i<size; i++ ){
            reversed.add(a.get(i));
        }

        for(int i = 0; i<size; i++){
            System.out.println(reversed.get(i));
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        int i = 0;
        while(i!=-1){
            int x = sc.nextInt();
            if (x!=-1) {
                ll.add(x);
            }
            else{
                i=-1;
            }
        }
        int n = sc.nextInt();
        reversal(ll,n);
    }
}
