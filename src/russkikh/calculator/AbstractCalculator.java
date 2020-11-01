package russkikh.calculator;

public abstract class AbstractCalculator {
    protected String typedString;

    AbstractCalculator(String s) {
        typedString = s;
    }

    public String getTypedString() {
        return typedString;
    }

    //метод для превращения введенной строки в массив строк
    public String[] returnArray(String s) {
        //замена множественных пробелов на один + отбрасывание из строки пробелов в начале и в конце
        String typedStringAfterTrim = s.replaceAll("( +)", " ").trim();
        String[] stringArray = typedStringAfterTrim.split(" ");
        return stringArray;
    }

//    метод для превращения строки в целое число
//    если строка не может быть преобразована к целому числу
//    или выходит за рамки отрезка целых чисел от 1 до 10,
//    программа выбрасывает исключение и завершается
    public int stringToInteger(String s) {
        int number = 0;
        try {
            number = Integer.parseInt(s);
            if (number > 10 || number < 1) {
                throw new ArrayIndexOutOfBoundsException("Программа работает только с числами " +
                        "от 1 до 10 включительно. \n" +
                        "Введенное число " + s + " вышло за рамки входных данных этого калькулятора");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Введенное значение " + s + " невозможно преобразовать в целое число");
            System.exit(0);
        }
        return number;
    }

   /* метод проверки арифметического действия,
    * если второй элемент массива не является арифметическим знаком
    * выбрасывается исключение */
    public void isSign (String[] stringArray){
        String s = stringArray[1];
        try {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                throw new Exception("В введенной строке нет арифметического действия");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    // метод, выполняющий арифметическое действие
    public void computation (String[] stringArray){
        int a = stringToInteger(stringArray[0]);
        int b = stringToInteger(stringArray[2]);

        isSign(stringArray);

        switch (stringArray[1]) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
        }
    }

    //метод для визуального тестирования кода при разработке приложения калькулятор
    public void toString(String[] stringArray) {
        System.out.println("Полученная строка: ");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
    }
}
