package model;

/**
 * Model for Users.
 *
 * @author Wilson Ramirez
 */
public class Users {
    private int userID;
    private String userName;
    private String userPassword;

    /**
     * Constructor for User accounts in the database.
     * @param userID User ID number.
     * @param userName Username.
     * @param userPassword Password.
     */
    public Users(int userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     *
     * @return user ID number.
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @return user password.
     */
    public String getUserPassword() {
        return userPassword;
    }
}
