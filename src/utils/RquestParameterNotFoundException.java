package utils;

public class RquestParameterNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public RquestParameterNotFoundException(String viewParameterName) {
        super("The request parameter '" + viewParameterName
                + "' not found in reqiest query. It is either not set or explicitly set to null.");
    }
}
