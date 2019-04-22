import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

/*使用submit方法提交任务，获取返回值*/
class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+" 、"+i);
        }
        return Thread.currentThread().getName()+"任务执行结束";
    }
}
public class submitTest {
    public static void main(String[] args) {
        CallableThread callableThread=new CallableThread();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,2000, TimeUnit.MILLISECONDS,
        new LinkedBlockingDeque<Runnable>());
        for(int i=0;i<5;i++){
            Future<String> future=threadPoolExecutor.submit(callableThread);
            String str= null;
            try {
                str = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        }
    }
}
