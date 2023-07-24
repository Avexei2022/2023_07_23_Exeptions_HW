import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        float try_count = 7;
        float [] array_input = get_float(try_count);
        if (array_input[0] > 0) {
            System.out.println("Вы ввели дробное число: " + array_input[1]);
        } else {
            System.out.println("Было " + (int)try_count + " попыток ввести дробное число.");
        }

    }
    private static float[] get_float(float try_count){
        float float_input = 1;
        boolean flag = true;
        System.out.print("Введите дробное число (7 попыток): ");
        Scanner scanner = new Scanner(System.in);
        while (flag && try_count > 0) {
            try {
                float_input = Float.parseFloat(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                try_count--;
                System.out.println("Условия ввода не выполнены.\n" +
                        "Осталось попыток - " + (int)try_count);
                if (try_count > 0){
                    System.out.print("Повторите ввод: ");
                }
            }
        }
        float [] array_input = new float[]{try_count, float_input};
        return array_input;
    }

}