package acwing854;

import java.util.Scanner;

public class Main {
    static int N=210;
    static int n,m,q;
    static int[][] d=new int[N][N];
    static int INF=(int)1e9;
    public static void main(String[] args) {
        /*
         *    f[k][i][j]代表（k的取值范围是从1到n），
         *    在考虑了从1到k的节点作为中间经过的节点时，从i到j的最短路径的长度
         *    比如，f[1][i][j]就代表了，在考虑了1节点作为中间经过的节点时，从i到j的最短路径的长度。
         *
         *    f[0][i][j]=min(f[0][i][j],f[0][i][1]+f[0][1][j])
         *    i=>1=>j这种路径的长度，小于，i=>j这种路径的长度
         *
         *    f[k][i][j]=min(f[k−1][i][j],f[k−1][i][k]+f[k−1][k][j])
         *    优化 d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
         */
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();m=sc.nextInt();q=sc.nextInt();
        //初始化i到j的最短距离
        for (int i =1; i <=n; i++) {
            for (int j =1; j <=n; j++) {
                if(i==j) {
                    //自己到自己全都初始化为0，其他的都是无穷大
                    d[i][j]=0;
                }else {
                    d[i][j]=INF;
                }
            }
        }
        //初始化a到b的距离
        //读入邻接矩阵，将次通过动态规划装换成从i到j的最短距离矩阵
        for (int i = 0; i <m; i++) {
            int a=sc.nextInt(),b=sc.nextInt(),w=sc.nextInt();
            //若出现重复的 直接取最小值
            d[a][b]=Math.min(d[a][b],w);
        }
        Floyd();
        while(q-->0) {
            int a=sc.nextInt(),b=sc.nextInt();
            //有负权边存
            if(d[a][b]>INF/2) {
                System.out.println("impossible");
            }else {
                System.out.println(d[a][b]);
            }
//            System.out.println(d[a][b]);
        }
    }

    static void Floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //根据动态转移方程式 进行更新最短的距离
                    d[i][j]=Math.min(d[i][j], d[i][k]+d[k][j]);
                }
            }
        }
    }

}

