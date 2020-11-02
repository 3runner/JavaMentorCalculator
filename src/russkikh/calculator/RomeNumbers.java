package russkikh.calculator;

public enum RomeNumbers {
    I("I"),
    II("II"),
    III("III"),
    IV("IV"),
    V("V"),
    VI("VI"),
    VII("VII"),
    VIII("VIII"),
    IX("IX"),
    X("X");

    String variableValue;

    RomeNumbers (String variableValue){
        this.variableValue = variableValue;
    }

    public String getVariableValue() {
        return variableValue;
    }
}
