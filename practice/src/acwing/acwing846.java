package acwing;
//树的重心
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class acwing846 {
    static int N = 100010,M = N*2;
    static int n;
    static int h[] = new int[N],e[] = new int[M],ne[] = new int[M],idx;//	h存头结点、e存储节点值、ne存储next节点值
    static boolean st[] = new boolean[N];
    static int ans = N;
    static void add(int a,int b) {
        e[idx] =b;
        ne[idx]=h[a];
        h[a] =idx++;
    }

    static int dfs(int u) {
        st[u] = true;
        int sum = 1,res = 0;
        for(int i=h[u];i!=-1;i=ne[i]) {
            int j=e[i];
            if(!st[j]) {
                int s = dfs(j);
                res = Math.max(res,s);
                sum += s;
            }
        }
        res = Math.max(res, n-sum);
        ans = Math.min(ans,res);
        return sum;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(h, -1);
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n-1;i++) {
            String s[] = bf.readLine().split(" ");
            int a,b;
            a=Integer.parseInt(s[0]);b=Integer.parseInt(s[1]);
            add(a,b);add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
}

