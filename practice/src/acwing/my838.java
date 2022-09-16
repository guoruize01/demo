package acwing;

import java.io.*;

public class my838 {
    static int N =10010;
    static int[] t = new int[N];
    static int size =0;
    private static void down(int n){
        int x=n;
        if(2*n<=size&&t[2*n]<t[x]) x = 2*n;
        if(2*n+1<=size&&t[2*n+1]<t[x]) x = 2*n+1;
        if(n!= x){
            swap(n,x);
            down(x);
        }
    }
    private static void swap(int x, int y){
        int tmp = t[x];
        t[x] = t[y];
        t[y] = tmp;
    }
    private static void up(int k){
        while(k/2>0&&t[k/2]>t[k]){
            swap(k,k/2);
            k = k/2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        size = n;
        String[] s2 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(s2[i-1]);
        }
        for (int i = n/2; i >0 ; i--) {
            down(i);
        }
        for (int i = 1; i <= m; i++) {
            bw.write(t[1]+" ");
            t[1]=t[size];
            size--;
            down(1);
        }
        br.close();
        bw.close();
    }
}
