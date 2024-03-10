import java.util.Scanner;

public class Optimal_Binary_Search
{
    static int optCost(int freq[], int i, int j)
    {
        if (j < i)
            return 0;
        if (j == i)	
            return freq[i];

        int fsum = sum(freq, i, j);

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j; ++k)
        {
            int cost = optCost(freq, i, k-1) +
                    optCost(freq, k+1, j);
            if (cost < min)
                min = cost;
        }

        return min + fsum;
    }

    static int sum(int freq[], int i, int j)
    {
        int s = 0;
        for (int k = i; k <=j; k++)
            s += freq[k];
        return s;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of nodes: ");
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] f = new int[n];

        System.out.print("Enter keys:");
        for(int i = 0; i<n; i++) {
            keys[i] = sc.nextInt();
        }
        System.out.print("Enter corresponding Frequency: ");
        for(int i = 0; i<n; i++){
            f[i] = sc.nextInt();
        }

        System.out.println("Cost of Optimal BST is " +
                optCost(f, 0, n-1));
    }
}
