package designpattern.singleton;

public class LazySingleton {
    //volatile防止指令重排序
    private static volatile LazySingleton instance;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        //第一次检查，确保不必要的同步
        if (instance == null) {
            synchronized (LazySingleton.class) {
                //第二次检查，确保只有一个线程创建实例
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
