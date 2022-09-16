package everyday;

public class MyRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println("woda");
        try{
            Thread.sleep(1100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("教练来了"+Thread.currentThread().getName());
        System.out.println("积");
    }
}
