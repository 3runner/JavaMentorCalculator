package russkikh.calculator;

public class RomeCalculator extends AbstractCalculator {

    public RomeCalculator(String s) {
        super(s);
    }

    @Override
    public int stringToInteger(String s) throws IllegalArgumentException{
        return RomeNumbers.valueOf(s).ordinal() + 1;
    }

    //конвертер для перевода арабских чисел от 1 до 100 включительно в римские
    public static String converterToArabicNumbers (int in) {
        String[] array1to9 = {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder result = new StringBuilder("");
        if (in <= 0 || in > 100){
            throw new IllegalArgumentException("Результат невозможно преобразовать к форме римского числа");
        }

        else if (in == 100){
            result.append("C");
        }

        else if (in >= 90 && in < 100){
            result.append("XC");
            int remainder = in % 90;
            result.append(array1to9[remainder]);
        }

        else if (in >= 50 && in < 90){
            result.append("L");
            int remainder = in % 50;
            for (int i = 0; i < remainder / 10; i++){
                result.append("X");
            }
            int remainder1 = remainder % 10;
            result.append(array1to9[remainder1]);
        }

        else if (in >= 40 && in < 50){
            result.append("XL");
            int remainder = in % 40;
            result.append(array1to9[remainder]);
        }

        else if (in > 0 && in < 40){
            for (int i = 0; i < in / 10; i++){
                result.append("X");
            }
            int remainder = in % 10;
            result.append(array1to9[remainder]);
        }

        return result.toString();
    }
}
