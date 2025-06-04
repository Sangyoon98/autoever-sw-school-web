package 컴페어레이터;

import java.util.TreeSet;

public class CompMain {
    public static void main(String[] args) {
        TreeSet<CarComp> arrList = new TreeSet<>();
        arrList.add(new CarComp("코나", 2022, "흰색"));
        arrList.add(new CarComp("스포티지", 2022, "흰색"));
        arrList.add(new CarComp("싼타페", 2018, "회색"));
        arrList.add(new CarComp("그랜저", 2016, "검정색"));
        arrList.add(new CarComp("GV80", 2023, "검정색"));
        arrList.add(new CarComp("GV80", 2023, "흰색"));

        for (CarComp car : arrList) System.out.println(car.modelName + " : " + car.modelYear + " : " + car.color);
    }
}
