package 자동차만들기실습.model;

public abstract class Car {
    static final int FUEL_PRICE = 2000;
    int speed;
    int efficiency;
    int fuelTank;
    int seats;
    public String name;

    // 모드 설정
    public abstract void setMode(boolean isOn);

    // 옵션 출력
    public abstract void printOption();

    // 이동 지역 별 거리 환산
    private int getDistance(int location) {
        return switch (location) {
            case 1 -> 400;
            case 2 -> 150;
            case 3 -> 200;
            case 4 -> 300;
            default -> 0;
        };
    }

    // 이동 횟수 계산
    public int getTripCount(int passengers) {
        return (int) Math.ceil((double) passengers / seats);
    }

    // 총 이동거리 계산
    public double getTotalDistance(int location, int tripCount) {
        return getDistance(location) * tripCount;
    }

    // 총 연료 소모량 계산
    public double getTotalFuelUsed(double totalDistance) {
        return totalDistance / efficiency;
    }

    // 총 주유 횟수 계산
    public int getRefuelCount(double fuelUsed) {
        return (int) Math.ceil(fuelUsed / fuelTank);
    }

    // 총 비용 계산
    public double getCost(double fuelUsed) {
        return fuelUsed * FUEL_PRICE;
    }

    // 이동 시간 계산
    public String getTravelTime(int location, int tripCount, int weatherFactor) {
        double weatherValue = switch (weatherFactor) {
            case 2 -> 1.2;
            case 3 -> 1.4;
            default -> 1.0;
        };
        double totalHours = (getDistance(location) / (double) speed) * tripCount * weatherValue;
        int hours = (int) totalHours;
        int minutes = (int) Math.round((totalHours - hours) * 60);
        return hours + "시간 " + minutes + "분";
    }
}
