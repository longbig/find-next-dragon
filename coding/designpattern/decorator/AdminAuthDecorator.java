package designpattern.decorator;


//核心接口
interface ApiHandler {
    String handle(String request);
}

//具体API实现
class UserApiHandler implements ApiHandler {
    @Override
    public String handle(String request) {
        return "User data";
    }
}

//权限装饰器基类
abstract class AuthDecorator implements ApiHandler {
    protected ApiHandler wrapped;
    public AuthDecorator(ApiHandler wrapped) {
        this.wrapped = wrapped;
    }
    public abstract String handle(String request);
}

//具体权限装饰器，管理员校验
public class AdminAuthDecorator extends AuthDecorator {
    public AdminAuthDecorator(ApiHandler wrapped) {
        super(wrapped);
    }

    @Override
    public String handle(String request) {
        if ("管理员".equals(request)) {
            return "权限错误";
        }
        return wrapped.handle(request);
    }
}
