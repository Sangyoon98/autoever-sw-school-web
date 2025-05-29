package 상속과다형성;

public class TelevisionMain {
    public static void main(String[] args) {
        ProductTv productTv1 = new ProductTv(false, 11, 20, false);
        productTv1.setName("곰돌이 TV");
        productTv1.setVolume(20);
        productTv1.setChannel(20, true);
        productTv1.viewTv();
    }
}
