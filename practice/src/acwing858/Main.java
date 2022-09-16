package acwing858;
//Prim算法求最小生成树
import java.io.*;
import java.util.*;

class Main{

    //零、声明变量
    public static int INF = 0x3f3f3f3f, N=510;
    public static int n,m;
    /*
    【重点1】不同与DijKstra，这里dist[]代表距离集合/当前最小生成树的距离，而非距起点的距离；
             实际上，距离集合的距离=距离集合中一个结点的距离.    */
    public static int[] dist = new int[N];
    public static boolean[] st = new boolean[N];
    public static int[][] g = new int[N][N];

    //一、编写Prim方法
    public static int prim(){

        //1.1 初始化dist数组，声明遍历时所需的变量
        Arrays.fill(dist,INF);//不是初始化为-1
        int res = 0;//res记录最小生成树的树边权重之和
    /*
    【重点2】这里声明dist[0]与否，会决定后面代码的形式
             如果不声明，1.2中(1.5)(3)这两步需要特判第一个点时的情况，因为其初始dist=INF
    */
        dist[1] = 0;

        //1.2 遍历n遍，保证遍历到每个顶点
        for(int j = 0; j < n; j++){
            //【重点3】t得放在外层for循环内，而不能放在循环外；t每次必须刷新，不然一直是最小的！（DijKstra里同样如此）
            int t = -1;

            //(1)遍历所有顶点：找到距离集合最近的，未被标记（=已经确定属于最小生成树）的，顶点
            for(int i = 1; i <= n; i++){//对应编号1~n
                if(!st[i] && (t == -1 || dist[t] > dist[i])) t = i;
            }

            //(1.5) 排除与无向图不连通的点
            //if(j != 0 && dist[t] == INF) return INF;//未申明 dist[1] = 0;时，需要特判
            if(dist[t] == INF) return INF;

            //(2)找到的t节点当前距集合最近，对其标记
            st[t] = true;

            //(3)更新最小生成树的树边权重之和
            //      这一步必须在(4)前，因为(4)中会用到dist[t]
            //      if(j != 0) res += dist[t];//未申明 dist[1] = 0;时，需要特判
            res += dist[t];

            //(4)用t更新相连的其他点
            for(int i = 1; i <= n; i++ ){//1~n
                if(!st[i] && dist[i] > g[t][i]) dist[i] = g[t][i];
                //prev[i] = t;
            }
        }
        //3. 返回完整最小生成树的树边权重之和
        return res;
    }


    //二、接收指令并执行
    public static void main(String[] args) throws IOException{
        //2.1 输入输出
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] o = br.readLine().split(" ");
        n = Integer.parseInt(o[0]);
        m = Integer.parseInt(o[1]);

        //2.2 初始化
        //(1)初始化邻接矩阵
        for(int i = 0; i < N; i++){
            Arrays.fill(g[i],INF);
        }
        //(2)读入边
        int u,v,w;
        while (m-- > 0){
            o = br.readLine().split(" ");
            u = Integer.parseInt(o[0]);
            v = Integer.parseInt(o[1]);
            w = Integer.parseInt(o[2]);

            if(u != v){
                g[u][v] = g[v][u] = Math.min(g[u][v],w);//避免重边
            }else{
                g[u][v] = 0;//消除自环
            }
        }

        //2.3 调用方法，获取结果
        int num = prim();
        if(num == INF) {
            System.out.println("impossible");
        }else{
            System.out.println(num);
        }

    }



}
