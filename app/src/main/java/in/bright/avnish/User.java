package in.bright.avnish;

/**
 * Created by Avnish on 07-Mar-18.
 */

public class User {
    private String username;
    private Integer level;

    public User(String username, Integer level) {
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public Integer getLevel() {
        return level;
    }


}
