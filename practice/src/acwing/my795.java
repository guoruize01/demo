package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class my795 {
    static int N = 10010;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s0= br.readLine().split(" ");
        int n=Integer.parseInt(s0[0]);
        int q = Integer.parseInt(s0[1]);
        String[] s1 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int[] s = new int[N];
        s[0]=0;
        for (int i = 0; i < n; i++) {
            s[i+1] =s[i]+arr[i];
        }

        while(q-->0){
            String[] s2 = br.readLine().split(" ");
            int x= Integer.parseInt(s2[0]);
            int y = Integer.parseInt(s2[1]);
            System.out.println(s[y]-s[x-1]);

        }
    }
}
