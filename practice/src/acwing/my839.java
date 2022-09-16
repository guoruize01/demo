package acwing;

import java.util.Scanner;

public class my839 {
    static int N=10010;
    static int[] h = new int[N];
    static int[] hp = new int[N];
    static int[] ph = new int[N];
    static int size=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        while(n-->0){
            String[] s =sc.nextLine().split(" ");
            String op = s[0];
            int k,x;
            if("I".equals(op)){
                x = Integer.parseInt(s[1]);
                ++size;
                ++m;
                ph[m]=size;
                hp[size] = m;
                h[size] = x;
                up(size);
            }else if("PM".equals(op)){
                System.out.println(h[1]);
            }else if("DM".equals(op)){
                heap_swap(1,size);
                size--;
                down(1);
            }else if("D".equals(op)){
                k = Integer.parseInt(s[1]);
                k = ph[k];
                heap_swap(k,size);
                size--;
                down(k);
                up(k);
            }else if(op.equals("C")){
                k =Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                k = ph[k];
                h[k] =x;
                down(k);
                up(k);
            }
        }

    }
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j] = tmp;
    }
    private static void heap_swap(int i,int j){
        swap(hp,hp[i],hp[j]);
        swap(ph,i,j);
        swap(h,i,j);
    }
    private static void down(int n){
        int x = n;
        if(2*n<=size&&h[x]>h[2*n]) x = 2*n;
        if(2*n+1<=size&&h[x]>h[2*n+1]) x =2*n+1;
        if(x!=n){
            heap_swap(x,n);
            down(x);
        }
    }
    private static void up(int k){
        while(k/2>0&&h[k/2]>h[k]){
            heap_swap(k/2,k);
            k/=2;
        }
    }
}
