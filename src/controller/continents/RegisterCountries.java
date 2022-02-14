package controller.continents;
import helper.DefaultData;
import helper.Print;
import model.Country;
import java.util.ArrayList;

public class RegisterCountries {
    private ArrayList<Country> countriesList;
    private Country country;
    private DataEntryProcess dataEntryProcess;
    private boolean flag1;
    private boolean flag2;
    private boolean lengthNameCountryValid;

    public RegisterCountries() {
        flag1 = true;
        flag2 = true;
        lengthNameCountryValid = true;
        countriesList = new ArrayList<>();
        dataEntryProcess = new DataEntryProcess();
    }

    public ArrayList<Country> getCountriesList() {
        while (flag1) {
            viewMenu();
        }
        if(countriesList.size()>0)Print.printSaveRegister();
        else Print.printSaveRInvalid();
        flag1 = true;
        flag2 = true;
        return countriesList;
    }

    private void viewMenu() {
        if (flag2) Print.getTilte();
        else flag2 = true;
        validate(dataEntryProcess.getPrincipalOption());
    }

    public void validate(int inputOption) {
        switch (inputOption) {
            case 0:
                System.exit(0);
            case -1:
                flag1 = false;
                break;
            default:
                registroPaises();
        }
    }

    private void registroPaises() {
        country = new Country();
        dataEntryProcess.insertContinentName(country);
        registerInformationCountry();
    }

    private void registerInformationCountry() {
        while (flag2) {
            dataEntryProcess.viewMessageNewCountry(lengthNameCountryValid);
            if (registerNameCountry()) {
                if (lengthNameCountryValid) registroPais();
            } else flag2 = false;
        }
    }

    private boolean registerNameCountry() {
        boolean isRegistrado = true;
        String input = dataEntryProcess.getStringInput();
        if (isNotPosibleRegistro(input)) isRegistrado = false;
        else {
            lengthNameCountryValid = dataEntryProcess.verifiSizeNContry(input);
            if (lengthNameCountryValid) country.setCountryName(input);
        }
        return isRegistrado;
    }

    private boolean isNotPosibleRegistro(String input) {
        boolean notPosible = false;
        if (input.equals("-2")) notPosible = true;
        else {
            if (input.equals("-1")) {
                flag1 = false;
                notPosible = true;
            }
        }
        return notPosible;
    }

    private void registroPais() {
        for (int i = 1; i < DefaultData.getQuestionsList().size(); i++) {
            if(!registrateDate(i)){
                if (!validarRegistroCompleto()) break;
                else i--;
            }
        }
    }

    private boolean registrateDate(int num){
        boolean success=false;
        if(num>=2) success=registerDateDouble(num);
        else success= registerDateInteger(num);
        return success;
    }

    private boolean registerDateDouble(int num){
        boolean success=false;
        double inputNumberDouble = 0;
        inputNumberDouble = dataEntryProcess.getInputOptionDouble(num);
        if(isValidDateNumber(inputNumberDouble)) {
            success=true;
            dataEntryProcess.insertInformationCountry(num, inputNumberDouble, country, countriesList);
        }
        return success;
    }

    private boolean registerDateInteger(int num){
        boolean success=false;
        int inputNumber = dataEntryProcess.getInputOptionInteger(num);
        if(isValidDateNumber((double) inputNumber)) {
            success=true;
            dataEntryProcess.insertInformationCountry(num, inputNumber, country, countriesList);
        }
        return success;
    }
    private boolean validarRegistroCompleto() {
        if (!flag1) Print.printSaveRegisterInvalid();
        else Print.printChangeOfContinent();
        return isRegisterFinish(true);
    }

    private boolean isRegisterFinish(boolean finish) {
        int inputOption = 0;
        while (finish) {
            inputOption = dataEntryProcess.getInputOptionExit(-2, 2);
            if (!flag1) finish = cicloProgramprimenosUNo(-1, inputOption);
            else finish = cicloProgramprimenosUNo(-2, inputOption);
        }
        return flag1 && flag2;
    }

    private boolean cicloProgramprimenosUNo(int optionFinish, int optionValid) {// opciones presiono -1 en inicio nombre y se espera confirmacion
        boolean valid = true;
        switch (optionValid) {
            case -2://flag 1 = false
                if (optionFinish != -2) Print.printChangeOfContinent();
                else Print.msjConfirm();
                flag1 = true;
                flag2 = false;
                break;
            case -1://flag 2 =false
                if (optionFinish != -1) Print.printSaveRegisterInvalid();
                else Print.msjConfirm();
                flag1 = false;
                flag2 = true;
                break;
            case 1:
                valid = false;
                break;
            default:
                if (flag2) flag1 = true;
                else flag2 = true;
                valid = false;
        }
        return valid;
    }


    private boolean isValidDateNumber(double option) {
        boolean valid = false;
        if (option == -1) flag1 = false;
        else {
            if (option == -2) flag2 = false;
            else valid = true;
        }
        return valid;
    }
}

