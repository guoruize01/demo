package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class my849 {
    static int m, n;
    static int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    public static int dijkstra(){
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        dist[1]= 0;
        for (int i = 0; i < n; i++) {
            int t=-1;
            for (int j = 1; j <=n ; j++) {
                if(!st[j] && (t==-1|| dist[j]<dist[t])){//没有t就不存在dist[t]
                    t =j;
                }
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j],dist[t]+g[t][j]);
            }
            st[t] = true;
        }
        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i],Integer.MAX_VALUE/2);
        }
        while (m-->0){
            String[] s = br.readLine().split(" ");
            int a= Integer.parseInt(s[0]),b=Integer.parseInt(s[1]),c =Integer.parseInt(s[2]);
            g[a][b] = Math.min(c,g[a][b]);
        }
        System.out.println(dijkstra());
    }
}