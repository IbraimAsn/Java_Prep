package ValidPalindrome;

import java.util.Random;

public class Palindrome {

    String palindromeOrNot;

    Random random;

    public void fillStrblder(StringBuilder strBlder) {
        for(int i = 0; i < strBlder.capacity(); i++) {
            if(i < strBlder.capacity() / 2) {
                strBlder.append('x');
            } else {
                strBlder.append('z');
            }
        }
    }

    public void turnItIntoAPalindrome(StringBuilder strBlder) {
        for(int i = 0; i < strBlder.capacity(); i++) {
            int temp = random.nextInt(26) + 97;
            strBlder.setCharAt(i, (char)temp);
            strBlder.setCharAt(strBlder.capacity() - 1 - i, (char)temp);
        }
        if(strBlder.capacity() % 2 != 0) {
            strBlder.setCharAt(strBlder.capacity()/2,'X');
        }
    }

    public String generatePalindromeOrNot() {
        StringBuilder strBlder = new StringBuilder(10);
        fillStrblder(strBlder);
        if(random.nextInt(2) % 2 == 0) {
            turnItIntoAPalindrome(strBlder);
        }
        return strBlder.toString();
    }

    public Palindrome() {
        this.random = new Random();
        this.palindromeOrNot = generatePalindromeOrNot();
    }

    public static boolean isItAPalindromeOrNot(String str) {
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void displayResults(String str) {
        System.out.print(str + " : ");
        if(isItAPalindromeOrNot(str)) {
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    public static void main(String[] args) {
        Palindrome pal = new Palindrome();
        displayResults(pal.palindromeOrNot);
    }
}