import java.util.*;

public class Longest_Valid_Parenthesis {
    public static void counter(String str){

        int Max_C1 = 0;
        int C2 = 0;

        char[] strarr = str.toCharArray();
        Stack <Integer> S = new Stack<Integer>();
        int C1 = 0;
        int Tot = 0;
        for(int i = 0; i<str.length(); i++){

            if (strarr[i] == '('){
                S.push(i);
            }
            else{
                if (S.isEmpty()){
                    C2 = 0;
                    System.out.println("Hey");
                    continue;
                }
                S.pop();
                if(S.isEmpty()){
                    C2+=2;
                }
                else{
                    C1 = i - S.peek();
                    if (C1>Max_C1){
                        if (Max_C1!=0){
                            C2 = 0;
                        }
                        Max_C1 = C1;
                    }
                }
            }

            if (Tot<(Max_C1+C2)){
                Tot = Max_C1+C2;
            }
        }

        System.out.println(Tot);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        counter(str);
    }
}
