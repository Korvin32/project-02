package utils;

public class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = 4090432274889380817L;

    public ProductNotFoundException(int id) {
        super("Product with ID <" + id + "> not found!");
    }

}
