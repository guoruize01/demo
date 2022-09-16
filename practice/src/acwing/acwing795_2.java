package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing795_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        int[] arr = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
        int[] sum = new int[s2.length+1];
        sum[0]=0;
        for (int i = 1; i <= s2.length; i++) {
            sum[i] = sum[i-1]+arr[i-1];
        }
        while(m-->0){
            String[] s3 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s3[0]);
            int x2  = Integer.parseInt(s3[1]);
            System.out.println(sum[x2]-sum[x1-1]);
        }
    }
}
