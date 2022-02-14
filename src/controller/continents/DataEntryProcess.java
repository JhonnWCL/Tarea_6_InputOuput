package controller.continents;

import helper.DefaultData;
import helper.Print;
import helper.NumberValidator;
import model.Country;

import java.util.ArrayList;
import java.util.Scanner;

public class DataEntryProcess {
    private int option;
    private final NumberValidator numberValidator;
    private  final Scanner sc;

    public DataEntryProcess() {
        numberValidator = new NumberValidator();
        sc = new Scanner(System.in);
    }

    public int getPrincipalOption() {
        Print.printContinentNames();
        option = numberValidator.getIntegerDataInput(-1, 6);
        return option;
    }

    public void insertContinentName(Country country) {
        String name = DefaultData.getContinentsList().get(option - 1);
        Print.printCountriesRegister(name);
        country.setContinentName(name);
    }

    public void viewMessageNewCountry(boolean isNameInvalid) {
        if (isNameInvalid) Print.printInputMsjNewCountry();
        System.out.print(DefaultData.getQuestionsList().get(0));
    }

    public String getStringInput() {
        String input = sc.nextLine().trim();
        if (input.equals("0")) System.exit(0);
        return input;
    }

    public boolean verifiSizeNContry(String input) {
        boolean isValid = false;
        if (input.length() <= 3) Print.invalidNameCountry();
        else isValid = true;
        return isValid;
    }

    public int getInputOptionInteger(int indexAnswer) {
        System.out.print(DefaultData.getQuestionsList().get(indexAnswer));
      return procesoValueInteger();
    }

    public double getInputOptionDouble(int indexAnswer) {
        System.out.print(DefaultData.getQuestionsList().get(indexAnswer));
       return procesoValueDouble();
    }

    private double procesoValueDouble() {
        double optionDouble = numberValidator.getDoubleDataInput(-2, 2147483646);
        if (optionDouble == 0) System.exit(0);
        return optionDouble;
    }
    private int procesoValueInteger() {
        int optionInteger = numberValidator.getIntegerDataInput(-2, 2147483646);
        if (optionInteger == 0) System.exit(0);
        return optionInteger;
    }

    public int getInputOptionExit(int min, int max) {
        int option = numberValidator.getIntegerDataInput(min, max);
        if (option == 0) System.exit(0);
        return option;
    }
    public void insertInformationCountry(int indexInformationCountry, int inputValue, Country country, ArrayList<Country> listCountries) {
        insertInformationCountry(indexInformationCountry, (double)inputValue, country, listCountries);
    }
    public void insertInformationCountry(int indexInformationCountry, double inputValue, Country country, ArrayList<Country> listCountries) {
        switch (indexInformationCountry) {
            case 1:
                country.setCountryPopulation((int)inputValue);
                break;
            case 2:
                country.setBirthRate(inputValue);
                break;
            default:
                country.setMortalityRate(inputValue);
                addDatesInContinent(listCountries, country);
        }
    }

    private void addDatesInContinent(ArrayList<Country> listContinent, Country country) {
        listContinent.add(new Country(country.getCountinentName(),country.getCountryName(), country.getCountryPopulation(), country.getBirthRate(), country.getMortalityRate()));
    }
}
