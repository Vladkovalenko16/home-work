import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static final int MIN_NUMBER = 5;
    public static final int MAX_NUMBER = 6;
    public static final int MAX_POINT = 2;

    public static void main(String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Будем угадывать числа сначала я угадываю потом ты.");
        System.out.println("Играем до " + MAX_POINT + " очков.");
        System.out.println(("Загадывать числа от " + MIN_NUMBER + " до " + MAX_NUMBER));
        int personsPoint = 0;
        int computersPoint = 0;
        //do {
        for (int turn = 1; personsPoint != MAX_POINT && computersPoint != MAX_POINT; turn++) {
            int numberPerson;
            int numberComputer;
            if (turn % 2 != 0) {
                numberPerson = readInt(in, "Введи свое число");
                numberComputer = generateRandomNumber();
                System.out.println("Вот мое число " +numberComputer);
                if (numberComputer == numberPerson) {
                    computersPoint++;
                    System.out.println(" Я угадал.");
                }
            }
            if (turn % 2 == 0) {
                System.out.println("Я загодал число.");
                numberPerson = readInt(in, "Введи свое число");
                numberComputer = generateRandomNumber();
                System.out.println("Вот мое число " + numberComputer);
                if (numberComputer == numberPerson) {
                    personsPoint++;
                    System.out.println(" Ты угадал.");
                }
            }
            System.out.println("Счет " + computersPoint + ":" + personsPoint);
        } //while (personsPoint != MAX_POINT && computersPoint != MAX_POINT);
        if (computersPoint == MAX_POINT) {
            System.out.println("Я победил)) LOL.");
        }else {
            System.out.println(("Поздравляю."));
        }
    }

    public static int generateRandomNumber(){
        return (int) Math.round((Math.random() * (MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER));
    }

    public static int readInt(BufferedReader in, String message) throws IOException {
        int number = 0;
        System.out.println(message);
        boolean hasNumber = false;
        do {
            try {
                String string = in.readLine();
                number = Integer.parseInt(string);
                if (MIN_NUMBER <= number && number <= MAX_NUMBER) {
                    hasNumber = true;
                } else {
                    System.out.println("Введи число от " + MIN_NUMBER + " до " + MAX_NUMBER);
                }
            } catch (NumberFormatException e){
                System.out.println("Нужно целое число");
            }
        }while (!hasNumber);
        return number;
    }
}
