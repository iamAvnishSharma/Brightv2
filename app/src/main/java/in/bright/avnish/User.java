package in.bright.avnish;

/**
 * Created by Avnish on 07-Mar-18.
 */

public class User {
    private String username;
    private String cld;
    private Integer level;

    public User(String username,String cld, Integer level) {
        this.username = username;
        this.cld=cld;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getCld() {
        return cld;
    }

    public Integer getLevel() {
        return level;
    }




}
