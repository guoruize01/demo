package acwing;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    static int N =100000007;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String x = "5";
        int a = Integer.parseInt(x);
        String num = sc.nextLine();
        int[] arr = new int[4];
        arr[0] = Integer.parseInt(num,2)%N;
        arr[1] = Integer.parseInt(num,8)%N;
        arr[2] = Integer.parseInt(num)%N;
        arr[3] = Integer.parseInt(num,16)%N;
        Arrays.sort(arr);
        int tmp = -1;
        for (int i = 0; i < 4; i++) {
            if(tmp==arr[i]) continue;
            tmp= arr[i];
            System.out.println(arr[i]);
        }
    }
}
