package acwing;
//迷宫
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    给定一个n*m的二维整数数组，用来表示一个迷宫，数组中只包含0或1，其中0表示可以走的路，1表示不可通过的墙壁。

    最初，有一个人位于左上角(1, 1)处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。

    请问，该人从左上角移动至右下角(n, m)处，至少需要移动多少次。

    数据保证(1, 1)处和(n, m)处的数字为0，且一定至少存在一条通路。

    输入格式
    第一行包含两个整数n和m。

    接下来n行，每行包含m个整数（0或1），表示完整的二维数组迷宫。

    输出格式
    输出一个整数，表示从左上角移动至右下角的最少移动次数。

    数据范围
    1≤n,m≤100
    输入样例：
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
    输出样例：
    8
 */
import java.io.*;
import java.util.*;

public class acwing844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int  n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int[][] arr=new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }

        Queue<int[]> queue=new LinkedList<>();
        int[] dx= {-1,0,1,0},dy= {0,1,0,-1};
        queue.offer(new int[] {0,0});
        int res=0;
        int x=0,y=0;
        int[][] d=new int[n][m];
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            x=poll[0];
            y=poll[1];
            //BFS 优先输出最短路径
            //当到达最后一个点 直接跳出打印
            if(x==n-1 &&y==m-1) {
                break;
            }
            for(int i=0;i<4;i++) {
                int a=x+dx[i];
                int b=y+dy[i];
                if(a>=0 && a<n&&b>=0&& b<m && arr[a][b]==0&& d[a][b]==0) {
                    queue.offer(new int[] {a,b});
                    d[a][b]=d[x][y]+1;
                }
            }
        }
        System.out.print(d[n-1][m-1]);
    }

}

