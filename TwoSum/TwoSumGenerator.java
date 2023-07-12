import java.util.Random;

public class TwoSumGenerator {

    int[] arr;

    int valueToFind;

    Random random;
    
    public void fillArray() {
        int value;
        arr[0] = random.nextInt(9) + 1;
        for(int i = 1; i < arr.length; i++) {
            value = random.nextInt(9) + 1;
            while(checkIfAlreadyPresent(i, value)) {
                value = random.nextInt(9) + 1;
            }
            arr[i] = value;
        }
    }

    public boolean checkIfAlreadyPresent(int currentIndex, int value) {
        for(int i = 0; i < currentIndex; i++) {
            if(arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int obtainValueToFind() {
        int valueFirstRandomIndex = random.nextInt(arr.length);
        int valueSecondRandomIndex = random.nextInt(arr.length);
        while(valueSecondRandomIndex == valueFirstRandomIndex) {
            valueSecondRandomIndex = random.nextInt(arr.length);
        }
        return (arr[valueFirstRandomIndex] + arr[valueSecondRandomIndex]);
    }

    public String representationOfArray() {
        StringBuilder representation = new StringBuilder("length : " + arr.length + "\n" + "[");
        for(int i = 0; i < arr.length; i++) {
            if(i != arr.length - 1) {
                representation.append(arr[i] + ", ");
            }
            else {
                representation.append(arr[i] + "]\n");
            }
        }
        return representation.toString();
    }

    @Override
    public String toString() {
        return representationOfArray() + "\n" + "value to find : " + valueToFind;
    }

    public TwoSumGenerator() {
        this.random = new Random();
        this.arr = new int[this.random.nextInt(5)+5];
        fillArray();
        this.valueToFind = obtainValueToFind();
    }
}