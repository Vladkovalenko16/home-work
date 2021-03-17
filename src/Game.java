import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static int MININT = 5;
    public static int MAXINT = 6;
    public static int POINT = 2;

    public static void main (String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Будем угадывать числа сначала я угадываю потом ты.");
        System.out.println("Играем до " + POINT + " очков.");
        System.out.println(("Загадывать числа от " + MININT + " до " + MAXINT));
        int pointPerson = 0;
        int pointComputer = 0;
        boolean move = true;
        do {
            int numberPerson;
            int numberComputer;
            if (move){
                numberPerson = readInt(in, "Введи свое число");
                numberComputer = findRandomNumber("Вот мое число: ");
                if (numberComputer == numberPerson) {
                    pointComputer++;
                    System.out.println(" Я угадал.");
                }
                if (pointComputer == POINT) move = false;
                System.out.println("Счет " + pointComputer + ":" + pointPerson);
            }
            if (move){
                System.out.println("Я загодал число.");
                numberPerson = readInt(in, "Введи свое число");
                numberComputer = findRandomNumber("Вот мое число: ");
                if (numberComputer == numberPerson) {
                    pointPerson++;
                    System.out.println(" Ты угадал.");
                }
                if (pointPerson == POINT) move = false;
            }
            System.out.println("Счет " + pointComputer + ":" + pointPerson);
        } while (move);
        if (pointComputer == POINT) System.out.println("Я победил)) LOL.");
        if (pointPerson == POINT) System.out.println(("Поздравляю."));

    }
    public static int findRandomNumber (String string){
        int randomNumber = (int) Math.round((Math.random() * (MAXINT - MININT) + MININT));
        System.out.println(string + randomNumber);
        return randomNumber;
    }

    public static int readInt (BufferedReader in, String message) throws IOException {
        int number = 0;
        System.out.println(message);
        boolean hasNumber = true;
        do {
            try {
                String string = in.readLine();
                number = Integer.parseInt(string);
                if (MININT <= number && number <= MAXINT){
                    hasNumber = false;
                } else System.out.println("Введи число от " + MININT + " до " + MAXINT);
            } catch (NumberFormatException e){
                System.out.println("Нужно целое число");
            }
        }while (hasNumber);
        return number;
    }
}
