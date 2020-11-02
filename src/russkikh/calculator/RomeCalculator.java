package russkikh.calculator;

public class RomeCalculator extends AbstractCalculator {

    public RomeCalculator(String s) {
        super(s);
    }

    @Override
    public int stringToInteger(String s) throws IllegalArgumentException{
        int number = RomeNumbers.valueOf(s).ordinal() + 1;
        return number;
    }

    public void converterToArabicNumbers (int result) {

    }
}
