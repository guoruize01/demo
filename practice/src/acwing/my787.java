package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class my787 {
    static int N = 10010;
    static int[] arr = new int[N];
    static int[] tmp = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        mergesort(arr,0,num-1);
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void mergesort(int[] arr, int l, int r){
        if(l>=r) return;
        int mid = l+r>>1;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);
        int i=l;
        int j = mid+1;
        int k=0;
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]) tmp[k++] =arr[i++];
            else tmp[k++]= arr[j++];
        }
        while(i<=mid){
            tmp[k++] = arr[i++];
        }
        while (j<=r){
            tmp[k++] = arr[j++];
        }
        for (int m=l,n=0; n<k ; m++,n++) {
            arr[m] = tmp[n];
        }
    }
}
