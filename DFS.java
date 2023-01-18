import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;




public class DFS{

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
    static ArrayList<Integer>[] g = new ArrayList[N];
    static boolean vis[] = new boolean [N];

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();

        // n = no of vetrex
        // m = no of edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<N; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            g[v1].add(v2);
            g[v2].add(v1);
        }

        dfs(1);

		

	}

    static void dfs(int vertex){
        // take action on vertex after entering the vertex
        vis[vertex] = true;
        System.out.println(vertex);
        for(int child : g[vertex]){
            System.out.println("Parent: " + vertex + " Child: " + child);
            if(vis[child]) continue;
            // take action on the child before entering the chile node
            dfs(child);
            // take action on child after exiting the child node
        }
        // take action on vertex before exiting the vertex
    }
}