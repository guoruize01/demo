package acwing;

import java.util.Scanner;

public class acwing787 {

    static final int N = 100010;
    static int[] arr = new int[N];
    static int[] tmp = new int[N]; // 临时数组, 用于临时存储排好序的数据

    public static void main(String[] args) {
        // 对输入值进行初始化
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // 归并排序
        mergeSort(arr, 0, n - 1);

        // 打印输出
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 归并排序
    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        // 递归对左右半边处理
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);
        // 排序，归并
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r)
            if (q[i] <= q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];

        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
        // 存回原序列中
        for (i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
    }
}


