//package designpattern.factory;
//
//public class MethondFactory {
//    public static void main(String[] args) {
//        CarFactory carFactory = new BenzFactory();
//        Car car = carFactory.createCar();
//        car.drive(); //输出Benz.......
//    }
//}
//
//interface Car {
//    void drive();
//}
//
//class Benz implements Car {
//    @Override
//    public void drive() {
//        System.out.println("Benz.......");
//    }
//}
//
//class Bmw implements Car {
//    @Override
//    public void drive() {
//        System.out.println("Bmw......");
//    }
//}
//
//interface CarFactory {
//    Car createCar();
//}
//
//class BenzFactory implements CarFactory {
//    @Override
//    public Car createCar() {
//        return new Benz();
//    }
//}
//
//class BmwFactory implements CarFactory {
//    @Override
//    public Car createCar() {
//        return new Bmw();
//    }
//}
//
//
