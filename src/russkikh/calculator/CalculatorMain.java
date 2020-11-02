package russkikh.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Запущена программа калькулятор.");

        while (true) {
            System.out.println("Введите выражение для вычисления:");
            String typedString = reader.readLine();

            String[] stringArray = AbstractCalculator.returnArray(typedString);
            System.out.println("Результат операции:");

            try {
                RomeCalculator romeCalculator = new RomeCalculator(typedString);
                int result = romeCalculator.computation(stringArray);
                System.out.println(RomeCalculator.converterToArabicNumbers(result));
            } catch (IllegalArgumentException e) {
                ArabicCalculator arabicCalculator = new ArabicCalculator(typedString);
                int result = arabicCalculator.computation(stringArray);
                System.out.println(result);
            }

            System.out.println();
        }
    }
}
