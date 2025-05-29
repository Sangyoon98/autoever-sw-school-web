package 에어컨설계;

import java.util.Scanner;

/** 1. 기본 에어컨 만들기
 *  - 전원 ON/OFF
 *  - 현재 온도 표시 기능
 *  - 설정 온도 표시 기능
 *  - 바람세기 (1단/2단/3단)
 *  - 현재 상태 출력 기능
 *  -- 전원, 현재온도, 설정온도,바람세기
 * <p>
 *  2. 스마트 에어컨 만들기
 *  - 자동 설정 기능 : 20도 설정, 바람세기 2단계
 * <p>
 *  3. 휴대용 에어컨 만들기
 *  - 배터리 표시 기능 추가
* */

public class AirConMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("에어컨 종류 선택 (1: 기본 / 2: 스마트 / 3: 휴대용): ");
        int type = sc.nextInt();
        AirCon ac = null;

        switch (type) {
            case 1: // 기본
                ac = new AirCon();
                ac.powerOn();
                System.out.print("설정 온도 입력: ");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력: ");
                ac.setWindStep(sc.nextInt());
                break;

            case 2: // 스마트
                SmartAirCon smart = new SmartAirCon();
                smart.powerOn();
                System.out.print("스마트 에어컨 자동 모드 설정 (true/false): ");
                boolean auto = sc.nextBoolean();
                smart.autoSetting(auto);
                if (!auto) {
                    System.out.print("설정 온도 입력: ");
                    smart.setTemp(sc.nextInt());
                    System.out.print("바람 세기 입력 (1~3): ");
                    smart.setWindStep(sc.nextInt());
                }
                ac = smart;
                break;

            case 3: // 휴대용
                PortableAirCon portable = new PortableAirCon();
                portable.powerOn();
                System.out.print("설정 온도 입력: ");
                portable.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력 (1~3): ");
                portable.setWindStep(sc.nextInt());
                ac = portable;
                break;
        }

        while (ac != null && ac.isPowerOn()) {
            Thread.sleep(1000);
            ac.simulateTemperatureChange();
            ac.displayStatus();
            if (ac instanceof PortableAirCon portable) {
                portable.displayBattery();
            }
            if (ac.getCurrTemp() == ac.getSetTemp()) {
                System.out.println("✅설정 온도 도달. 에어컨 종료.");
                ac.powerOff();
            }
        }
    }
}
