package designpattern.adapter;

//客户端代码使用
public class AdapterDemo {
    public static void main(String[] args) {
        Target objectAdapter = new ObjectAdapter(new Adaptee220V());
        System.out.println("对象适配器输出：" + objectAdapter.get5V());
    }
}
