package model;

/**
 * Model for Country.
 *
 * @author Wilson Ramirez
 */
public class Country {
    private int countryID;
    private String countryName;

    private int customerCountByCountry;

    /**
     * Constructor for Country in the database.
     * @param countryID
     * @param countryName
     */
    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

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

    public int getCustomerCountByCountry() {
        return customerCountByCountry;
    }

    public void setCustomerCountByCountry(int customerCountByCountry) {
        this.customerCountByCountry = customerCountByCountry;
    }

    @Override
    public String toString() { return countryName; }
}
