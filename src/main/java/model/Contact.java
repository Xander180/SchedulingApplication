package model;

/**
 * Model for Contact.
 *
 * @author Wilson Ramirez
 */
public record Contact(int contactID, String contactName, String contactEmail) {
    /**
     * Constructor for Contact in the database.
     *
     * @param contactID    Contact ID.
     * @param contactName  Contact name.
     * @param contactEmail Contact email address.
     */
    public Contact {
    }

    /**
     * @return contact ID.
     */
    @Override
    public int contactID() {
        return contactID;
    }

    /**
     * @return contact name.
     */
    @Override
    public String contactName() {
        return contactName;
    }

    /**
     * @return contact email address.
     */
    @Override
    public String contactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() {
        return contactName;
    }
}
