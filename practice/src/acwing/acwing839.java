package acwing;

import java.util.*;

public class acwing839 {
    static int N = 100010;
    // size 存放大小
    static int size = 0;
    // h代表堆
    static int[] h = new int[N];

    /*
     * p: pointer, h: heap
     * ph[]: 代表位置到堆的映射 比如：ph[k]：代表第k次插入的数 在堆的什么位置(下标)
     * hp[]: 代表堆到位置的映射 比如：hp[j]：代表在堆的下标为j的元素 是第哪一次插入的
     * 映射关系: 若hp[j] = k，则ph[k] = j。
     *
     * 为什么要有两个映射？因为，当删除或修改第k个插入的数，可能会发生交换,
     *    交换的时候通过下标(hp)来找到对应的是哪一次
     *    插入的数，从而维持两者的ph指向的下标
     */
    static int[] ph = new int[N], hp = new int[N];

    // 交换数组的两个元素
    static void swap(int a[], int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    // 应用于堆的交换
    static void heap_swap(int a, int b) {
        // 维护位置到堆的映射
        swap(ph, hp[a], hp[b]);
        // 维护堆到位置的映射
        swap(hp, a, b);
        // 交换堆中两个元素的值
        swap(h, a, b);
    }
    // down操作是看一个元素是否需要往下移动
    static void down(int u) {
        int t = u;
        // 如果左儿子存在 并且 左儿子比根节点小， 就使 t 保存 左儿子下标
        if(u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        // 如果右儿子存在 并且 右儿子比t所代表的值小， 就使 t 保存右儿子下标
        if(u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        // 如果t发生了变化，说明需要就行交换
        if(t != u) {
            heap_swap(t, u);
            // 继续递归则过程
            down(t);
        }
    }

    static void up(int u) {
        // 只要根节点存在，并且u这个节点的值 比 根节点小，就需要交换
        while(u / 2 > 0 && h[u] < h[u / 2]) {
            heap_swap(u, u / 2);
            u /= 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();
        // m：代表当前是第m个插入的数
        int m = 0;
        while(n -- > 0) {
            String[] s = sc.nextLine().split(" ");
            String op = s[0];
            int k, x;

            if(op.equals("I")){
                x = Integer.parseInt(s[1]);
                // 都是从下标1开始
                ++ size;
                ++ m;
                ph[m] = size; // 初始化
                hp[size] = m; // 初始化

                h[size] = x;
                up(size);
            }else if(op.equals("PM")) {
                System.out.println(h[1]);
            }else if(op.equals("DM")) {
                // 为啥用最后一个元素覆盖第一个元素？因为删除第一个点不方便
                // h[1] = h[size --]; // 不能写成这种，因为要维持映射
                heap_swap(1, size);
                size --;
                down(1);
            }else if(op.equals("D")) {
                k = Integer.parseInt(s[1]);
                // 将第k次插入的元素，转换为堆中的下标
                k = ph[k];
                heap_swap(k, size);
                size --;
                // 下面两个操作只会执行其中一个
                down(k);
                up(k);

            }else if(op.equals("C")) {
                k = Integer.parseInt(s[1]); x = Integer.parseInt(s[2]);
                k = ph[k];
                h[k] = x;
                // 下面两个操作只会执行其中一个
                down(k);
                up(k);
            }
        }

    }
}

