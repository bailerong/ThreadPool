import java.util.concurrent.*;
public class FixedThreadPoolTest {
    public static ExecutorService newFixedThreadPool(int nThreads){
        return new ThreadPoolExecutor(nThreads,nThreads,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
    public static void main(String[] args) {

        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10;j++){
                        System.out.println(Thread.currentThread().getName()+" 、"+j);
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
//我们的固定数量的线程池
