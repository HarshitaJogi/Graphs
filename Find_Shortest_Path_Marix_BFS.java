import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Find_Shortest_Path_Marix_BFS{

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

	static boolean [][] vis = new boolean [8][8];
    static int [][] level = new int [8][8];


    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        // n is the number of test cases
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            String start = sc.nextLine();
            String end = sc.nextLine();


            bfs(start);

            int x2 = end.charAt(0) - 'a';
            int y2 = end.charAt(1) - '1';

            System.out.println(level[x2][y2]);

        }


	}

    static void bfs (String start){
        int x1 = start.charAt(0) - 'a';
        int y1 = start.charAt(1) - '1';
        
        Queue<pair> q = new LinkedList<>();

        q.add(new pair(x1, y1));

        vis[x1][y1] = true;

        while(!q.isEmpty()){
            pair current = q.poll();
            int row = current.x;
            int col = current.y;

            if(row+2<8 && col+1<8 && vis[row+2][col+1] == false){
                q.add(new pair(row+2, col+1));
                vis[row+2][col+1] = true;
                level[row+2][col+1] = level[row][col] + 1;
            }
            
            if(row+2<8 && col-1>=0 && vis[row+2][col-1] == false){
                q.add(new pair(row+2, col-1));
                vis[row+2][col-1] = true;
                level[row+2][col-1] = level[row][col] + 1;
            }

            if(row+1<8 && col+2<8 && vis[row+1][col+2] == false){
                q.add(new pair(row+1, col+2));
                vis[row+1][col+2] = true;
                level[row+1][col+2] = level[row][col] + 1;
            }
            
            if(row+1<8 && col-2>=0 && vis[row+1][col-2] == false){
                q.add(new pair(row+1, col-2));
                vis[row+1][col-2] = true;
                level[row+1][col-2] = level[row][col] + 1;
            }

            
            if(row-1>=0 && col+2<8 && vis[row-1][col+2] == false){
                q.add(new pair(row-1, col+2));
                vis[row-1][col+2] = true;
                level[row-1][col+2] = level[row][col] + 1;
            }

            if(row-1>=0 && col-2>=0 && vis[row-1][col-2] == false){
                q.add(new pair(row-1, col-2));
                vis[row-1][col-2] = true;
                level[row-1][col-2] = level[row][col] + 1;
            }

            if(row-2>=0 && col-1>=0 && vis[row-2][col-1] == false){
                q.add(new pair(row-2, col-1));
                vis[row-2][col-1] = true;
                level[row-2][col-1] = level[row][col] + 1;
            }

            if(row-2>=0 && col+1<8 && vis[row-2][col+1] == false){
                q.add(new pair(row-2, col+1));
                vis[row-2][col+1] = true;
                level[row-2][col+1] = level[row][col] + 1;
            }
            
            
        }
    }

}

class pair{
    public int x,y;

    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}





