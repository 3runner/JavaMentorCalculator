package russkikh.calculator;

public class ArabicCalculator {
    private String typedString;


    ArabicCalculator(String s) {
        typedString = s;
    }

    public String getTypedString() {
        return typedString;
    }

    public String [] returnArray (String s){
        String typedStringAfterTrim = s.replaceAll("( +)", " ").trim(); //замена множественных пробелов на один + отбрасывание из строки пробелов в начале и в конце
        String[] stringArray = typedStringAfterTrim.split(" ");

        return stringArray;
    }

    public int stringToInteger (String s){
        int number = 0;
        try{
            number = Integer.parseInt(s);
        } catch (NumberFormatException e){
            System.out.println("Невозможно преобразовать к типу int");
        }
        return number;
    }

    //метод для визуального тестирования кода при разработке приложения калькулятор
    public void toString (String[] stringArray){
        System.out.println("Полученная строка: ");
        for (String str: stringArray) {
            System.out.print(str + " ");
        }
    }
}
