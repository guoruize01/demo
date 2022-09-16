package acwing;

import java.util.*;

public class acwing843 {
    static int N=15;
    static char[][] g=new char[N][N];
    static boolean[] col=new boolean[N];
    static boolean[] dg=new boolean[2*N];
    static boolean[] udg=new boolean[2*N];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                g[i][j]='.';
            }
        }
        dfs(0);

    }

    public static void dfs(int u) {
        if(u==n) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        for(int i=0;i<n;i++) {
            if(!col[i]&&!dg[u+i]&& !udg[n-u+i] && g[u][i]=='.') {
                g[u][i]='Q';
                col[i]=true;
                dg[u+i]=true;
                udg[n-u+i]=true;
                dfs(u+1);
                col[i]=dg[u+i]=udg[n-u+i]=false;
                g[u][i]='.';
            }

        }
    }
}
