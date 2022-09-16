package acwing;

//建堆
//删除最小值
//删除指定下标k
//插入
//修改k的值

import java.io.*;
import java.lang.Integer;

class Main{
    static int N = 100010;
    static int[] t = new int[N];
    static int size = 0;
    static void down(int n){
        int x = n;
        if(n * 2 <= size && t[x] > t[n * 2]) x = n * 2;
        if(n * 2 + 1 <= size && t[x] > t[n * 2 + 1])x = n * 2 + 1;
        if(n != x){
            swap(n, x);
            down(x);
        }
    }
    public static void swap(int a ,int b){
        int temp=t[a];
        t[a] = t[b];
        t[b] = temp;
    }

    public static void main(String[] args)throws Exception{

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] params = buf.readLine().split(" ");
        int n = Integer.valueOf(params[0]);
        int m = Integer.valueOf(params[1]);
        size = n;
        String[] nums = buf.readLine().split(" ");
        for(int i = 1; i <= n; ++i){//存储
            t[i] = Integer.valueOf(nums[i - 1]);
        }
        for(int i = n / 2; i != 0; --i){//建堆
            down(i);
        }
        for(int i = 1; i <= m; ++i){//弹出最小值
            buw.write(t[1] + " ");
            t[1] = t[size];
            size--;
            down(1);//重新规整最小堆
        }
        buw.flush();
        buf.close();
        buw.close();

    }
}


