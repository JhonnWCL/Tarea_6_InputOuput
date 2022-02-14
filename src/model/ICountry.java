package model;

public interface ICountry {
    public String getCountryName();

    public Integer getCountryPopulation();

    public String getCountinentName();

    public double getBirthRate();

    public double getMortalityRate();

    public void setCountryName(String countryName);

    public void setCountryPopulation(Integer countryPopulation);

    public void setMortalityRate(double mortalityRate);

    public void setBirthRate(double birthRate);

    public void setContinentName(String countinentName);
}
