package model;

/**
 * Model for First Level Divisions.
 *
 * @author Wilson Ramirez
 */
public record FirstLevelDivision(int divisionID, String divisionName, int countryID) {
    /**
     * Constructor for first level divisions in the database.
     *
     * @param divisionID   Division ID.
     * @param divisionName Division name.
     * @param countryID    Associated country ID.
     */
    public FirstLevelDivision {
    }

    /**
     * @return division ID.
     */
    @Override
    public int divisionID() {
        return divisionID;
    }

    /**
     * @return division name.
     */
    @Override
    public String divisionName() {
        return divisionName;
    }

    /**
     * @return associated country ID.
     */
    @Override
    public int countryID() {
        return countryID;
    }

    @Override
    public String toString() {
        return divisionName;
    }
}
