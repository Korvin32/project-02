package utils;

public class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(int id) {
        super("Product with ID <" + id + "> not found!");
    }

}
