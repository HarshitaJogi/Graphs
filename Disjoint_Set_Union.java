import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Disjoint_Set_Union{

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
    static int [] parent = new int [N];
    static int [] size = new int [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        // n is number of nodes
        // k is number of operations
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=1; i<=n; i++){
            make(i);
        }

        for(int i=0; i<k; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            union(u, v);
        }

        // to find number of connected components
        int connect_ct = 0;
        for(int i=1; i<=n; i++){
            // number of connected components will be number of group parents
            if(find(i) == i){
                connect_ct++;
            }
        }

        System.out.println(connect_ct);


	}

    static void make(int v){
        // makes a group, which has parent v.
        parent[v] = v;
        size[v] = 1;    //v is the only member of the new group, hance size[v]=1
    }

    static int find(int v){
        // returns the parent of the group v is a part of

        if(v == parent[v]) return v;   
        // keep finding parent of a node till you reach parent of the whole group
        return parent[v] = find(parent[v]);
        // here path compression is also performed, where we set the parent of all nodes equal to parent of group
    }

    static void union(int a, int b){
        // joins two groups into one by joining both the group parents

        a = find(a);
        b = find(b);

        if(a!=b){
            // Union by size:
            // we add the smaller group to the bigger group
            if(size[b] < size[a]){
                parent[b] = a;      // bec a is the bigger group
                size[a] = size[a] + size[b];
            }
            else{
                parent[a] = b;
                size[b] = size[b] + size[a];
            }
            
        }

    }
}