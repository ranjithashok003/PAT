import java.util.*;

class MyStack {
    Queue<Integer> Q1 = new LinkedList<>();
    Queue<Integer> Q2 = new LinkedList<>();

    void Push(int val) {
        Q2.offer(val);
        while (!Q1.isEmpty()) {
            Q2.offer(Q1.poll());
        }

        Queue<Integer> temp = Q1;
        Q1 = Q2;
        Q2 = temp;
    }

    void Top() {
        if(!Q1.isEmpty()) {
            int x = Q1.peek();
            System.out.println("Top element: " + x);
        }

        else{
            System.out.println("Top element: -1");
        }
    }

    void Pop() {
        if(!Q1.isEmpty()) {
            int x = Q1.poll();
            System.out.println("Pop: " + x);
        }
        else{
            System.out.println("Pop: -1");
        }
    }

    void Empty() {
        System.out.println("Is Empty: " + Q1.isEmpty());
    }
}

public class Stack_Using_Queues {
    public static void main(String[] args) {
        MyStack ST = new MyStack();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i != -1) {
            int f = sc.nextInt();
            switch (f) {
                case 1:
                    ST.Push(sc.nextInt());
                    break;
                case 2:
                    ST.Pop();
                    break;
                case 3:
                    ST.Top();
                    break;
                case 4:
                    ST.Empty();
                    break;
                case -1:
                    i = -1;
                    break;
            }
        }
    }
}

