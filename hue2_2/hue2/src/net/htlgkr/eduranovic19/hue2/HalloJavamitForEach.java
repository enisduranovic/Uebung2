package net.htlgkr.eduranovic19.hue2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HalloJavamitForEach {

    static List<String> arrList = new ArrayList<>(Arrays.asList());

    public static void main(String[] args) {
        arrList.add("Paul");
        arrList.add("Enis");
        for (String s : arrList) {
            System.out.println(s);
        }
        arrList.forEach((String s) -> System.out.println("Enis"));
        arrList.forEach(System.out::print);
    }
}
