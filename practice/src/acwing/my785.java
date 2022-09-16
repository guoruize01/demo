package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class my785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        quicksort(arr,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void quicksort(int[] arr,int l,int r){
        if(l>=r) return;
        int x = arr[l+r>>1];
        int i = l-1;
        int j = r+1;
        while(i<j){
            do{i++;} while(arr[i]<x);
            do{j--;} while(x<arr[j]);
            if(i<j){
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] = temp;
            }
        }
        quicksort(arr,l,j);
        quicksort(arr,j+1,r);

    }
}
