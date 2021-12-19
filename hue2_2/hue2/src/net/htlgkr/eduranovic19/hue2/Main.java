package net.htlgkr.eduranovic19.hue2;

import java.io.File;

/**
 *
 * @author enisd
 */
public class Main {

    public static void main(String[] args) {
        File f = new File("zahlen.txt");
        NumberTester numbTester = new NumberTester(f);
        numbTester.testFile();
    }
}
