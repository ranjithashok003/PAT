import java.util.*;
import java.lang.Math;

public class Calculator {
    public static int Postfix_Converter(String str) {
        Stack<Character> S = new Stack<Character>();
        str = str.replace(" ", "");

        ArrayList<Character> operators = new ArrayList<Character>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('^');

        StringBuilder Result = new StringBuilder();

        for (Character ch : str.toCharArray()) {
            if (!operators.contains(ch) && !ch.equals(')') && !ch.equals('(')) {
                Result.append(ch);
            } else if (ch.equals(')')) {
                while (!S.peek().equals('(')) {
                    Character x = S.pop();
                    Result.append(x);
                }
                S.pop(); // Discard the '(' from the stack
            } else if (ch.equals('(')){
                S.push(ch);
            }
            else {
                if (S.isEmpty() || S.peek().equals('(')) {
                    S.push(ch);
                } else {
                    while (!S.isEmpty() && S.peek() != '(' && precedence(S.peek()) >= precedence(ch)) {
                        Character x = S.pop();
                        Result.append(x);
                    }
                    S.push(ch);
                }
            }
        }

        while (!S.isEmpty()) {
            Result.append(S.pop());
        }

        String ResultString = Result.toString();
        int n = ResultString.length();
        String[] ResultArr = ResultString.split("");
        return Calc(ResultArr, ResultArr.length);
    }

    public static int Calc(String[] strarr, int n) {
        Stack<Integer> S = new Stack<Integer>();

        ArrayList<Character> operators = new ArrayList<Character>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('^');
        for(int i = 0; i<n; i++) {
            String str = strarr[i];
            for (Character ch : str.toCharArray()) {
                if (!operators.contains(ch)) {
                    int x = ch - 48;
                    S.push(x);
                } else {
                    int m = S.pop();
                    int t = S.pop();
                    int y = 0;
                    switch (ch) {
                        case '+':
                            y = t + m;
                            S.push(y);
                            break;

                        case '-':
                            y = t - m;
                            S.push(y);
                            break;

                        case '*':
                            y = t * m;
                            S.push(y);
                            break;

                        case '/':
                            if (m!=0) {
                                y = t / m;
                                S.push(y);
                            }
                            break;

                        case '^':
                            double w = Math.pow(t,m);
                            y = (int)w;
                            S.push(y);
                            break;
                    }
                }
            }
        }
        int res = (S.pop());
        return res;
        }



    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(Postfix_Converter(str));
    }
}
