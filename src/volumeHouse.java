import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Отделить пробельчиками операторы.
//TODO: Методы должны называться с глагола (например readValue, calculateArea, printText, countItems и т.д.)
//TODO: Пробельчики во всех конструкциях
// if (a > b && b > c) {
// }
// for (int i; i < length, i++) {
// }
public class volumeHouse {

    public static final double PI = 3.14;
    public static final String SQUARE = "прямоугольный";
    public static final String ROUND = "круглый";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double length = readDouble(in, "Укажите длинну сарая");
        double width = readDouble(in, "Укажите ширину сарая");
        double height = readDouble(in, "Укажите высоту сарая");
        double thicknees = readDouble(in, "укажите толщину стен");
        double doorsNumber = readDouble(in, " укажите количество проемов");
        double volumeDoors = 0;
        for (int i = 1; i <= doorsNumber; i++) {
            System.out.println("проем " + i + " " + ROUND + " или " + SQUARE);
            String string = defineDoorShape(in);
            if (string.equalsIgnoreCase(SQUARE)) {
                double widthDoor = readDouble(in, "Укажите ширину проема");
                double heightDoor = readDouble(in, "Укажите высоту проема");
                volumeDoors += calculateSquareVolume(widthDoor, heightDoor, thicknees);
            } else if (string.equalsIgnoreCase(ROUND)) {
                double diametr = readDouble(in, "Укажите диаметр проема");
                volumeDoors += calculateRoundVolume(diametr, thicknees);
            }
        }
        double volumeHouse = calculateWallsVolume(length, width, height, thicknees) - volumeDoors;
        double price = readDouble(in, "Укажите цену за 1 куб материала");
        System.out.println("Обьем материалов равен " + volumeHouse);
        double fullPrice = volumeHouse * price;
        System.out.println("цена за весь материал = " + fullPrice);
    }

    //TODO: Хрень какая-то :)
    //TODO: Либо нужно делать проверку string.equals("прямоугольный")||string.equals("круглый") вне метода
    //TODO: Либо назвать метод соответствующе тому, что он делает
    public static String defineDoorShape(BufferedReader in) throws IOException {//выбор формы проема
        String string;
        boolean hasString = true;
        do {
            string = in.readLine();
            if (string.equalsIgnoreCase(SQUARE) || string.equalsIgnoreCase(ROUND)) {
                hasString = false;
            } else {
                System.out.println(ROUND + " или " + SQUARE + "???");
            }
        } while (hasString);
        return string;
    }

    public static double calculateSquareVolume(double width, double heigth, double thicknees) {//объем прямоугольного проема
        return width * heigth * thicknees;
    }

    public static double calculateRoundVolume(double diametr, double thicknees) {//объем круглого проема
        double radius = diametr / 2;
        return PI * radius * radius * thicknees;
    }

    public static double calculateWallsVolume(double length, double width, double height, double thicknees) {// ОБЪЕМ СТЕН
        double areaInside = length * width;
        double doubleThickness = 2 * thicknees;
        double areaOutside = (length + doubleThickness) * (width + doubleThickness);
        return (areaOutside - areaInside) * height;
    }

    public static double readDouble(BufferedReader in, String message) throws IOException {//чтобы были только цифры
        double namber = 0;
        System.out.println(message);
        boolean hasNumber = true;
        do {
            try {
                String string = in.readLine();
                namber = Double.parseDouble(string);
                hasNumber = false;
            } catch (NumberFormatException e) {
                System.out.println("нужно число");
            }
        }
        while (hasNumber);
        return namber;
    }
}
