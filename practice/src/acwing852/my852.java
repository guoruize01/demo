package acwing852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class my852 {
    static int n,m,idx;
    static int N = 10010;
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];
    static int[] e = new int[N], ne=new int[N], w = new int[N],h = new int[N];
    static int[] cnt = new int[N];


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        Arrays.fill(h,-1);
        while(m-->0){
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int c = Integer.parseInt(s2[2]);
            add(a,b,c);
        }
        if(spfa()){
            System.out.println("Yes");
        }else System.out.println("No");
    }

    public static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] =h[a];
        h[a] = idx++;
    }

    public static boolean spfa(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            int t = queue.poll();
            for(int i = h[t];i!=-1;i= ne[i]){
                int j = e[i];
                if(dist[j]>dist[t]+w[i]){
                    dist[j] = dist[t]+w[i];
                    cnt[j] = cnt[t]+1;
                    if(cnt[j]>n) return true;
                    if(!st[j]) {
                        st[j] =true;
                        queue.offer(j);
                    }
                }
            }

        }
        return false;
    }
}
