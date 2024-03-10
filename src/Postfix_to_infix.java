import javax.swing.event.InternalFrameEvent;
import java.util.*;

public class Postfix_to_infix {

    public static void Calculator(String[] strarr, int n) {
        Stack<Integer> S = new Stack<Integer>();

        ArrayList<Character> operators = new ArrayList<Character>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('^');
        StringBuilder[] Resultarr = new StringBuilder[n];
        for(int i = 0; i<n; i++) {
            StringBuilder Result = new StringBuilder();
            String str = strarr[i];
            for (Character ch : str.toCharArray()) {
                if (!operators.contains(ch)) {
                    int x = ch - 48;
                    S.push(x);
                } else {
                    int m = 0;
                    int t = 0;
                    int y = 0;
                    switch (ch) {
                        case '+':
                            m = S.pop();
                            t = S.pop();
                            y = t + m;
                            S.push(y);
                            break;

                        case '-':
                            m = S.pop();
                            t = S.pop();
                            y = t - m;
                            S.push(y);
                            break;

                        case '*':
                            m = S.pop();
                            t = S.pop();
                            y = t * m;
                            S.push(y);
                            break;

                        case '/':
                            m = S.pop();
                            t = S.pop();
                            y = t / m;
                            S.push(y);
                            break;

                        case '^':
                            m = S.pop();
                            t = S.pop();
                            y = t ^ m;
                            S.push(y);
                            break;
                    }
                }
            }

            while (!S.isEmpty()) {
                Result.append(S.pop());
            }

            System.out.println(Result);
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i<n; i++) {
            String str = sc.next();
            arr[i] = str;
        }

        Calculator(arr,n);

    }
}
