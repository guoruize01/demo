package acwing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//单调栈
public class my830 {
    static int N =10010;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] stk = new int[N];
//        int tt = 0;
//        int n = sc.nextInt();
//        while(n-->0){
//            int x = sc.nextInt();
//            while(stk[tt]>=x && tt!=0){
//                tt--;
//            }
//            if(tt==0)
//                System.out.println("-1 ");
//            else
//                System.out.println(stk[tt]);
//            stk[++tt]=x;
//        }
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new LinkedList<>();
        int n = sc.nextInt();
        while(n-->0){
            int x = sc.nextInt();
            while(!stack.isEmpty() && stack.peek()>=x){
                stack.pop();
            }
            if(stack.isEmpty()) {
                System.out.println("-1 ");
            }else System.out.println(stack.peek());
            stack.push(x);
        }
    }
}
