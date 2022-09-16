package demo01ThreadPool;

public class RunableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个线程");
    }
}
