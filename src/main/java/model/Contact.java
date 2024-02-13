package model;

/**
 * Model for Contact.
 *
 * @author Wilson Ramirez
 */
public class Contact {
    private final int contactID;
    private final String contactName;
    private final String contactEmail;

    /**
     * Constructor for Contact in the database.
     * @param contactID Contact ID.
     * @param contactName Contact name.
     * @param contactEmail Contact email address.
     */
    public Contact(int contactID, String contactName, String contactEmail) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    /**
     *
     * @return contact ID.
     */
    public int getContactID() {
        return contactID;
    }

    /**
     *
     * @return contact name.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     *
     * @return contact email address.
     */
    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() { return contactName; }
}
