package controller.files;

import helper.DefaultData;
import helper.Print;
import model.Country;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class ProcessTextFile {
    public static int[] boxSize;

    public ProcessTextFile() {
        boxSize = new int[]{11, 7, 10, 16, 17, 19, 20, 25, 26,};
    }

    public void updateMaxLengtLine(ArrayList<Country> countriesList) {
        for (Country c : countriesList) {
            updateLengthBox(c.getCountinentName().length(), 0);
            updateLengthBox(c.getCountryName().length(), 1);
            updateLengthBox((c.getCountryPopulation() + "").length(), 2);
            updateLengthBox((c.getMortalityRate() + "").length(), 3);
            updateLengthBox((c.getBirthRate() + "").length(), 4);
        }
    }

    private void updateLengthBox(int a, int index) {
        if (boxSize[index] < a) boxSize[index] = a;
    }

    public int getLengtRecuadro() {
        int res = boxSize.length;
        for (Integer num : boxSize) {
            res += 2 + num;
        }
        return res;
    }

    public String addSpace(int n, String word) {
        int res = (boxSize[n] - word.length()) + 2;
        return (String.format("%0" + res + "d", 0).replace("0", " ") + "|");
    }

    public String concatText(String countinentName, String countryName, String population, String tasaN, String tasaM, String tasaNC, String tasaaMC, String comparaTNC, String comparaTMC) {
        String respuesta = "\n|" + countinentName + addSpace(0, countinentName) + countryName +
                addSpace(1, countryName) + population +
                addSpace(2, population) + tasaN + addSpace(3, tasaN) + tasaM + addSpace(4, tasaM) + tasaNC +
                addSpace(5, tasaNC) + tasaaMC + addSpace(6, tasaaMC) + comparaTNC + addSpace(7, comparaTNC) + comparaTMC + addSpace(8, comparaTMC);
        return respuesta;
    }

    public String getTitleFile() {
        String res = "|" + Print.printDelimiter(getLengtRecuadro()) + "\n|";
        for (int i = 0; i < DefaultData.getTitleText().size(); i++) {
            res += DefaultData.getTitleText().get(i) + addSpace(i, DefaultData.getTitleText().get(i));
        }
        return res += "\n|" + Print.printDelimiter(getLengtRecuadro());
    }

    public String concatInformationC(int filaTabla, int position, Country country, String promedioTN, String promedioTM, String compartionTN, String compartionTM) {
        String res = "";
        if (filaTabla == position)
            res += concatText(country.getCountinentName(), country.getCountryName(), country.getCountryPopulation() + "", country.getMortalityRate() + "",
                    country.getBirthRate() + "", promedioTN, promedioTM, compartionTN, compartionTM);
        else
            res += concatText("", country.getCountryName(), country.getCountryPopulation() + "", country.getMortalityRate() + "",
                    country.getBirthRate() + "", "", "", "", "");
        return res;
    }

    public String parseDoubleSt(double num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }

    public void sortListMap(ArrayList<Country> countriesList) {
        countriesList.sort(Comparator.comparing(o -> o.getCountinentName()));
        countriesList.sort((p1, p2) -> p1.getCountinentName().compareToIgnoreCase(p2.getCountinentName()));
    }

    public String concatDatesComparing(String nombreCont1, String nombreCont2, double[] tasas) {
        boolean isEquals = (nombreCont1.equalsIgnoreCase(nombreCont2)) ? true : false;
        String tasaN = (tasas[0] < 0) ? "AUMENTO" : "DECRECIO";
        String tasaM = (tasas[1] < 0) ? "AUMENTO" : "DECRECIO";
        double dataN = Math.abs(tasas[0]);
        double dataM = Math.abs(tasas[1]);
        return concatResulComparacion(isEquals, nombreCont1, nombreCont2, tasaN,tasaM , dataN, dataM);//resp;
    }

    private String concatResulComparacion(boolean isEquals, String nombreCont1, String nombreCont2, String tasaN,String tasaM , double dataN,double dataM) {
        String resp = "";
        resp += "\n\nEl continente " + nombreCont1 + " presenta la mayor tasa de nataliad y " + tasaN + " en un " + dataN + " % Con respecto al anio anterior";
        if (!isEquals)
            resp += "\n\nEl continente " + nombreCont2 + " presenta la mayor tasa de mortalidad y " + tasaM + " en un " + dataM + " %  Con respecto al anio anterior";
        else
            resp += "\nEs este mismo continente quien presenta la mayor tasa de mortalidad y " + tasaM + " es un " + dataM + " %  Con respecto al anio anterior";
        return resp;
    }
}
