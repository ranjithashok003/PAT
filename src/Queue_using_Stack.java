
import java.util.*;
//DEQUEUE COSTLY

public class Queue_using_Stack {

    public static void Enqueue(Stack<Integer> Result, int val){
        Result.push(val);
    }

    public static Stack<Integer> Dequeque(Stack<Integer> Result, int t){
        Stack<Integer> Inter = new Stack<Integer>();
        while(!Result.isEmpty()){
            int m = Result.pop();
            Inter.push(m);
        }

        for(int i = 0; i<t; i++){
            Inter.pop();
        }

        Result = Inter;
        return Result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> Result = new Stack<Integer>();

        int n = sc.nextInt();
        for (int i = 0; i<n; i++ ){
            int x = sc.nextInt();
            Enqueue(Result, x);
        }

        int d = sc.nextInt();
        Result = Dequeque(Result,d);
        System.out.println("Queue elements are:");
        while(!Result.isEmpty()){
            int m = Result.pop();
            System.out.print(m + " ");
        }
    }
}