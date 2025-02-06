package designpattern.factory;

public class AbstractFactory {
    public static void main(String[] args) {
        CarAbstractFactory carAbstractFactory = new BenzFactory();
        Car car = carAbstractFactory.createCar();
        Tire tire = carAbstractFactory.createTire();
        car.drive();
        tire.wear();
    }
}

//产品族接口（汽车 + 轮胎）
interface Car {
    void drive();
}

interface Tire {
    void wear();
}

//具体产品族，benz族系列
class BenzCar implements Car {
    @Override
    public void drive() {
        System.out.println("Benz Car.......");
    }
}

class BenzTire implements Tire {
    @Override
    public void wear() {
        System.out.println("Benz Tire......");
    }
}
//抽象工厂接口
interface CarAbstractFactory {
    Car createCar();
    Tire createTire();
}
//具体工厂实现
class BenzFactory implements CarAbstractFactory {
    @Override
    public Car createCar() {
        return new BenzCar();
    }
    @Override
    public Tire createTire() {
        return new BenzTire();
    }
}