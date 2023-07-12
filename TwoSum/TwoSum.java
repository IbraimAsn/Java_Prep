import java.util.Arrays;

public class TwoSum {

    TwoSumGenerator base;

    public TwoSum() {
        base = new TwoSumGenerator();
        base.fillArray();
    }

    public static void main(String[] args) {
        TwoSum letsgo = new TwoSum();
        Arrays.sort(letsgo.base.arr);
        System.out.println(letsgo.base.toString());
    }
}
