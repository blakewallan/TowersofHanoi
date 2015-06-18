import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by blakeallan on 3/19/15.
 * This program solves the towers of Hanoi for a specified range of disks using recursion &
 * using command line arguments to specify parameters
 */

public class Hanoi {

    static int count = 0;
    static int count2 = 0;

    public static void main(String[] args) {
        //declaring ints for use as parameters
        int num1;
        int num2;

        //Creating empty array to be populated by command line arguments
        String[] commandArgs = new String[3];
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                commandArgs[i] = args[i];
            }
        }
        String choice;
        num1 = 3;
        num2 = 3;

        //if statement for no command line args
        if (commandArgs[0] == null || commandArgs[1] == null) { //|| commandArgs[2] == null){
            for (int i = 0; i < commandArgs.length ; i++) {
                if (commandArgs[i] != null) {
                    num1 = Integer.parseInt(commandArgs[i]);
                    num2 = Integer.parseInt(commandArgs[i]);
                }
            }

            choice = "";
        }
        else {
            num1 = Integer.parseInt(commandArgs[0]);
            num2 = Integer.parseInt(commandArgs[1]);
        }

        //if, else statement for printing steps or not
        if (commandArgs[2] == null) {
            choice = "";
        }
        else choice = "V";

        //output
        printTowers(num1, num2, choice);

    }

    //This prints the solutions to towers of hanoi
    //the third parameter decides which method to use
    public static void printTowers(int num1, int num2, String choice){
        if (choice.equalsIgnoreCase("V")) {
            System.out.println("Solving using a disk range of " + num1 + " through " + num2);
            System.out.println();
            for (int i = num1; i <= num2; i++) {
                solveTowerV(i, "Needle 1", "Needle 2", "Needle 3");
                System.out.println("With " + i + " disks this operations took " + count + " moves");
                System.out.println();
            }
        }
        if (choice.equals("")) {
            System.out.println("Solving using a disk range of " + num1 + " through " + num2);
            System.out.println();

            for (int i = num1; i <= num2; i++) {
                solveTower(i);
                System.out.println("With " + i + " disks this operations took " + count2 + " moves \n");
            }
        }
    }


    //Method solves the towers problem and prints every move
    public static void solveTowerV(int num, String one, String two, String three) {
        //BASE
        if (num == 1) {
            System.out.println("I moved a disk from " + one + " to " + two + ".");
            count ++;
        }
        else {
            solveTowerV(num - 1, one, three, two);

            solveTowerV(1, one, two, three);

            solveTowerV(num - 1, three, two, one);
        }
    }

    //this method solves the tower and keeps a count
    public static void solveTower(int num) {
        //BASE
        if (num == 1) {
            count2 ++;
        }
        else {
            solveTower(num - 1);

            solveTower(1);

            solveTower(num - 1);
        }
    }
}

