import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class height_depth_of_vertex_tree_DFS{

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
    static ArrayList<Integer> [] g = new ArrayList [N];
    static int [] h = new int [N];
    static int [] d = new int [N];


	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        int n = sc.nextInt();

        for(int i=0; i<N; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            g[y].add(x);
        }

        dfs(1, 0);

        for(int i=1; i<=n; i++){
            System.out.print(h[i] + " ");
        }
        System.out.println();
        for(int i=1; i<=n; i++){
            System.out.print(d[i] + " ");
        }


	}

    static void dfs(int vertex, int par){
        
        for(int child: g[vertex]){
            if(child == par) continue;
            d[child] = d[vertex] + 1;
            dfs(child, vertex);
            h[vertex] = Math.max(h[vertex], h[child]+1);
        }
    }
}