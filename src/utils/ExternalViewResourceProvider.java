package utils;

import java.net.MalformedURLException;
import java.net.URL;

public class ExternalViewResourceProvider {

//    private static final String EXTERNAL_RESOURCE_PROVIDER_URL_FORMAT = "http://localhost:8080/provider/resources/external/%S";
    private static final String EXTERNAL_RESOURCE_PROVIDER_URL_FORMAT = "http://localhost:9090/external/%s";

    public static URL getUrl(String resourceName) throws MalformedURLException {
        return new URL(String.format(EXTERNAL_RESOURCE_PROVIDER_URL_FORMAT, resourceName));
    }

}
