package model;

public class Country implements ICountry {
    private String countryName;
    private String countinentName;
    private Integer populationQuantity;
    private double mortalityRate;
    private double birthRate;

    public Country() {
        countryName = "";
        mortalityRate = -1;
        birthRate = -1;
        populationQuantity = -1;
    }

    public Country(String countinentName, String countryName, Integer populationQuantity, double mortalityRate, double birthRate) {
        this.countryName = countryName;
        this.countinentName = countinentName;
        this.populationQuantity = populationQuantity;
        this.mortalityRate = mortalityRate;
        this.birthRate = birthRate;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    @Override
    public String getCountinentName() {
        return countinentName;
    }

    @Override
    public Integer getCountryPopulation() {
        return populationQuantity;
    }

    @Override
    public double getBirthRate() {
        return mortalityRate;
    }

    @Override
    public double getMortalityRate() {
        return birthRate;
    }

    @Override
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public void setContinentName(String countinentName) {
        this.countinentName = countinentName;
    }

    @Override
    public void setCountryPopulation(Integer countryPopulation) {
        this.populationQuantity = countryPopulation;
    }

    @Override
    public void setMortalityRate(double tazaMortalidad) {
        this.mortalityRate = tazaMortalidad;
    }

    @Override
    public void setBirthRate(double birthRate) {
        this.birthRate = birthRate;
    }
}