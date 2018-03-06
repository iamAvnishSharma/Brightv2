package in.bright.avnish;

/**
 * Created by Avnish on 07-Mar-18.
 */

public class User {
    private String username, level;

    public User(String username, String level) {
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getLevel() {
        return level;
    }


}
