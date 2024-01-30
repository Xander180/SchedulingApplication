package model;

/**
 * Model for Countries.
 *
 * @author Wilson Ramirez
 */
public class Countries {
    private int id;
    private String name;

    /**
     * Constructor for Countries in the database.
     * @param id
     * @param name
     */
    public Countries(int id, String name) {
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
