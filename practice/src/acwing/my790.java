package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class my790 {
    public static boolean check(double m,double n){
        if(m*m*m<=n)return true;
        return false;
    }
    public static double binserySearch(double l,double r,double n){
        if(l>r) return -1;
        while(r-l>1e-1){
            double mid =(l+r)/2;
            if(mid*mid*mid>n) r=mid;
            else l =mid;
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.valueOf(br.readLine());
        double res = binserySearch(-1000,1000,n);
        System.out.println(res);
    }
}
