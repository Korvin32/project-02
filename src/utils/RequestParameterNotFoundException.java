package utils;

public class RequestParameterNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public RequestParameterNotFoundException(String viewParameterName) {
        super("The request parameter '" + viewParameterName
                + "' not found in reqiest query. It is either not set or explicitly set to null.");
    }
}
