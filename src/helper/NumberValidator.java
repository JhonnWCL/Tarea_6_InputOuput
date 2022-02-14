package helper;

import java.util.Scanner;

public class NumberValidator {
    private int integerData;
    private double doubleData;
    private boolean isDouble;

    public NumberValidator() {
        isDouble = false;
    }

    public int getIntegerDataInput(int min, int max) {
        this.isDouble = false;
        validDataVerification(min, max);
        return integerData;
    }

    public double getDoubleDataInput(int min, int max) {
        this.isDouble = true;
        validDataVerification(min, max);
        return doubleData;
    }

    private void validDataVerification(int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String stringDate="";
        while (flag) {
            stringDate = sc.nextLine();
            flag = !isNumberInRange(stringDate, min, max);
        }
    }

    private boolean isNumberInRange(String input, int min, int max) {
        boolean flag = false;
        if (isIntNumber(input)) {
            if (isInRange(min, max)) flag = true;
            else Print.printDataOutOfRange(isDouble);
        } else
            Print.printNotNumber(isDouble);
        return flag;
    }

    public boolean isInRange(int min, int max) {
        boolean flag = false;
        if (isDouble) {
            if (doubleData >= min && doubleData <= max) flag = true;
        } else {
            if (integerData >= min && integerData <= max) flag = true;
        }
        return flag;
    }

    public boolean isIntNumber(String date) {
        boolean valid = true;
        try {
            if (isDouble) doubleData = Double.parseDouble(date.trim().replace(" ", ""));
            else integerData = Integer.parseInt(date.trim().replace(" ", ""));
        } catch (Exception e) {
            valid = false;
        }
        return valid;
    }
    public  void captarExepciones(){
        int optionInteger = getIntegerDataInput(1,2);
        if(optionInteger==1||optionInteger==0){
            System.exit(0);
        }
    }
}