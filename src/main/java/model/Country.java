package model;

/**
 * Model for Country.
 *
 * @author Wilson Ramirez
 */
public class Country {
    private final int countryID;
    private final String countryName;

    /**
     * Constructor for Country in the database.
     * @param countryID
     * @param countryName
     */
    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
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

    @Override
    public String toString() { return countryName; }
}
