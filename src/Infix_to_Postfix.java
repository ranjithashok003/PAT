import java.util.*;

public class Infix_to_Postfix {

    public static StringBuilder Postfix_Converter(String str) {
        Stack<Character> S = new Stack<Character>();

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

        return Result;
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

        StringBuilder Result = Postfix_Converter(str);
        System.out.println(Result);
    }
}
