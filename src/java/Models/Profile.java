package Models;

import java.io.Serializable;
import java.util.List;


/**
 * @author Not-Aimane
 * @version 1.0
 * @created 09-juin-2017 22:24:31
 */
public class Profile implements Serializable {

	private int profileID;
	private String profileName;
	private List<User> usersList;

    /**
     * @return the profileID
     */
    public int getProfileID() {
        return profileID;
    }

    /**
     * @param profileID the profileID to set
     */
    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the profileName
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * @param profileName the profileName to set
     */
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    /**
     * @return the usersList
     */
    public List<User> getUsersList() {
        return usersList;
    }

    /**
     * @param usersList the usersList to set
     */
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }


}