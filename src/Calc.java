package Calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    private static boolean checkNum(String num) {
        Pattern p = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        Matcher m = p.matcher(num);
        if (!m.matches()) {
            System.out.println("Not Number is Entered - '" + num + "'! Please try again!");
            return false;
        } else return true;
    }

    private static boolean checkOperation(String o) {
        Pattern p = Pattern.compile("[-|\\+|\\*|\\/]");
        Matcher m = p.matcher(o);
        if (!m.matches()) {
            System.out.println("The Selected Operation is not valid - '" + o + "'! Please try again!");
            return false;
        } else return true;
    }

    public static void main(String[] args) {

        String firstNum = "", secondNum = "", operation = "", exit = "";
        boolean flag = true;
        Scanner input = new Scanner(System.in);

        do {

            while (flag) {
                System.out.println("Please enter your first number:");
                firstNum = input.nextLine();
                if (checkNum(firstNum)) {
                    flag = false;
                }
            }
            flag = true;

            while (flag) {
                System.out.println("Please enter your second number:");
                secondNum = input.nextLine();
                if (checkNum(secondNum)) {
                    flag = false;
                }
            }
            flag = true;

            while (flag) {
                System.out.println("Select your Action:");
                operation = input.next();
                if (checkOperation(operation)) {
                    flag = false;
                }
            }
            flag = true;

            if (operation.equals("+")) {
                System.out.println("Result is: " + (Double.parseDouble(firstNum) + Double.parseDouble(secondNum)));
            }
            if (operation.equals("-")) {
                System.out.println("Result is: " + (Double.parseDouble(firstNum) - Double.parseDouble(secondNum)));
            }
            if (operation.equals("*")) {
                System.out.println("Result is: " + ((Double.parseDouble(firstNum) * Double.parseDouble(secondNum))));
            }
            if (operation.equals("/")) {
                if (Double.parseDouble(secondNum) == 0) {
                    System.out.println("Your input is Invalid! Division by ZERO!");
                } else
                    System.out.println("Result is: " + (Double.parseDouble(firstNum) / Double.parseDouble(secondNum)));
            }

            System.out.println("Do You wish to perfom any other operation? Make Your choise: y / n ");
            exit = input.next();
            input.nextLine();

        } while (exit.equals("y"));
    }
}
