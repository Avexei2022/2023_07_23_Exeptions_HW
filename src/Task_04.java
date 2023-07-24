import java.util.Scanner;

public class Task_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку, но не пустую: ");
        String string = scanner.nextLine();
        if (string.isEmpty()){
            throw new NullPointerException("Пустые строки вводить нельзя!");
        }
        System.out.println("Вы ввели строку:  \"" + string + "\", состоящую из " + string.length() + " символов.");
    }
}


