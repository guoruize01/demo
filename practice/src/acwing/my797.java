package acwing;

import java.util.Scanner;

public class my797 {
    static int N =10010;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();

        }
        for (int i = 1; i <= n; i++) {
            insert(b,i,i,a[i]);
        }

        while(m-->0){
            int l = sc.nextInt();
            int r= sc.nextInt();
            int c = sc.nextInt();
            insert(b,l,r,c);

        }
        for (int i = 0; i < n; i++) {
            b[i+1] = b[i]+b[i+1];
        }
        for (int i = 1; i <=n ; i++) {
            System.out.print(b[i]+" ");

        }
    }

    public static void insert(int[] arr, int l,int r, int c){
        arr[l]+=c;
        arr[r+1]-=c;
    }
}
