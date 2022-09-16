package acwing858;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class my858 {
    static int n, m;
    static int N = 510;
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int[][] g = new int[N][N];

    public static int prim() {
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        int res = 0;
        dist[1] = 0;
        for (int i = 0; i < n; i++) {
            int t =-1;
            for (int j = 1; j <= n; j++) {
                if(!st[j]&&(t==-1||dist[j]<dist[t])){
                    t=j;
                }
            }
            if(dist[t]>Integer.MAX_VALUE/2) return Integer.MAX_VALUE/2;
            st[t] = true;
            res+=dist[t];
            for (int j = 1; j <= n; j++) {
                if(!st[j]&&dist[j]>g[t][j]) dist[j] =g[t][j];
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE / 2);
        }
        int a, b, c;
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            a = Integer.parseInt(s2[0]);
            b = Integer.parseInt(s2[1]);
            c = Integer.parseInt(s2[2]);
            g[a][b] = g[b][a] = Math.min(g[a][b],c);
        }
        int res = prim();
        if(res==Integer.MAX_VALUE/2) System.out.println("impossible");
        else System.out.println(res);
    }
}
