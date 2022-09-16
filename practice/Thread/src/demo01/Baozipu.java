package demo01;

public class Baozipu extends Thread {
    private Baozi bz;

    public Baozipu(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (bz){
                if(bz.flag){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }
                System.out.println("开始做包子");
                if(count%2==0){
                    bz.pi="薄皮";
                    bz.xian="五仁";
                }else{
                    bz.pi="冰皮";
                    bz.xian="牛肉";
                }
                count++;
                System.out.println("正在生产包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = true;
                System.out.println("包子做好了"+bz.pi+bz.xian);
                System.out.println("来吃包子");
                bz.notify();
            }
        }

    }
}
