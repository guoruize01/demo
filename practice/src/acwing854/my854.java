package acwing854;

import java.util.Scanner;

public class my854 {
    static int n,m,q;
    static int N = 210;
    static int[][] d = new int[N][N];
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                if(i==j) d[i][j] = 0;
                else d[i][j]=INF;
            }
        }
        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            d[a][b] =Math.min(d[a][b],c);
        }
        floyd();
        while (q-->0){
            int a= sc.nextInt();
            int b = sc.nextInt();
            if(d[a][b]>INF/2) System.out.println("impossible");
            else System.out.println(d[a][b]);
//            System.out.println(d[a][b]);
        }

    }
    static void floyd(){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=n ; k++) {
                    d[i][j] =Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
    }
}
