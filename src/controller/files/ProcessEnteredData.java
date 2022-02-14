package controller.files;

import helper.Print;
import model.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessEnteredData {
    private Map<String, double[]> dataCompare;
    private ProcessTextFile processTextFile;
    private ArrayList<Country> countryList;
    private StringBuilder sb;
    private String[] continentNamesMRV;
    private double[] maximumRateValues;

    public ProcessEnteredData(ArrayList<Country> countryList) {
        dataCompare = new HashMap<>();
        processTextFile = new ProcessTextFile();
        processTextFile.updateMaxLengtLine(countryList);
        sb = new StringBuilder();
        this.countryList = countryList;
        continentNamesMRV = new String[2];
        maximumRateValues = new double[]{0.0, 0.0};
    }

    public void setDataCompare(Map<String, double[]> dataCompare) {
        this.dataCompare = dataCompare;
    }

    public String getTextWriter() {
        sb.append(processTextFile.getTitleFile());
        processTextFile.sortListMap(countryList);
        String firstName = countryList.get(0).getCountinentName();
        concatEnterednformation(0, 0, firstName);
        concatComparedInformation();
        return sb.toString();
    }

    private void concatEnterednformation(double promedioTN, double promedioTM, String nameContinent) {
        ArrayList<Country> countriesListTemp = new ArrayList<>();
        for (int i = 0; i < countryList.size(); i++) {
            Country country = countryList.get(i);
            if (country.getCountinentName().equals(nameContinent)) {
                promedioTM += country.getBirthRate();
                promedioTN += country.getMortalityRate();
                countriesListTemp.add(country);
                if (i == countryList.size() - 1) {
                    concatDatesCountry(countriesListTemp, promedioTN, promedioTM);
                }
            } else {
                concatDatesCountry(countriesListTemp, promedioTN, promedioTM);
                promedioTM = 0;
                promedioTN = 0;
                countriesListTemp = new ArrayList<>();
                nameContinent = country.getCountinentName();
                i--;
            }
        }
    }

    private void concatDatesCountry(ArrayList<Country> countryList, double averageTN, double averageTM) {
        int centralPosition = countryList.size() / 2;
        double averageTNTemp = averageTN / countryList.size(), promTM = averageTM / countryList.size();
        String comparisonTN = getTextRateComparison(countryList.get(0).getCountinentName(), averageTNTemp, true);
        String comparisonTM = getTextRateComparison(countryList.get(0).getCountinentName(), promTM, false);
        averageComparison(countryList.get(0).getCountinentName(), averageTNTemp, promTM);
        for (int i = 0; i < countryList.size(); i++) {
            sb.append(processTextFile.concatInformationC(i, centralPosition, countryList.get(i), processTextFile.parseDoubleSt(averageTNTemp), processTextFile.parseDoubleSt(promTM), comparisonTN, comparisonTM));
        }
        sb.append("\n|" + Print.printDelimiter(processTextFile.getLengtRecuadro()));
    }

    private String getTextRateComparison(String countinentName, double tasa, boolean isTassaNatalidad) {
        int index = (isTassaNatalidad) ? 0 : 1;
        StringBuilder sb = new StringBuilder();
        dataCompare.entrySet().stream().forEach(x -> {
            if (x.getKey().equalsIgnoreCase(countinentName)) {
                if (x.getValue()[index] > tasa) sb.append("Decrecio");
                else sb.append("Aumento");
            }
        });
        return sb.toString();
    }

    private void averageComparison(String nameContint, double promTN, double promTM) {
        if (maximumRateValues[0] < promTN) {
            maximumRateValues[0] = promTN;
            continentNamesMRV[0] = nameContint;
        }
        if (maximumRateValues[1] < promTM) {
            maximumRateValues[1] = promTM;
            continentNamesMRV[1] = nameContint;
        }
    }

    private double[] getTextHigherRager() {
        double restoNat = dataCompare.get(continentNamesMRV[0])[0] - maximumRateValues[0];
        double restoMat = dataCompare.get(continentNamesMRV[1])[1] - maximumRateValues[1];
        return new double[]{restoNat, restoMat};
    }

    private void concatComparedInformation() {
        String name1 = continentNamesMRV[0];
        String name2 = continentNamesMRV[1];
        String result = processTextFile.concatDatesComparing(name1, name2, getTextHigherRager());
        sb.append(result);
    }
}
