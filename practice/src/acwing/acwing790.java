package acwing;

import java.io.*;
class acwing790{

    static boolean check(double mid, double n){
        if(mid * mid * mid <= n)return true;
        return false;
    }

    static double binserySearch(double l, double r, double n){
        if(l > r)return -1;
        while(r - l > 1e-7){//要求几位数，在向后加1位
            double mid = (l + r) / 2;
            if(check(mid, n))l = mid;
            else r = mid;
        }
        return l;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.valueOf(buf.readLine());
        double res = binserySearch(-1000, 1000, n);
        System.out.printf("%.6f\n",res);
    }
}
