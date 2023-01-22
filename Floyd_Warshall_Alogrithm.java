import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Floyd_Warshall_Alogrithm{

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
    static int [][] distance = new int [N][N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		

        // initialize distance array to infinity
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j){
                    // bec distance of 2 from 2 is 0
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = N;
                }
                
            }
        }

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            
                int x = sc.nextInt();
                int y = sc.nextInt();
                int wt = sc.nextInt();
                distance[x][y] = wt;
            
        }

        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<m; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(distance[i][k] != N && distance[k][j] != N){
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(distance[i][j] == N){
                    System.out.print("I" + " ");
                }
                else{
                    System.out.print(distance[i][j] + " ");
                } 
            }
            System.out.println();
        }




	}
}