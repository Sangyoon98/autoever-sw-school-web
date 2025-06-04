package 컬렉션프레임워크실습문제;
// Comparator : 두개의 입력을 받아 정렬해주는 클래스

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Car> arr = new TreeSet<>(new CarComparator().reversed());

        for (int i = 0; i < 10; i++) {
            System.out.print("차량 이름 : ");
            String name = sc.next();
            System.out.print("차량 연식 : ");
            int year = sc.nextInt();
            System.out.print("차량 가격 : ");
            int price = sc.nextInt();
            arr.add(new Car(year, name, price));
        }

        for (Car car : arr) System.out.println("연식: " + car.year + ", 자동차명 : " + car.name + ", 가격 : " + car.price);
    }
}

class Car {
    public int year;
    public String name;
    public int price;

    public Car(int year,String name, int price) {
        this.year = year;
        this.name = name;
        this.price = price;
    }
}

class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.price - o1.price;
    }

    @Override
    public Comparator<Car> reversed() {
        return Comparator.super.reversed();
    }
}

