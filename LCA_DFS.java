import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LCA_DFS{

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
    static int [] parent = new int [N];

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

        dfs(1, -1);

        int x, y;
        x = 6;
        y = 7;

        ArrayList<Integer> path_x = new ArrayList<Integer>();
        ArrayList<Integer> path_y = new ArrayList<Integer>();

        path_x = path(x);
        path_y = path(y);

        int min_length = Math.min(path_x.size(), path_y.size());

        int lca = -1;
        for(int i=0; i<min_length; i++){
            if(path_x.get(i) == path_y.get(i)){
                lca = path_x.get(i);
            }
            else{
                break;
            }
        }

        System.out.println(lca);


	}

    static void dfs(int vertex, int par){

        parent[vertex] = par;
        for(int child: g[vertex]){
            if(child == par) continue;
            dfs(child, vertex);

        }

    }

    static ArrayList<Integer> path (int vertex){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while(vertex != -1){
            ans.add(vertex);
            vertex = parent[vertex];
        }
        Collections.reverse(ans);
        return ans;
    }
}