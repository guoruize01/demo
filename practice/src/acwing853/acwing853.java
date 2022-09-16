package acwing853;
//Bellman-Ford算法适合解决有边数限制的最短路问题
//3 3 1
//1 2 1
//2 3 1
//1 3 3
//输出：3
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class acwing853 {
    /* bellman - ford算法擅长解决有边数限制的最短路问题
     * for n次
        for 所有边 a,b,w (松弛操作)
            dist[b] = min(dist[b],back[a] + w)
            back[] 数组是上一次迭代后 dist[] 数组的备份
     */
    static int N=510;
    static int M=100010;
    static int n,m,k;
    static int[] dist=new int[N];
    static Node[] list=new Node[M];
    static int INF=0x3f3f3f3f;
    static int[] back=new int[N]; //备份dist数组
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        k=Integer.parseInt(s[2]);
        for (int i = 0; i <m; i++) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int c = Integer.parseInt(s2[2]);
            list[i]=new Node(a,b,c);
        }
        bellman_ford();
    }

    static void bellman_ford() {
        //全部填充INF
        Arrays.fill(dist, INF);
        //自己到自己的距离为0
        dist[1]=0;

        //最多经过k条边
        for (int i = 0; i <k; i++) {
            //数组备份
            back=Arrays.copyOf(dist, n+1);//由于是从1开始存到n
            for (int j = 0; j <m; j++) { //循环j从1到m，遍历m条边，把所有边都进行松弛操作；
                Node node=list[j];
                int a=node.a;
                int b=node.b;
                int c=node.c;
                //进行距离比较 取最短距离
                dist[b]=Math.min(dist[b], back[a]+c);
            }
        }
        //INF是一个确定的值，并非真正的无穷大，会随着其他数值而受到影响，dist[n]大于某个与INF相同数量级的数即可
        if(dist[n] > INF/2) System.out.println("impossible");
        else System.out.println(dist[n]);
    }

}

class Node{
    int a,b,c;
    public Node(int a,int b,int c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}


