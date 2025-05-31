package 디폴트메소드;

import java.util.Scanner;

public class DefaultMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("제품 선택 [1] TV, [2] Audio : ");
        int selectMenu = sc.nextInt();
        RemoteControl remoteControl;

        if (selectMenu == 1) {
            remoteControl = new Television();
            remoteControl.turnON();
            remoteControl.setVolume(20);
            remoteControl.setMute(true);
            RemoteControl.changeBattery();
        } else {
            remoteControl = new Audio();
            remoteControl.turnON();
            remoteControl.setVolume(30);
            remoteControl.setMute(true);
        }
    }
}
