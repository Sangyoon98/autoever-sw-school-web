package 컴페어레이터;

public class CarComp implements Comparable<CarComp> {
    public String modelName;    // 자동차 이름
    public int modelYear;       // 연식
    public String color;        // 색상

    public CarComp(String modelName, int modelYear, String color) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
    }

    @Override
    public int compareTo(CarComp obj) {
        if (this.modelYear == obj.modelYear) {
            if (this.modelName.compareTo(obj.modelName) == 0) return this.color.compareTo(obj.color);
            else return this.modelName.compareTo(obj.modelName); // 사전순 정렬
        }
        else if (this.modelYear < obj.modelYear) return -1;   // 정렬하지 않는 조건
        else return 1;  // 정렬 하는 조건, 오름차순 정렬
    }
}
