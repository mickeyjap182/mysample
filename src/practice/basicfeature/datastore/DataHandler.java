package practice.basicfeature.datastore;


import java.util.Map;

/**
 * vmoptions -Xlog:gc*
 *
 */
public class DataHandler {

    private Map<String, String> config = init();
    private static Map<String, String> init() {
        return Map.of(
            "AWS_ACCESS_KEY_ID","",
            "AWS_SECRET_ACCESS_KEY","",
            "AWS_REGION",""
        );

    }
    public boolean getConnection() {
        return true;
    }
}

