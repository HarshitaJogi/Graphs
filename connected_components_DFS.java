import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class connected_components_DFS{

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

    // stores all connected compoenents in different lists
    static ArrayList<ArrayList<Integer>> cc = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> current_cc = new ArrayList<Integer>();


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

        int count = 0;
        for(int i=1; i<=V; i++){
            if(vis[i] == true) continue;
            current_cc.clear();
            dfs(i);
            cc.add(current_cc);
            count++;
        }

        System.out.println(count);
        for(ArrayList<Integer> it: cc){
            System.out.println(it);
        }

	}

    static void dfs(int vertex){
        vis[vertex] = true;
        current_cc.add(vertex);

        for(int child: g[vertex]){
            if(vis[child] == true) continue;

            dfs(child);
        }
    }
}