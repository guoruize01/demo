package acwing;

import java.util.*;

public class acwing826{
    private static int N = 100010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    //头节点指针
    private static int hh;
    //下一个节点位置
    private static int idx;

    //初始化第1个插入节点下标为0，所以操作第k个数时都要-1 ！！
    public static void init(){
        //头节点指向空
        hh = -1;
        idx = 0;
    }
    //插到头节点后
    public static void insertH(int x){
        e[idx] = x;
        ne[idx] = hh;
        hh = idx++;
    }
    //插到第k个节点后
    public static void insertK(int k,int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }
    //删除第k个数后面的数
    public static void delete(int k){
        ne[k] = ne[ne[k]];
    }
    public static void main(String[] args){
        //别忘了先初始化！！！否则打印超时
        init();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while(m-- > 0){
            String op = scanner.next();
            if("H".equals(op)){
                int x =scanner.nextInt();
                insertH(x);
            }else if("D".equals(op)){
                int k =scanner.nextInt();
                if(k == 0){
                    //当k为0时，删除头结点，不是清空链表
                    hh = ne[hh];
                }else{
                    delete(k - 1);
                }
            }else if("I".equals(op)){
                //k和x接收位置不要写反！！
                int k =scanner.nextInt();
                int x =scanner.nextInt();
                insertK(k - 1,x);
            }
        }

        for(int i = hh;i != -1;i = ne[i]){
            System.out.print(e[i] + " ");
        }
    }
}

