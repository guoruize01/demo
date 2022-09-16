package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class my785_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        quicksort(arr,0,num-1);
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void quicksort(int[] arr, int l,int r){
        if(l>=r) return;
        int i = l-1;
        int j=r+1;
        int x = arr[l+r>>1];
        while (i<j){
            do{i++;} while (arr[i]<x);
            do{j--;} while(arr[j]>x);
            if(i<j){
                int tmp =arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quicksort(arr,l,j);
        quicksort(arr,j+1,r);
    }
}
