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

        arabicCalculator.toString(stringArray);
        System.out.println("\n");

        arabicCalculator.computation(stringArray);



        reader.close();
    }
}
