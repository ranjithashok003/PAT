import java.util.LinkedList;
import java.util.Scanner;

public class Graph_Implementation {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph_Implementation(int v){
        V = v;
        adj = new LinkedList[v]; //Size of adj Array is v
        for(int i = 0; i<v; ++i){
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int u){
        adj[v].add(u);
        adj[u].add(v);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); //No of Edges
        int n = sc.nextInt(); //No of Vertices

        Graph_Implementation G = new Graph_Implementation(n);

        for(int i=0; i<m; i++){
            int u = sc.nextInt(); //Edge 1
            int v = sc.nextInt(); //Edge 2
            G.addEdge(u,v);
        }
    }
}
