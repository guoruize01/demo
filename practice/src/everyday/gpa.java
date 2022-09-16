package everyday;
class gpa{
    public static void main(String[] args) {
        double sum = 83*3.3+94*4+88*3.7+94*4+86*3.7+78*3+85*3.7+91*4+90*4+87*3.3+81.4*3+82.1*3+91*4;
        double mu = 83.3+94+88+94+86+78+85+91+90+87+81.4+82.1+91;
        double res = sum/mu;
        System.out.println(res);
    }
}