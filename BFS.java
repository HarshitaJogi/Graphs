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

	static int N = 100;
    static ArrayList<Integer> [] g = new ArrayList[N];
    static int [] vis = new int [N];
    static int [] level = new int [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        // n is number of nodes, m is number of edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<N; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){

            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            g[y].add(x);
        }

        bfs(1);

        System.out.println();
        for(int i=1; i<=n; i++){
            System.out.print(level[i] + " ");
        }


	}

    static void bfs(int source){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = 1;
        //System.out.print(source + " ");

        while(!q.isEmpty()){
            int curr_vertex = q.poll();
            for(int child: g[curr_vertex]){
                if(vis[child] == 1) continue;
                q.add(child);
                vis[child] = 1;
                level[child] = level[curr_vertex] + 1;
            }

        }
    }
}