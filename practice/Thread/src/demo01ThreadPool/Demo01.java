package demo01ThreadPool;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new RunableImpl());
        es.submit(new RunableImpl());
        es.submit(new RunableImpl());
    }
}
