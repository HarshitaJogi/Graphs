import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BFS{

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

        // passing empty arrays to all nodes
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<Integer>());
        }

        // input of graph edges
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // v is starting node
        int v = 0;
        boolean [] vis = new boolean [n+1];
        Queue <Integer> q = new LinkedList <>();
        int node;

        q.add(v);
        vis[v] = true;

        while(!q.isEmpty()){
            node = q.poll();
            System.out.print(node + " ");

            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }



	}

    public ArrayList<Integer> bfsOfGraph (int V, ArrayList<ArrayList<Integer>> adj){

        ArrayList <Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue <Integer> q = new LinkedList <>();

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}