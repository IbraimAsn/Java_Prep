package AtoI;

import java.util.Random;

public class AtoI {

    final static int ASCII_VALUE_OF_ZERO = 48;

    Random random;
    
    String value;

    public String generateValue() {
        StringBuilder strBlder = new StringBuilder(9);
        int junkLimit = random.nextInt(3) + 1;
        for(int i = 0; i < strBlder.capacity(); i++) {
            if(i <= junkLimit) {
                if(random.nextInt(2) == 0) {
                    strBlder.append(' ');
                } else {
                    strBlder.append('$');
                }
            } else if(i == junkLimit + 1) {
                if(random.nextInt(2) == 0) {
                    strBlder.append('+');
                } else {
                    strBlder.append('-');
                }
            } else {
                strBlder.append((char)(random.nextInt(10) + ASCII_VALUE_OF_ZERO));
            }
        }
        return strBlder.toString();
    }

    public static int[] whenIntegerStarts(String value) {
        int[] infoValue = {-1,-1};
        int i = 0;
        while(i < value.length() && infoValue[1] == - 1){
            if(value.charAt(i) == '-' || value.charAt(i) == '+') {
                if(value.charAt(i) == '-') {
                    infoValue[0] = i;
                } else {
                    infoValue[0] = i;
                }
            } else if(infoValue[0] != - 1
                      && (57 >= (int)value.charAt(i))
                      && (49 <= (int)value.charAt(i))){

                        infoValue[1] = i;
                    }
                i++;
            }
            return infoValue;
        }

    public static int extractIntFromString(String value, int[] infoValue) {
        int extractedValue = 0;
        for(int i = infoValue[1]; i < value.length(); i++) {
            extractedValue = extractedValue * 10;
            extractedValue += (int)value.charAt(i) - ASCII_VALUE_OF_ZERO;
        }
        if(infoValue[0] == 0) {
            extractedValue = extractedValue * (-1);
        }
        return extractedValue;
    }

    public AtoI() {
        this.random = new Random();
        this.value = generateValue();
    }

    public static void main(String[] args) {
        AtoI atoi = new AtoI();
        System.out.println(atoi.value);
        int[] infoValue = whenIntegerStarts(atoi.value);
        int extractedValue = extractIntFromString(atoi.value,infoValue);
        System.out.println(extractedValue);
    }
}
