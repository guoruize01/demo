package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing797_2 {
    static int N= 10010;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n  = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < n; i++) {
            a[i+1] = Integer.parseInt(s2[i]);
            insert(b,i+1,i+1,a[i+1]);
        }
        while(m-->0){
            String[] s3 = br.readLine().split(" ");
            int l = Integer.parseInt(s3[0]);
            int r = Integer.parseInt(s3[1]);
            int x = Integer.parseInt(s3[2]);
            insert(b,l,r,x);
        }
        for (int i = 1; i <= n; i++) {
            b[i]+=b[i-1];
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(b[i]);
        }
    }
    public static void insert(int[] arr, int i,int j,int a){
        arr[i]+=a;
        arr[j+1]-=a;
    }
}
