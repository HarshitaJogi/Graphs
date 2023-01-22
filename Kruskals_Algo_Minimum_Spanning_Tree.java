import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kruskals_Algo_Minimum_Spanning_Tree{

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	static int N = 100;
    static int [] parent = new int [N];
    static int [] size = new int [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        // n is number of nodes
        // m is number of edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<pair> edges = new ArrayList<pair>();

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            // we added wt first because we want to edges according to weights
            edges.add(new pair(wt, u, v));
        }

        //Collections.sort(edges);
        int temp = 0;
        for(int i=0; i<edges.size()-1; i++){
            if(edges.get(i).x > edges.get(i+1).x){
                temp = edges.get(i).x;
                edges.get(i).x = edges.get(i+1).x;
                edges.get(i+1).x = temp;
            }
        }

        for(int i=1; i<=n; i++){
            make(i);   // make all individual nodes
        }

        int total_cost = 0;
        for(pair edge: edges){
            int wt = edge.x;
            int u = edge.y;
            int v = edge.z;

            // checking if loop exists if the nodes u and v are joint
            if(find(u) == find(v)) continue;   // if both u and v belong to same parent, edge will exist on joining them
            union(u, v);
            total_cost = total_cost + wt;
        }

        System.out.println(total_cost);


	}

    static void make(int v){
        // makes a group, which has parent v.
        parent[v] = v;
        size[v] = 1;    //v is the only member of the new group, hance size[v]=1
    }

    static int find(int v){
        // returns the parent of the group v is a part of

        if(v == parent[v]) return v;   
        // keep finding parent of a node till you reach parent of the whole group
        return parent[v] = find(parent[v]);
        // here path compression is also performed, where we set the parent of all nodes equal to parent of group
    }

    static void union(int a, int b){
        // joins two groups into one by joining both the group parents

        a = find(a);
        b = find(b);

        if(a!=b){
            // Union by size:
            // we add the smaller group to the bigger group
            if(size[b] < size[a]){
                parent[b] = a;      // bec a is the bigger group
                size[a] = size[a] + size[b];
            }
            else{
                parent[a] = b;
                size[b] = size[b] + size[a];
            }
            
        }

    }
}

class pair{
    int x, y, z;

    pair(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}