import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No_of_Provinces{

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

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int u = sc.nextInt();
                adj.get(i).add(u);
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.println(adj.get(i).get(j));
        //     }
        // }

        System.out.println(numProvinces(adj, n));


	}

    static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[]){
        vis[node+1] = 1;
        for(Integer it: adjLs.get(node)){
            if(vis[it] == 0){
                dfs(it, adjLs, vis);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V){

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<V; i++){
            adjLs.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to list
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j) == 1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int vis[] = new int [V+1];
        int count = 0;
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, adjLs, vis);
            }
        }

        return count;

    }
}