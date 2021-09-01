package ua.alexkras;

import java.util.Scanner;

public class RegexScanner {
    public static String inputRegexWithScanner(String regex,String errorMessage){
        String output;
        Scanner scanner = new Scanner(System.in);
        while (!(scanner.hasNext() && (output = scanner.next()).matches(regex))){
            System.out.println(errorMessage);
        }
        return output;
    }
}
