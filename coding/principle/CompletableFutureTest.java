package principle;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuyunlong
 * @date 2025/3/27 21:47
 * @description
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        UserService userService = new UserService();
        //1、使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() ->
                userService.getUserInfo(), executor);
        //2、CompletableFuture.completedFuture()直接创建一个已完成状态的CompletableFuture
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result2");
        //3、先初始化一个未完成的CompletableFuture，然后通过complete() completeExceptionally()，完成该CompletableFuture
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("success");
        //一元依赖
        CompletableFuture<String> cf3 = cf1.thenApply(result1 -> {
            //result1为CF1的结果
            //......
            return "result3";
        });
        CompletableFuture<String> cf5 = cf2.thenApply(result2 -> {
            //result2为CF2的结果
            //......
            return "result5";
        });

        // 二元依赖
        CompletableFuture<String> cf4 = cf1.thenCombine(cf2, (result1, result2) -> {
            //result1和result2分别为cf1和cf2的结果
            return "result4";
        });

        //多元依赖
        CompletableFuture<Void> cf6 = CompletableFuture.allOf(cf3, cf4, cf5);
        CompletableFuture<String> result = cf6.thenApply(v -> {
            //这里的join并不会阻塞，因为传给thenApply的函数是在CF3、CF4、CF5全部完成时，才会执行 。
            String result3 = cf3.join();
            String result4 = cf4.join();
            String result5 = cf5.join();
            //根据result3、result4、result5组装最终result;
            return result3 + result4 + result5;
        });

    }
}
