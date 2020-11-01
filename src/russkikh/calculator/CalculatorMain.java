package russkikh.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String typedString = reader.readLine();

        ArabicCalculator arabicCalculator = new ArabicCalculator(typedString);
        String[] stringArray = arabicCalculator.returnArray(arabicCalculator.getTypedString());

        int a = arabicCalculator.stringToInteger(stringArray[0]);
        int b = arabicCalculator.stringToInteger(stringArray[2]);

        switch (stringArray[1]){
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

        arabicCalculator.toString(stringArray);

        reader.close();
    }
}
