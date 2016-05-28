package utils;

public class CategoryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(int id) {
		super("Category with ID <" + id + "> not found!");
	}

}
