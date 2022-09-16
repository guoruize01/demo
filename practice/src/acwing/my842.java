package acwing;


import java.util.Scanner;

public class my842 {
    static int n;
    static int N=100;
    static int[] path = new int[N];
    static boolean[] st  = new boolean[N];

    public static void dfs(int u){
        if(u==n){
            for (int i = 0; i < n; i++) {
                System.out.print(path[i]+" ");
            }
            System.out.println();
        }else {
            for (int i = 1; i <= n; i++) {
                if(!st[i]){
                    path[u] = i;
                    st[i] =true;
                    dfs(u+1);
                    st[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }
}
