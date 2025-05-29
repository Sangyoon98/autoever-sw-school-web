package 다형성;

import java.util.Scanner;

public class DriveMain {
    public static void main(String[]args) {
        Driver driver = new Driver("우영우");
        SportsCar bus = new SportsCar();
        Sedan taxi = new Sedan();
        SUV sportsCar = new SUV();
        Scanner sc = new Scanner(System.in);
        System.out.print("운전하고 싶은 차를 선택 하세요[1]버스, [2]택시, [3]스포츠카 : ");
        int selMenu = sc.nextInt();
        switch(selMenu) {
            case 1 : driver.drive(bus); break;
            case 2 : driver.drive(taxi); break;
            case 3 : driver.drive(sportsCar); break;
        }
    }
}