package Models;

import java.io.Serializable;


/**
 * @author Not-Aimane
 * @version 1.0
 * @created 09-juin-2017 22:24:31
 */
public class User implements Serializable {

	private String login;
	private String password;
	private int userID;
	private UserInformation userInformation;
	private Profile userProfile;

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the userInformation
     */
    public UserInformation getUserInformation() {
        return userInformation;
    }

    /**
     * @param userInformation the userInformation to set
     */
    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    /**
     * @return the userProfile
     */
    public Profile getUserProfile() {
        return userProfile;
    }

    /**
     * @param userProfile the userProfile to set
     */
    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }

	
}