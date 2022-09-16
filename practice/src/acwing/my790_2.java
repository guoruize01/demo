package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class my790_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double target= Double.valueOf(br.readLine());
        double res =  binarySerch2(-2000,2000,target);
        System.out.println(res);
    }
    public static double binarySerch2(double l, double r, double n){
        if(l>r) return -1;
        while(r-l>1e-7){
            double mid = (l+r)/2;
            if(check(mid,n)){
                l = mid;
            }else{
                r= mid;
            }
        }
        return l;
    }
    public static boolean check(double x,double n){
        if(x*x*x<=n){
            return true;
        }

        return false;
    }
}
