package utils;

import java.net.MalformedURLException;
import java.net.URL;

public class ExternalViewResourceProvider {

	// private static final String EXTERNAL_RESOURCE_PROVIDER_URL_FORMAT =
	// "http://localhost:8080/provider/resources/external/%S";

	/**
	 * Provides an URL for getting external JSF XHTML views per http-request through url like:<p>
	 * http://<b>hostname</b>:port/external/&lt;viewname&gt;<p>
	 * In order to get it to work the configuration of wildfly's undertow
	 * subsystem must be extended. Add following file handler to handlers list:<p>
	 * <code>
	 * &lt;handlers&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;...<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;file name="<u>external-resources</u>" path="/path/to/external/web/content"/&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;...<br>
	 * &lt;/handlers&gt;<br>
	 * </code><p>
	 * Reference this handler in host's location configuration (for the exactly hotst named <b>hostname</b>):<p>
	 * <code>
	 * &lt;host name="default-host" alias="localhost"&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;...<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;location name="/external" handler="<u>external-resources</u>"/&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;...<br>
	 * &lt;/host&gt;<br>
	 * </code>
	 */
	private static final String EXTERNAL_RESOURCE_PROVIDER_URL_FORMAT = "http://localhost:9090/external/%s";

	public static URL getUrl(String resourceName) throws MalformedURLException {
		return new URL(String.format(EXTERNAL_RESOURCE_PROVIDER_URL_FORMAT, resourceName));
	}

}
