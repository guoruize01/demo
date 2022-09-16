package demo01;

public class Chihuo extends Thread{
    private Baozi bz;

    public Chihuo(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized(bz){
                if(!bz.flag){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("正在吃包子"+bz.pi+bz.xian);
                bz.flag=false;
                bz.notify();
                System.out.println("已经把"+bz.pi+bz.xian+"包子吃完了");
                System.out.println("--------------------------------");
            }
        }
    }
}
