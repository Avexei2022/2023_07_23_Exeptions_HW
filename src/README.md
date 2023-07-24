# Урок 2. Исключения и их обработка  
1. Реализуйте метод, который запрашивает
у пользователя ввод дробного числа (типа float),
и возвращает введенное значение.  
Ввод текста вместо числа не должно приводить
к падению приложения, вместо этого,
необходимо повторно запросить у пользователя
ввод данных.  

2. Если необходимо, исправьте данный код  

   try {  
     int d = 0;  
     double catchedRes1 = intArray[8] / d;  
     System.out.println("catchedRes1 = " + catchedRes1);  
   } catch (ArithmeticException e) {  
     System.out.println("Catching exception: " + e);  
   }  

Исправления:  
- массив intArray отсутствует, поэтому его необходимо создать и заполнить;  
- дополнить код исключением NullPointerException;  
- не факт, что индекс не выйдет за пределы массива,
  поэтому необходимо добавить исключение IndexOutOfBoundsException;

  try {  
      int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
      int d = 0;  
      double catchedRes1 = intArray[8] / d;  
      System.out.println("catchedRes1 = " + catchedRes1);  
  } catch (ArithmeticException | NullPointerException | IndexOutOfBoundsException e) {  
      System.out.println("Catching exception: " + e);  
  } 


  3. Дан следующий код, исправьте его там, где требуется  
  
     public static void main(String[] args) throws Exception {  
        try {  
            int a = 90;  
            int b = 3;  
            System.out.println(a / b);  
            printSum(23, 234);  
            int[] abc = { 1, 2 };  
            abc[3] = 9;  
        } catch (Throwable ex) {  
            System.out.println("Что-то пошло не так...");  
        } catch (NullPointerException ex) {  
            System.out.println("Указатель не может указывать на null!");  
        } catch (IndexOutOfBoundsException ex) {  
            System.out.println("Массив выходит за пределы своего размера!");  
        }  
     }  
     public static void printSum(Integer a, Integer b) throws FileNotFoundException {  
        System.out.println(a + b);  
     }  


Исправления:  
- в методе main:  
  - убрать throws Exception - выше некуда пробрасывть исключение;  
  - дополнить исключением ArithmeticException - в метоле есть деление;
  - исключение Throwable поставить в самую последнюю очередь;
    - в методе printSum FileNotFoundException заменить на NullPointerException - метод
      не работает с файлами, но аргумент null вполне может получить ;  
  
      public static void main(String[] args){  
          try {  
              int a = 90;  
              int b = 3;  
              System.out.println(a / b);  
              printSum(23, 234);  
              int[] abc = { 1, 2 };  
              abc[3] = 9;  
          } catch (ArithmeticException ex) {  
              System.out.println("Деление на ноль!");  
          } catch (NullPointerException ex) {  
              System.out.println("Указатель не может указывать на null!");  
          } catch (IndexOutOfBoundsException ex) {  
              System.out.println("Индекс выходит за пределы массива!");  
          } catch (Throwable ex) {  
              System.out.println("Что-то пошло не так...");  
          }  
    
      public static void printSum(Integer a, Integer b) throws NullPointerException {  
          System.out.println(a + b);  
      }

4. Разработайте программу, которая выбросит 
Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение,
что пустые строки вводить нельзя.