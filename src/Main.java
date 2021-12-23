import java.util.Scanner;

public class Main {

    //TODO: добавить защиту от неккоректного ввода

    private static final String INFO = "INFO" + System.lineSeparator() + "u - вверх\n" +
            "ru - направо-вверх\n" +
            "r - направо\n" +
            "rd - направо-вниз\n" +
            "d - вниз\n" +
            "ld - налево-вниз\n" +
            "l - налево\n" +
            "lu - налево-вверх\n";

    public static void main(String[] args) {

        Field field = new Field(25);
        controller(field);
    }

    private static void controller(Field field) {
        System.out.println(INFO);
        while (true) {
            System.out.println("Введите направление и число шагов через пробел:");
            String input = new Scanner(System.in).nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Пока!");
                break;
            }
            String[] command = input.split(" ");
            try {
                field.move(command[0], Integer.parseInt(command[1]));
            } catch (Exception e) {
                System.out.println("Неверный ввод. Повторите ввод");
                continue;
            }

            System.out.println(field);
            System.out.print("\033[H\033[J");
            System.out.println("Введите exit для выхода.");
        }
    }
}