package model;

/**
 * Model for User.
 *
 * @author Wilson Ramirez
 */
public class User {
    private final int userID;
    private final String userName;
    private final String userPassword;

    /**
     * Constructor for User accounts in the database.
     * @param userID User ID number.
     * @param userName Username.
     * @param userPassword Password.
     */
    public User(int userID, String userName, String userPassword) {
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

    @Override
    public String toString() { return String.valueOf(userID); }
}
