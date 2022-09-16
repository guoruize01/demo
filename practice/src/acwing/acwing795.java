package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    前缀和
 */
public class acwing795 {
    private static int N = 100010;  //定义数组大小，防止越界

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s0 = br.readLine().split(" ");
        //输入序列长度 n 和询问次数 m
        int n = Integer.parseInt(s0[0]);
        int m = Integer.parseInt(s0[1]);

        //输入整数序列
        String[] s1 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int j = 0,i = 1;j<s1.length&&i<=n;j++,i++){
            arr[i] = Integer.parseInt(s1[j]);
        }

        //前缀和
        int s[] = new int[N];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + arr[i];
        }

        //输入询问区间范围
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int l = Integer.parseInt(s2[0]);
            int r = Integer.parseInt(s2[1]);
            System.out.println(s[r] - s[l - 1]);
        }
    }
}

