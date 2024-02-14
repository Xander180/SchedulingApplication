package model;

/**
 * Model for Customer.
 *
 * @author Wilson Ramirez
 */
public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerZip;
    private String customerPhone;
    private int countryID;
    private int divisionID;
    private String divisionName;

    /**
     * Constructor for Customer in the database.
     * @param customerID Customer ID.
     * @param customerName Customer name.
     * @param customerAddress Customer address.
     * @param customerZip Customer ZIP/Postal code.
     * @param customerPhone Customer phone number.
     * @param countryID Associated country ID
     * @param divisionID Associated division ID.
     */
    public Customer(int customerID, String customerName, String customerAddress, String customerZip, String customerPhone, int countryID, int divisionID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerZip = customerZip;
        this.customerPhone = customerPhone;
        this.countryID = countryID;
        this.divisionID = divisionID;
    }

    /**
     *
     * @param returnedCustomerId Customer ID for returned customer
     * @param customerName Customer name for returned customer
     */
    public Customer(int returnedCustomerId, String customerName) {
        this.customerID = returnedCustomerId;
        this.customerName = customerName;
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
     * @param customerID Customer ID.
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
     * @param customerName Customer's name
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
     * @param customerAddress Customer's address
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     *
     * @return customer ZIP/Postal code.
     */
    public String getCustomerPostal() {
        return customerZip;
    }

    /**
     * Sets the customer ZIP/Postal code.
     * @param customerZip Customer's postal code
     */
    public void setCustomerPostal(String customerZip) {
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
     * @param customerPhone Customer phone number
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     *
     * @return Customer's associated country ID
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * Set country ID
     * @param countryID Country ID
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
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
     * @param divisionID Division ID
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

    @Override
    public String toString() { return String.valueOf(customerID); }
}
