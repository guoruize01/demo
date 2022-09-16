package everyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) throws IOException {

    }
    public static int check() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String s2 = br.readLine();
        int l = Integer.parseInt(s1[0]);
        int id = Integer.parseInt(s1[1]);
        if(s2.length()!=l-16){
            return -4;
        }
        int p =32;
        String len = s2.substring(32,32+7);
        int x = Integer.parseInt(len,16);
        if(s2.length()-x!=40){
            return -4;
        }
        p = p+8;
        while(x--!=0){
            int length = Integer.parseInt(s2.substring(p+2,p+3),16);
            int end = p+length+3;
            String temp = s2.substring(p,end);

            p = end+1;
        }
        return p;
    }
}
