import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MultiSource_BFS_SNSOCIAL_Codechef{

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
    static int [][] g = new int [N][N];
    static boolean [][] vis = new boolean [N][N];
    static int [][] level = new int [N][N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        // t is number of test cases
        int t = sc.nextInt();
        for(int a=0; a<t; a++){

            n = sc.nextInt();
            m = sc.nextInt();

            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    g[i][j] = sc.nextInt();
                    max = Math.max(max, g[i][j]);
                }
            }

            ArrayList<pair> position = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(g[i][j] == max){
                        position.add(new pair(i,j));
                    }
                }
            }

            bfs(position);

            int ans = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    ans = Math.max(ans, level[i][j]);
                }
            }

            

            System.out.println(ans);

            //resetting the level and visited array
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    vis[i][j] = false;
                    level[i][j] = N;
                }
            }


        }


	}

    static void bfs(ArrayList<pair> position){
        Queue<pair> q = new LinkedList<>();

        // adding all sources in q before starting bfs
        for(pair coor: position){
            int first = coor.x;
            int second = coor.y;
            q.add(new pair(first, second));
            vis[first][second] = true;
            level[first][second] = 0;
        }

        while(!q.isEmpty()){
            pair current = q.poll();
            int row = current.x;
            int col = current.y; 

            if(col+1<m && vis[row][col+1] == false){
                q.add(new pair(row, col+1));
                vis[row][col+1] = true;
                level[row][col+1] = level[row][col] + 1;
            }

            if(col-1>=0 && vis[row][col-1] == false){
                q.add(new pair(row, col-1));
                vis[row][col-1] = true;
                level[row][col-1] = level[row][col] + 1;
            }
            
            if(row+1<n && vis[row+1][col] == false){
                q.add(new pair(row+1, col));
                vis[row+1][col] = true;
                level[row+1][col] = level[row][col] + 1;
            }
            
            if(row-1>=0 && vis[row-1][col] == false){
                q.add(new pair(row-1, col));
                vis[row-1][col] = true;
                level[row-1][col] = level[row][col] + 1;
            }

            if(row+1<n && col+1<m && vis[row+1][col+1] == false){
                q.add(new pair(row+1, col+1));
                vis[row+1][col+1] = true;
                level[row+1][col+1] = level[row][col] + 1;
            }
            
            if(row+1<n && col-1>=0 && vis[row+1][col-1] == false){
                q.add(new pair(row+1, col-1));
                vis[row+1][col-1] = true;
                level[row+1][col-1] = level[row][col] + 1;
            }
            
            if(row-1>=0 && col+1<m && vis[row-1][col+1] == false){
                q.add(new pair(row-1, col+1));
                vis[row-1][col+1] = true;
                level[row-1][col+1] = level[row][col] + 1;
            }
            
            if(row-1>=0 && col-1>=0 && vis[row-1][col-1] == false){
                q.add(new pair(row-1, col-1));
                vis[row-1][col-1] = true;
                level[row-1][col-1] = level[row][col] + 1;
            }
            
            

        }
    }
}

class pair{
    int x,y;

    pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}