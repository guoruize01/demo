package acwing;

import java.util.Scanner;

public class my789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        while(q-->0){
            int target = sc.nextInt();
            int l=0,r=n-1;
            while (l<r){
                int mid=l+r>>1;
                if(arr[mid]>=target){
                    r = mid;
                }else {
                    l = mid+1;
                }
            }
            if(arr[l]!=target){
                System.out.println("-1 -1");

            }else {
                System.out.print(l+" ");

                l=0;
                r=n-1;
                while(l<r){
                    int mid = l+r+1>>1;
                    if(arr[mid]<=target){
                        l = mid;
                    }else {
                        r = mid-1;
                    }
                }
                System.out.println(l);
            }

        }
    }
}
