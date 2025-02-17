package designpattern.adapter;

// 目标接口，5V充电口
interface Target {
    int get5V();
}

// 被适配的类，220V电源
class Adaptee220V {
    public int get220V() {
        return 220;
    }
}

//对象适配器，通过组合实现
public class ObjectAdapter implements Target {
    private Adaptee220V adaptee;
    public ObjectAdapter(Adaptee220V adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int get5V() {
        return adaptee.get220V() / 44;
    }
}
