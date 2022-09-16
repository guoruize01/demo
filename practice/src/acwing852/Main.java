package acwing852;
//3 3
//1 2 -1
//2 3 4
//3 1 -4
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    /*
     * 统计当前每个点的最短路中所包含的边数，如果某点的最短路所包含的边数大于等于n，则也说明存在环
     */
    static int N=10010;
    static int[] ne=new int[N],e=new int[N],h=new int[N],w=new int[N];
    static int idx,n,m;
    static boolean[] st=new boolean[N];// st[i] 要来表示节点i是否在队列里面
    static int[] cnt=new int[N];  //记录虚拟源点到x的最短距离
    static int[] dist=new int[N]; //记录当前x点到虚拟源点最短路的边数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();m=sc.nextInt();

        Arrays.fill(h,-1);
        for (int i = 1; i<=m; i++) {
            int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
            add(a,b,c);
        }
        if(spfa()) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    static void add(int a,int b,int c) {
        e[idx]=b;
        w[idx]=c;
        ne[idx]=h[a];
        h[a]=idx++;
    }

    static boolean spfa() {
        //负环不一定是从1点开始 ，将所有的点入队列
        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            q.offer(i);
        }
        while(!q.isEmpty()) {
            int t=q.poll();
            st[t]=false;
            for(int i=h[t];i!=-1;i=ne[i]) {
                int j=e[i];
                //表示从t点走到j点能够让权值变少，因此进行对该点j进行更新
                if(dist[j]>dist[t]+ w[i]) {
                    dist[j]=dist[t]+w[i];
                    cnt[j]=cnt[t]+1; //往前走一步
                    //若有n条边，至少有n+1个节点
                    if(cnt[j]>=n) {
                        return true;
                    }
                    if(!st[j]) {
                        st[j]=true;
                        q.offer(j);
                    }
                }

            }
        }
        return false;
    }
}
