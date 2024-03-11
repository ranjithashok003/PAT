//Complexity: O(n)

import java.util.*;

class Min_Stack_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        int min = Integer.MAX_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++){
            st.push(sc.nextInt());
            if (min>st.peek()){
                min = st.peek();
            }
        }
        System.out.println(min);
    }
}