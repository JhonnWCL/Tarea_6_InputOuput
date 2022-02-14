package helper;

import model.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultData {

    public static List<String> getContinentsList() {
        return Arrays.asList("AFRICA", "AMERICA DEL NORTE", "AMERICA DEL SUR", "ASIA", "EUROPA", "OSEANIA");
    }

    public static List<String> getQuestionsList() {
        return Arrays.asList("Nombre del pais:", "Cantidad poblacional:", "Numero de necimientos registrados ultimamente:", "Numero de muertes registrados ultimament:");
    }

    public static List<String> getTitleText() {
        return Arrays.asList("CONTINENTE", "PAISES", "POBLACION", "T. NATALIDAD P.", "T. MORTALIDAD PA.", "T. NATALIDAD CONT.", "T. MORTALIDAD CONT.", "COMP. T. NATALIDAD CONT.", "COMP. T. MORTALIDAD CONT.");
    }

    public static ArrayList<Country> countriesList() {
        ArrayList<Country> array = new ArrayList<>(Arrays.asList(new Country("AMERICA DEL NORTE", "bolivia", 1212, 122, 1.22),
                new Country("AMERICA DEL NORTE", "Peru", 1212, 12.22, 1),
                new Country("OSEANIA", "Paris", 2332, 11, 1.2)));
        return array;
    }
}
