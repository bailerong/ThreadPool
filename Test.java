import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*向线程池提交任务*/
class RunnableThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+" 、"+i);
        }
    }
}
public class Test {

    public static void main(String[] args) {
        RunnableThread runnableThread=new RunnableThread();
       ThreadPoolExecutor threadPoolExecutor=
               new ThreadPoolExecutor(3,5,2000,
                       TimeUnit.MILLISECONDS,
               new LinkedBlockingDeque<Runnable>());
       for(int i=0;i<5;i++){
           threadPoolExecutor.execute(runnableThread);
       }
    }
}
