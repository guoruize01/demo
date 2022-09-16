package acwing;
//滑动窗口
import java.io.IOException;

/**
 *
 * P154 滑动窗口
 * @author vccyb
 *
 */

import java.io.*;
public class acwing154 {
    //1. 定义队列
    private static final int N = 1000010;
    private static int[] q = new int[N];
    private static int[] arr = new int[N];
    private static int hh = 0, tt = -1;//队头和队尾

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]); // 数组长度
        int m = Integer.parseInt(line1[1]); // 滑动窗口长度
        String[] line2 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(line2[i]);
        }

        //1. 求解最小值、那么队列存取升序
        //q[]中存储的是坐标
        for(int i=0;i<n;i++){
            //滑出了，从对头出队
            //k=3  i=0,1,2 3划出
            if(hh<=tt&&i-m+1>q[hh]){
                hh++;
            }

            //保证升序
            while(hh<=tt&&arr[q[tt]]>=arr[i]){
                tt--;
            }

            //存入坐标
            q[++tt] = i;

            if(i+1>=m){
                bw.write(arr[q[hh]]+" ");
            }
        }

        bw.write("\n");
        //求解最大值，保证降序
        hh=0;
        tt=-1;
        for(int i=0;i<n;i++){
            //滑出
            if(hh<=tt&&i-m+1>q[hh]){
                hh++;
            }

            //最大值，降序
            while(hh<=tt&&arr[q[tt]]<arr[i]){
                tt--;
            }

            q[++tt] = i;
            if(i+1>=m){
                bw.write(arr[q[hh]]+" ");
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
