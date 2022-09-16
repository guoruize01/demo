package everyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().split(" ")[0];
        String[] s2 = br.readLine().split(" ");
        int m = Integer.parseInt(s2[0]);
        int n = Integer.parseInt(s2[1]);
        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = line[j];
            }
        }
        boolean[][] select = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(s1.equals(arr[i][j])){
                    select[i][j] =true;
                    if(i>0){

                    }
                }
            }
        }
    }
}
