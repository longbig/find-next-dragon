//package designpattern.factory;
//
//public class SimpleFactory {
//    public static void main(String[] args) {
//        Car car = CarFactory.createCar("Bmw");
//        car.drive();
//    }
//}
//
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
//class CarFactory {
//    public static Car createCar(String type) {
//        if ("Benz".equals(type)) {
//            return new Benz();
//        }
//        if ("Bmw".equals(type)) {
//            return new Bmw();
//        }
//        throw new IllegalArgumentException("unknown type");
//    }
//}