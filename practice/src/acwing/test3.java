package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test3 {
    static int n=24;

    public static void main(String[] args) throws IOException {
        List<String> strList = new ArrayList<String>();
        strList.add("1");
        strList.add("2");
        strList.add("3");

        String[] strArr = null;

        strArr = strList.toArray(new String[strList.size()]);
        System.out.println(Arrays.toString(strArr));
    }
}
