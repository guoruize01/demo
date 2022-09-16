

import java.util.*;

public class Test10 {
    Map<String,Character> map = new HashMap<String,Character>(){{
        put("1110111",'0');
        put("10010",'1');
        put("1011101",'2');
        put("1011011",'3');
        put("111010",'4');
        put("1101011",'5');
        put("1101111",'6');
        put("1010010",'7');
        put("1111111",'8');
        put("1111011",'9');
        put("1111110",'a');
        put("101111",'b');
        put("1100101",'c');
        put("11111",'d');
        put("1101101",'e');
        put("1101100",'f');
    }};
    public static void main(String[] args) {
        int a = 31;
        String s = Integer.toBinaryString(a);
        System.out.println(s);
    }
    public int left(int[] signal){
        int n = signal.length;
        int res =0;
        String s1= Integer.toBinaryString(signal[0]);
        String s2 = Integer.toBinaryString(signal[1]);
        char c1 = map.get(s1);
        return res;
    }
}
