package model;

/**
 * Model for Country.
 *
 * @author Wilson Ramirez
 */
public class Country {
    private int id;
    private String name;

    /**
     * Constructor for Country in the database.
     * @param id
     * @param name
     */
    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return country ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return country Name.
     */
    public String getName() {
        return name;
    }
}
