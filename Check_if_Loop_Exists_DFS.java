import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Check_if_Loop_Exists_DFS{

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
    static boolean [] vis = new boolean [N];
    static ArrayList<Integer> [] g = new ArrayList [N];


	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		

        int V = sc.nextInt();
        int E = sc.nextInt();

        for(int i=0; i<N; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            g[y].add(x);
        }

        boolean isLoopExists = false;
        for(int i=1; i<=V; i++){
            if(vis[i] == true) continue;
            
            if(dfs(i, 0)){
                isLoopExists = true;
                break;
            }  
            
        }

        System.out.println(isLoopExists);

	}

    static boolean dfs(int vertex, int par){
        vis[vertex] = true;
        boolean isLoopExists = false;
        

        for(int child: g[vertex]){
            if(vis[child] && child == par) continue;
            if(vis[child] == true) return true;

            // |= is OR function, it returns true if any one vertex says that loop exists
            isLoopExists |= dfs(child, vertex);
        }

        return isLoopExists;
    }
}