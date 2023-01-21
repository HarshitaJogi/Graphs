import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Zero_One_BFS_Chef_and_Reversing{

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
    static ArrayList<pair> [] g = new ArrayList [N];
    static int [] level = new int [N];
    static int m,n;


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

            g[x].add(new pair(y, 0));
            g[y].add(new pair(x, 1));


        }

        System.out.println(bfs());


	}

    static int bfs(){
            Arrays.fill(level, 100);
            Deque<Integer> q = new LinkedList<>();
            q.addLast(1);
            level[1] = 0;

            while(!q.isEmpty()){
                int curr = q.poll();
                for(pair child: g[curr]){
                    int child_v = child.x;
                    int wt = child.y;
                    if(level[curr] + wt < level[child_v]){
                        level[child_v] = level[curr] + wt;
                        if(wt == 1){
                            q.addLast(child_v);
                        }
                        else{
                            q.addFirst(child_v);
                        }
                    }
                }
            }

            if(level[n] == N){
                return -1;
            }
            else return level[n];

    }
}

class pair{
    int x,y;

    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}