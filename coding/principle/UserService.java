package principle;

/**
 * @author yuyunlong
 * @date 2025/3/27 21:20
 * @description
 */
public class UserService {

    public String getUserInfo() {
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "getUserInfo() 返回结果";
    }

    public String getUserAddress() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "getUserAddress() 返回结果";
    }
}
