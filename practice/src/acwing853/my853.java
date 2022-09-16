package acwing853;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class my853 {
    static int n, m, k;
    static int N = 500;
    static int M = 10010;
    static int[] dist = new int[N];
    static Node[] list = new Node[M];
    static int[] backup = new int[N];
    static int INF=0x3f3f3f3f;

    public static void bf(){
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dist, n + 1);
            for (int j = 0; j < m; j++) {
                Node node = list[j];
                int a = node.a;
                int b = node.b;
                int c = node.c;
                dist[b] = Math.min(dist[b], backup[a] + c);
            }
        }
        if (dist[n] > INF/ 2) System.out.println("impossible");
        else System.out.println(dist[n]);
    }

    public static void main (String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
            list[i] = new Node(a, b, c);
        }
        bf();

    }

    static class Node {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}