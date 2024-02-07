package model;

/**
 * Model for Contacts.
 *
 * @author Wilson Ramirez
 */
public class Contacts {
    private int contactID;
    private String contactName;
    private String contactEmail;

    /**
     * Constructor for Contacts in the database.
     * @param contactID Contact ID.
     * @param contactName Contact name.
     * @param contactEmail Contact email address.
     */
    public Contacts(int contactID, String contactName, String contactEmail) {
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
