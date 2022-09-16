package demo04Lambda;

public class Demo04 {
    public static void main(String[] args) {
        invokeCalc(20, 10, new Caculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });
        invokeCalc(20,40,(int a,int b)->{
            return a+b;
        });
    }
    public static void invokeCalc(int a,int b, Caculator c){
        int sum = c.calc(a,b);
        System.out.println(sum);
    }
}
