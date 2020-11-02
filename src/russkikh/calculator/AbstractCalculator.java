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
    //если введенная строка поммещается в массив не из 3 элементов
    //программа прерывается
    public static String[] returnArray(String s) {
        //замена множественных пробелов на один + отбрасывание из строки пробелов в начале и в конце
        String typedStringAfterTrim = s.replaceAll("( +)", " ").trim();
        String[] stringArray = typedStringAfterTrim.split(" ");
        try {
            if (stringArray.length != 3){
                throw new IllegalArgumentException("Строка не может быть обработана. Введено слишком много данных.");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
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

    // метод, выполняющий арифметическое действие
    public int computation (String[] stringArray){
        int a = stringToInteger(stringArray[0]);
        int b = stringToInteger(stringArray[2]);
        int result;

        switch (stringArray[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalStateException("В введенной строке нет арифметического действия");
        }
        return result;
    }

    //метод для визуального тестирования кода при разработке приложения калькулятор
    public void toString(String[] stringArray) {
        System.out.println("Полученная строка: ");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
    }
}
