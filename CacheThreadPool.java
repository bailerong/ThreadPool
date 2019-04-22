import java.util.concurrent.*;
/*无大小界的线程池*/
public class CacheThreadPool {
  public static ExecutorService newCachedThreadPool(){
      return new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,
              TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
  }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
