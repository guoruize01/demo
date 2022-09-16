package acwing;

import java.util.Scanner;

public class my826 {
    private static int N =10010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int hh =-1;
    private static int idx = 0;

    public static void addhead(int x){
        e[idx] = x;
        ne[idx] = hh;
        hh = idx++;
    }
    public static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k]=idx++;
    }
    public static void delete(int k){
        ne[k] =ne[ne[k]];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            String op = sc.next();
            if(op.equals("H")){
                int x = sc.nextInt();
                addhead(x);
            }else if("D".equals(op)){
                int k = sc.nextInt();
                if(k==0) {
                    hh =ne[hh];
                }else delete(k-1);
            }else{
                int k=sc.nextInt();
                int x = sc.nextInt();
                add(k-1,x);
            }
        }
        for (int i = hh; i !=-1 ; i=ne[i]) {
            System.out.print(e[i]+" ");
        }
    }
}
