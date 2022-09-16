package acwing;

import java.util.Scanner;

public class my801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0){
            int x = sc.nextInt();
            int res = 0;
            while (x!=0){
                x-=lowbit(x);
                res++;
            }
            System.out.print(res+" ");
        }
    }
    public static int lowbit(int x){
        return x&-x;
    }
}
