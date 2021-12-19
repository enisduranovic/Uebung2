package net.htlgkr.eduranovic19.hue2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberTester {

    File file;
    NumberTest oddTester, primeTester, palindromeTester;

    public NumberTester(File file) {
        this.file = new File("zahlen.txt");
    }

    public interface NumberTest {

        boolean testNumber(int number);
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        Scanner s;
        NumberTest isEven = (number) -> {
            if (number % 2 == 0) {
                return true;
            } else {
//                System.out.println("NOT EVEN");
                return false;
            }
        };
        setOddEvenTester(isEven);

        NumberTest isPrime = (number) -> {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
//                    System.out.println("NOT PRIME");
                    return false;
                }
            }
//            System.out.println("PRIME");
            return true;
        };
        setPrimeTester(isPrime);

        NumberTest isPalindrome = (number) -> {
            int palindrome = number;
            int reverse = 0;
            while (palindrome != 0) {
                int remainder = palindrome % 10;
                reverse = reverse * 10 + remainder;
                palindrome = palindrome / 10;
            }
            if (number == reverse) {
//                System.out.println("PALINDROME");
                return true;
            }
//            System.out.println("NOT PALINDROME");
            return false;
        };
        setPalindromeTester(isPalindrome);

        try {
            s = new Scanner(file);
            s.nextLine();
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] split = line.split(";");
                if (Integer.parseInt(split[0]) == 1) {
                    boolean oddEvenBoolean = oddTester.testNumber(Integer.parseInt(split[1]));
                    if (oddEvenBoolean == true) {
                        System.out.println("EVEN");
                    } else {
                        System.out.println("ODD");
                    }
                } else if (Integer.parseInt(split[0]) == 2) {
                    boolean primeBoolean = primeTester.testNumber(Integer.parseInt(split[1]));
                    if (primeBoolean == true) {
                        System.out.println("PRIME");
                    } else {
                        System.out.println("NOT PRIME");
                    }
                } else {
                    boolean palindromeBoolean = palindromeTester.testNumber(Integer.parseInt(split[1]));
                    if (palindromeBoolean == true) {
                        System.out.println("PALINDROME");
                    } else {
                        System.out.println("NOT PALINDROME");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
