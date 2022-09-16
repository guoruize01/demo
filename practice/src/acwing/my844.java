package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class my844 {
    static int n;
    static int m ;
    static int[][] map;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m  = Integer.parseInt(str[1]);
        map = new int[n][m];
        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int res = bfs();
        System.out.println(res);
    }
    public static int bfs(){
        Queue<Pair> queue= new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        queue.offer(new Pair(0,0));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            if(x==n-1&&y==m-1){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y  + dy[i];
                if(a>=0&&a<n&&b>=0&&b<m&&map[a][b]==0&&d[a][b]==0){
                    queue.offer(new Pair(a,b));
                    d[a][b] = d[x][y]+1;
                }
            }
        }
        return d[n-1][m-1];
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
}
