import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EdgeDeletion{

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
    static int [] sumOfSubtree = new int [N];
    static int [] weights = new int [N];

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        int n = sc.nextInt();

        //int [] weights = new int [n];
        for(int i=1; i<=n; i++){
            weights[i] = sc.nextInt();
        }

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

        // for(int i=1; i<=n; i++){
        //     System.out.print(sumOfSubtree[i] + " ");
        // }

        int total = sumOfSubtree[1];
        int ans = Integer.MIN_VALUE;
        for(int i=2; i<=n; i++){
            int first_total = sumOfSubtree[i];
            int second_total = total - first_total;

            int mul = first_total*second_total;
            ans = Math.max(ans, mul);
        }

        System.out.println(ans);


	}

    static void dfs(int Vertex, int par){

        sumOfSubtree[Vertex] += weights[Vertex];
        for(int child: g[Vertex]){
            if(child == par) continue;
            dfs(child, Vertex);
            sumOfSubtree[Vertex] = sumOfSubtree[Vertex] + sumOfSubtree[child];
        }
    }
}