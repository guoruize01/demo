package acwing;

import java.io.*;

public class my154 {
    static int hh=0,tt=-1;
    static int N = 10010;
    static int[] arr = new int[N];
    static int[] q = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1= br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
        for (int i = 0; i < n; i++) {
            if(hh<=tt&&i-m+1>q[hh]){
                hh++;
            }
            while (hh<=tt&&arr[q[tt]]>arr[i]){
                tt--;
            }
            q[++tt]=i;
            if(i+1>=m)  bw.write(arr[q[hh]]+" ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
