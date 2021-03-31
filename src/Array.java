import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Array {

    public static final int LENGTHARRAY = 5;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double[] array = readArray(in);
        System.out.println("Массив наоборот " + Arrays.toString(turnOverArray(array)));
        System.out.println("Элементы массива в квадрате " + Arrays.toString((calculateSquareNumbers(array))));
        System.out.println("Произведение соседних чисел " + Arrays.toString((calculateProductOfNumbers(array))));
        System.out.println("Произведение этого и последующих " + Arrays.toString((calculateProductOfNumbersOnRight(array))));
        System.out.println("Среднее арифметическое элементов " + calculateAverage(array));
    }

    public static double calculateAverage(double[] array) {
        double summa = 0;
        double average = 0;
        for (int i = 0; i < array.length; i++) {
            summa += array[i];
        }
        average = summa / array.length;
        return average;
    }

    public static double[] calculateSquareNumbers(double[] array) {
        double[] invertedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            invertedArray[i] = array[i] * array[i];
        }
        return invertedArray;
    }

    public static double[] turnOverArray(double[] array) {
        double[] invertedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            invertedArray[i] = array[array.length - 1 - i];
        }
        return invertedArray;
    }

    public static double[] calculateProductOfNumbersOnRight(double[] array) {
        double[] invertedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            invertedArray[i] = array[i];
            for (int j = i + 1; j < array.length; j++) {
                invertedArray[i] *= array[j];
            }
            if (i == array.length - 1) {
                invertedArray[i] = array[i];
            }
        }
        return invertedArray;
    }

    public static double[] calculateProductOfNumbers(double[] array) {
        double[] productOfNumber = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                productOfNumber[i] = array[i] * array[i + 1];
            } else if (i == array.length - 1) {
                productOfNumber[i] = array[i] * array[i - 1];
            } else {
                productOfNumber[i] = array[i - 1] * array[i] * array[i + 1];
            }
        }
        return productOfNumber;
    }

    public static double[] readArray(BufferedReader in) throws IOException {
        double[] array = new double[LENGTHARRAY];
        System.out.println("Введите " + LENGTHARRAY + " чисел саммива");
        for (int i = 0; i < LENGTHARRAY; i++) {
            array[i] = Double.parseDouble(in.readLine());
        }
        return array;
    }

}
