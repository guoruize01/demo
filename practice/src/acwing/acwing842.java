package acwing;
//排列数字
import java.util.*;
public class acwing842{
    static int N=10;

    static int n;
    static int path[]=new int [N];
    //用来存放数字排列的顺序
    static boolean st[]=new boolean [N];
    //用来存储每个数字是否被使用的状态

    //dfs用递归的方式来实现深度遍历
    public static void dfs(int u) {
        if(u==n) {
            //递归的终止条件 当path 已经填满的时候 就输出数字排列的顺序
            for(int i=0;i<n;i++) {
                System.out.print(path[i]+" ");
            }
            System.out.println();
            //结束递归 此时返回到上一个递归
            return;
        }else {
            for(int i=1;i<=n;i++) {
                if(!st[i]) {
                    //判断这个数字之前是否被使用过 如果没有被使用过那么就放入

                    path[u]=i;
                    st[i]=true;
                    dfs(u+1);
                    //递归结束后 需要恢复之前的现场
                    //path[u]=0;  这一处可以省略 因为每次调用递归dfs的时候都会覆盖path[u]
                    //令此时的数字的状态恢复初始值
                    //然后进入下一个for循环 此时实现了按照字典序的数字排列
                    //进而达到全排列
                    st[i]=false;
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner reader =new Scanner(System.in);
        n=reader.nextInt();
        dfs(0);
    }

}
