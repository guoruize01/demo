package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class acwing785{
    public static void main(String[] args) throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        String[] res = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(res[i]);
        }

        quickSort(arr, 0, num - 1);

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }
        br.close();

    }
    //闫总快排模板 v.v
    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        int x = q[l+r>>1];

        //Define positions of two pointers
        int i = l - 1;
        int j = r + 1;

        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            //do Swap
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }

        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}


