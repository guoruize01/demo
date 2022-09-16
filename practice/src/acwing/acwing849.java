package acwing;
//3 3
//1 2 2
//2 3 1
//1 3 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class acwing849 {
    static int N = 510;
    static int[][] g = new int[N][N]; //	稠密图使用邻接矩阵存储
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N]; //	相当于s集合，确定了和1号点的最短距离的点加入到s集合中
    static int n,m;

    static int dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        dist[1] = 0;
        for(int i=0;i<n-1;i++) {
            int t = -1;
            for(int j = 1; j<=n ;j++){
                if(st[j]) continue;
                if(t==-1||dist[j]<dist[t]){
                    t = j;
                }
            }
            for(int j=1;j<=n;j++) {
                dist[j] = Math.min(dist[j], dist[t]+g[t][j]);
            }
            st[t] = true;
        }
        if(dist[n] == Integer.MAX_VALUE/2) {
            return -1;
        }
        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        n = Integer.parseInt(str[0]);m = Integer.parseInt(str[1]);
        for(int i=0;i<=n;i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE/2);
        }
        for(int i=0;i<m;i++) {
            str = bf.readLine().split(" ");
            int x = Integer.parseInt(str[0]),y = Integer.parseInt(str[1]),z = Integer.parseInt(str[2]);
            g[x][y] = Math.min(g[x][y], z);	//	去重边
        }

        System.out.println(dijkstra());
    }
}

