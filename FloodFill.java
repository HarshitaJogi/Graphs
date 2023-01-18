import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FloodFill{

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

    static int [][] arr = new int [100][100];
    static boolean [][] vis = new boolean [100][100];
    static int m, n;


	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		//FastReader sc = new FastReader();
        Scanner sc = new Scanner(System.in);
		
        m = sc.nextInt();
        n = sc.nextInt();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int sr = 1;
        int scol = 1;

        dfs(sr, scol);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


	}

    static void dfs(int row, int col){

        vis[row][col] = true;
        arr[row][col] = 2;

        if((row-1)>=0 && vis[row-1][col] == false && arr[row-1][col] == 1){
            dfs(row-1, col);
        }
        if((row+1)<m && vis[row+1][col] == false && arr[row+1][col] == 1){
            dfs(row+1, col);
        }
        if((col+1)<n && vis[row][col+1] == false && arr[row][col+1] == 1){
            dfs(row, col+1);
        }
        if((col-1)>=0 && vis[row][col-1] == false && arr[row][col-1] == 1){
            dfs(row, col-1);
        }
    }
}