package model;

/**
 * Model for First Level Divisions.
 *
 * @author Wilson Ramirez
 */
public class FirstLevelDivisions {
    private int divisionID;
    private String divisionName;
    private int countryID;

    /**
     * Constructor for first level divisions in the database.
     * @param divisionID Division ID.
     * @param divisionName Division name.
     * @param countryID Associated country ID.
     */
    public FirstLevelDivisions(int divisionID, String divisionName, int countryID) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }

    /**
     *
     * @return division ID.
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     *
     * @return division name.
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     *
     * @return associated country ID.
     */
    public int getCountryID() {
        return countryID;
    }
}
