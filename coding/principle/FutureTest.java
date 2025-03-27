package principle;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yuyunlong
 * @date 2025/3/27 21:19
 * @description
 */
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        UserService userService = new UserService();
        try {
            Long start = System.currentTimeMillis();
            Future<String> future1 = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return userService.getUserInfo();
                }
            });
            Future<String> future2 = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return userService.getUserAddress();
                }
            });
            String result1 = future1.get();
            System.out.println(result1);
            String result2 = future2.get();
            System.out.println(result2);

            System.out.println("两个任务执行耗时：" + (System.currentTimeMillis() - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
