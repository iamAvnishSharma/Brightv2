package in.bright.avnish;

/**
 * Created by Avnish on 07-Mar-18.
 */

public class URLs {
    private static final String USER_URL = "http://irgamerz.com/bright/Api.php?apicall=";
    private static final String FEED_URL = "http://irgamerz.com/bright/feed.php?apicall=";
    private static final String CHAP_URL = "http://irgamerz.com/bright/chap.php?apicall=";
    private static final String EVE_URL = "http://irgamerz.com/bright/eve.php?apicall=";


    public static final String URL_REGISTER = USER_URL + "signup";
    public static final String URL_LOGIN= USER_URL + "login";

    public static final String FEED_DISP= FEED_URL + "disp";
    public static final String FEED_ADD= FEED_URL + "inc";

   // public static final String URL_DISPA= "http://irgamerz.com/bright/feedall.php";

    public static final String CHAP_DISP= CHAP_URL + "disp";
    public static final String CHAP_ADD= CHAP_URL + "inc";

    public static final String EVE_DISP= EVE_URL + "disp";
    public static final String EVE_ADD= EVE_URL + "inc";


}
