package demo01;

public class test {
    public static void main(String[] args) {
        Baozi bz = new Baozi();
        Baozipu bzp = new Baozipu(bz);
        Chihuo ch = new Chihuo(bz);
        bzp.start();
        ch.start();
    }
}
