package controller;

import controller.continents.RegisterCountries;
import controller.files.FileHandler;
import controller.files.ReadFiles;
import helper.Print;
import helper.NumberValidator;
import model.Country;

import java.util.ArrayList;

public class Controller {
    private RegisterCountries countriesRegister;
    private NumberValidator numberValidator;
    private ArrayList<Country> countriesList;

    public Controller() {
        numberValidator = new NumberValidator();
        countriesRegister = new RegisterCountries();
        countriesList = new ArrayList<>();
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            Print.printDescription();
            procesar();
        }
    }

    private void procesar() {
       int option = numberValidator.getIntegerDataInput(0, 3);
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                viewTextContain();
                break;
            case 2:
                newRegiter();
                break;
            case 3:
                viewRegiterInformation();
                break;
        }
    }

    private void viewTextContain() {
        try {
            ReadFiles infDF = new ReadFiles();
            System.out.println(infDF.getContenido(true));
        }catch (Exception e){
            int option = numberValidator.getIntegerDataInput(0, 3);
        }
    }

    private void newRegiter() {
        countriesList = countriesRegister.getCountriesList();
        if (countriesList.size() > 0) {
            FileHandler fileHandler = new FileHandler(countriesList);
            fileHandler.run();
        }
    }

    private void viewRegiterInformation() {
        ReadFiles infDF = new ReadFiles("registerCountries.txt");
        System.out.println(infDF.getContenido(true));
    }
}
