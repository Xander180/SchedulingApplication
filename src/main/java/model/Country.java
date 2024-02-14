package model;

/**
 * Model for Country.
 *
 * @author Wilson Ramirez
 */
public class Country {
    private int countryID;
    private final String countryName;

    private int customerCountByCountry;

    /**
     * Constructor for Country in the database.
     * @param countryID Country ID
     * @param countryName Country name
     */
    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    /**
     * Constructor for sorting number of customers by country.
     * @param countryName Country name
     * @param customerCountByCountry Number of customers by country
     */
    public Country(String countryName, int customerCountByCountry) {
        this.countryName = countryName;
        this.customerCountByCountry = customerCountByCountry;
    }

    /**
     *
     * @return country ID
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     *
     * @return country Name.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @return Number of customers by country
     */
    public int getCustomerCountByCountry() {
        return customerCountByCountry;
    }

    /**
     *
     * @param customerCountByCountry Number of customers by country
     */
    public void setCustomerCountByCountry(int customerCountByCountry) {
        this.customerCountByCountry = customerCountByCountry;
    }

    @Override
    public String toString() { return countryName; }
}
