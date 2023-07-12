import java.util.Arrays;

public class TwoSum {

    TwoSumGenerator base;

    public TwoSum() {
        base = new TwoSumGenerator();
    }

    public static void main(String[] args) {
        TwoSum letsgo = new TwoSum();
        Arrays.sort(letsgo.base.arr);
        System.out.println(letsgo.base.toString());
        int[] arrIndexes = get2Indexes(letsgo.base.arr, letsgo.base.valueToFind);
        System.out.printf("(arr[%d] = %d) + (arr[%d] = %d) = %d\n",
        arrIndexes[0],letsgo.base.arr[arrIndexes[0]],arrIndexes[1],letsgo.base.arr[arrIndexes[1]],letsgo.base.valueToFind);
    }

    public static int[] get2Indexes(int[] arr, int valueToFind) {
        int[] arrIndexes = new int[2];
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if((arr[i] + arr[j]) == valueToFind) {
                    arrIndexes[0] = i;
                    arrIndexes[1] = j;
                    return arrIndexes;
                }
            }
        }
        return arrIndexes;
    }
}
