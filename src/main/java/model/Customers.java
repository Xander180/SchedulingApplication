package model;

/**
 * Model for Customers.
 *
 * @author Wilson Ramirez
 */
public class Customers {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerZip;
    private String customerPhone;
    private int divisionID;
    private String divisionName;

    /**
     * Constructor for Customers in the database.
     * @param customerID Customer ID.
     * @param customerName Customer name.
     * @param customerAddress Customer address.
     * @param customerZip Customer ZIP/Postal code.
     * @param customerPhone Customer phone number.
     * @param divisionID Associated division ID.
     * @param divisionName Associated division name.
     */
    public Customers(int customerID, String customerName, String customerAddress, String customerZip, String customerPhone, int divisionID, String divisionName) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerZip = customerZip;
        this.customerPhone = customerPhone;
        this.divisionID = divisionID;
        this.divisionName = divisionName;
    }

    /**
     *
     * @return customer ID.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     *
     * @return customer name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name.
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     *
     * @return customer address.
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the customer address.
     * @param customerAddress
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     *
     * @return customer ZIP/Postal code.
     */
    public String getCustomerZip() {
        return customerZip;
    }

    /**
     * Sets the customer ZIP/Postal code.
     * @param customerZip
     */
    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    /**
     *
     * @return customer phone number.
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Sets the customer phone number.
     * @param customerPhone
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     *
     * @return associated division ID.
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * Sets the associated division ID.
     * @param divisionID
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    /**
     *
     * @return associated division name.
     */
    public String getDivisionName() {
        return divisionName;
    }
}
