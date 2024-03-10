import java.util.*;

//Time Complexity: O(1)

public class Min_Stack_2 {
    Stack<Integer> S1 = new Stack<>();
    Stack<Integer> S2 = new Stack<>();

    void insert(int n){
        if(S1.isEmpty()){
            S1.push(n);
            S2.push(n);
        }

        else{
            S1.push(n);
            if(S1.peek()<S2.peek()){
                S2.push(S1.peek());
            }
        }
    }

    int getmin(){
        return S2.peek();
    }

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        Min_Stack_2 obj  = new Min_Stack_2();

        int n =  sc.nextInt();

        for(int i = 0; i<n; i++){
            obj.insert(sc.nextInt());
        }

        System.out.println(obj.getmin());
    }
}
