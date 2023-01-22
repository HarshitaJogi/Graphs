import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dijkstra_Algo_BFS{

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

	static int n,m;
    static int N = 100;
    static ArrayList<pair> [] g = new ArrayList [N];
    static boolean [] vis = new boolean [N];
    static int [] distance = new int [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<N; i++){
            g[i] = new ArrayList<pair>();
        }

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int wt = sc.nextInt();

            // storing in pairs of (node, weight)
            g[x].add(new pair(y, wt));
            
            // not this bec graph is directed
            //g[y].add(new pair(x, wt));
        }

        dijkstra(1);

        for(int i=1; i<=n; i++){
            System.out.print(distance[i] + " ");
        }



	}

    static void dijkstra(int source){
        // initialzing distance array with N
        Arrays.fill(distance, N);

        Set <pair> st = new HashSet<pair>();
        // store the pairs in set as (distance, node)
        st.add(new pair(0, source));
        distance[source] = 0;

        while(st.size() > 0){
            // pick the element from set that has minimum distance and call it current
            //pair current = Collections.min(st);
            int min = Integer.MAX_VALUE;
            pair current = new pair(0,0);
            for(pair p: st){
                if(p.x < min){
                    min = p.x;
                    current = p;
                } 
            }
            int curr_n = current.y;
            int curr_dis = current.x;
            // after finding current node and current distance, remove that element from set
            st.remove(current);
            // do not process the node it it is marked true
            if(vis[curr_n] == true) continue;
            vis[curr_n] = true;
            for(pair child: g[curr_n]){
                int child_n = child.x;
                int child_wt = child.y;
                // try to minimise the distance of child node
                if(distance[curr_n] + child_wt < distance[child_n]){
                    distance[child_n] = distance[curr_n] + child_wt;
                    // after minimising add it in set
                    // in the set, add the new minimised distance of child (IMP)
                    st.add(new pair(distance[child_n], child_n));
                }
                
            }

        }
    }
}

class pair{
    int x,y;

    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}