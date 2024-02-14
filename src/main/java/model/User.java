package model;

/**
 * Model for User.
 *
 * @author Wilson Ramirez
 */
public record User(int userID, String userName, String userPassword) {
    /**
     * Constructor for User accounts in the database.
     *
     * @param userID       User ID number.
     * @param userName     Username.
     * @param userPassword Password.
     */
    public User {
    }

    /**
     * @return user ID number.
     */
    @Override
    public int userID() {
        return userID;
    }

    /**
     * @return username.
     */
    @Override
    public String userName() {
        return userName;
    }

    /**
     * @return user password.
     */
    @Override
    public String userPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return String.valueOf(userID);
    }
}
